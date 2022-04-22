package com.gft.service;

import com.gft.dto.CategoriaDTO;
import com.gft.dto.CategoriaDTOInput;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.exception.RegraNegocioException;
import com.gft.mapper.CategoriaMapper;
import com.gft.model.Categoria;
import com.gft.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public CategoriaDTO novaCategoria(CategoriaDTOInput cagoriaDTDtoInput){
        boolean categoriaEmUso = categoriaRepository.findByDescricaoAndTecnologia(cagoriaDTDtoInput.getDescricao(), cagoriaDTDtoInput.getTecnologia())
                .stream().anyMatch(categoriaExistente -> !categoriaExistente.equals(cagoriaDTDtoInput));
        if (categoriaEmUso){
            throw new RegraNegocioException("Catagoria já cadastrada.");
        }else {
            return CategoriaMapper.toCategoriaDTO(categoriaRepository.save(CategoriaMapper.toCategoria(cagoriaDTDtoInput)));
        }
    }

    public Page<CategoriaDTO> listarCategorias(Pageable pageable){
        Page<Categoria> categorias = categoriaRepository.findAll(pageable);
        return categorias.map(categoria -> CategoriaMapper.toCategoriaDTO(categoria));
    }

    public CategoriaDTO buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Categoria não encontrada"));
        return CategoriaMapper.toCategoriaDTO(categoria);
    }

    @Transactional
    public CategoriaDTO alterarCategoria(Long id, CategoriaDTOInput categoriaDTOInput) {
        Categoria categoria = categoriaRepository.findById(id).get();
        if (categoria == null){
            throw new EntidadeNaoEncontradaException("Categoria não encontrada.");
        }else{
            categoria.setId(id);
            categoria.setDescricao(categoriaDTOInput.getDescricao());
            categoria.setTecnologia(categoriaDTOInput.getTecnologia());
            return CategoriaMapper.toCategoriaDTO(categoriaRepository.save(categoria));
        }
    }

    @Transactional
    public void excluirCategoria(Long id){
         Optional<Categoria> categoria = categoriaRepository.findById(id);
         if (categoria.isEmpty()){
             throw new EntidadeNaoEncontradaException("Categoria não encontrada");
         }
         if(categoriaRepository.possuiStarters(id)){
             throw new RegraNegocioException("Categoria possui starters vinculados.");
         }
             categoriaRepository.delete(categoria.get());
    }
}
