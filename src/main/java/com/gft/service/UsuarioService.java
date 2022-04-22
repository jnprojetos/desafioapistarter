package com.gft.service;

import com.gft.exception.RegraNegocioException;
import com.gft.model.Perfil;
import com.gft.model.Usuario;
import com.gft.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilService perfilService;

    @Transactional
    public Usuario novoUsuario(Usuario usuario){
        Perfil perfil = perfilService.buscaPorNome(usuario.getPerfil().getNome());
        boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
                .stream().anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
        if (emailEmUso){
            throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail.");
        }else{
            usuario.setPerfil(perfil);
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
    }
    public Usuario buscarUsuarioEmail(String email){
        var usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário ou senha inválido"));
        return usuario;
    }

    public Usuario buscaPorId(Long id){
        return usuarioRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioEmail(username);
    }
}
