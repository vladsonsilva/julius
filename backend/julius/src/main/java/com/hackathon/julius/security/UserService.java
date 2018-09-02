package com.hackathon.julius.security;

import com.hackathon.julius.entity.Usuario;
import com.hackathon.julius.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioRepository.findByUsuario(username));

        if (!optionalUsuario.isPresent()) throw new UsernameNotFoundException("User not found.");

        return new UserAuthentication(optionalUsuario.get());
    }
}
