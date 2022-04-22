package com.gft.security;

import com.gft.model.Usuario;
import com.gft.service.EmailService;
import com.gft.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private UsuarioService usuarioService;
    private EmailService emailService;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioService usuarioService,EmailService emailService) {
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.emailService = emailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if (valido){
            autentitcarCliente(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autentitcarCliente(String token){
        Long idUsuario = tokenService.getIdUsuario(token);
        Usuario usuario = usuarioService.buscaPorId(idUsuario);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        emailService.enviarEmail(usuario);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
