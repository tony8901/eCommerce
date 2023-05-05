package com.ecommerce.backend.security.service;


import com.ecommerce.backend.security.entities.User;
import com.ecommerce.backend.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Autentica un usuario de la base de datos
 * Authentication Manager llama al método loadUserByUsername de esta clase
 * para obtener los detalles del usuario de la base de datos cuando
 * se intente autenticar un usuario
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRespository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRespository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //buscar en la base de datos los detalles del usuario
        User user = userRespository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));

        //devolver el usuario de tu base de datos en un objeto UserDetails de spring
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), getAuthority(user));
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    }
