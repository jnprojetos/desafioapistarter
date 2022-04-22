package com.gft.service;

import com.gft.dto.CategoriaDTO;
import com.gft.dto.StarterDTO;
import com.gft.dto.StarterDTOInput;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.exception.RegraNegocioException;
import com.gft.mapper.CategoriaMapper;
import com.gft.mapper.StarterMapper;
import com.gft.model.Starter;
import com.gft.repository.StarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StarterService {

    @Autowired
    private StarterRepository starterRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Transactional
    public StarterDTO novoStarter(StarterDTOInput starterDTOInput, MultipartFile foto) throws IOException {
        boolean starterJaCadastrado = starterRepository.findByCpf(starterDTOInput.getCpf())
                .stream().anyMatch(starterExistente -> !starterExistente.equals(starterDTOInput));
        if (starterJaCadastrado){
            throw new RegraNegocioException("Já existe um starter cadastrado com esse cpf.");
        }else {
            CategoriaDTO categoria = categoriaService.buscarPorId(starterDTOInput.getCategoria().getId());
            starterDTOInput.setCategoria(categoria);
            starterDTOInput.setFoto(foto.getBytes());
            return StarterMapper.starterDTO(starterRepository.save(StarterMapper.toStarter(starterDTOInput)));
        }
    }

    @Transactional
    public StarterDTO alterarStarter(Long id, StarterDTOInput starterDTOInput, MultipartFile foto) throws IOException {
        Starter starter = starterRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Starte não encontrado"));
        CategoriaDTO categoria = categoriaService.buscarPorId(starterDTOInput.getCategoria().getId());
        starterDTOInput.setCategoria(categoria);
        starterDTOInput.setFoto(foto.getBytes());
        starter.setNome(starterDTOInput.getNome());
        starter.setCategoria(CategoriaMapper.toCategoriaInput(starterDTOInput.getCategoria()));
        starter.setCpf(starterDTOInput.getCpf());
        starter.setEmail(starterDTOInput.getEmail());
        starter.setQuatroLetras(starterDTOInput.getQuatroLetras());
        starter.setImagem(starterDTOInput.getFoto());

        return StarterMapper.starterDTO(starterRepository.save(starter));
    }

    public Page<StarterDTO> listarTodos(Pageable pageable){
        Page<Starter> starters = starterRepository.findAll(pageable);
        return starters.map(starter -> StarterMapper.starterDTO(starter));
    }

    public StarterDTO buscarPorNome(String nome){
        Starter starter = starterRepository.findByNome(nome).orElseThrow(()-> new EntidadeNaoEncontradaException("Starte não encontrado"));
        return StarterMapper.starterDTO(starter);
    }

    @Transactional
    public void excluirStarter(Long id){
        Starter starter = starterRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Starter não encontrado."));
        starterRepository.delete(starter);
    }
}
