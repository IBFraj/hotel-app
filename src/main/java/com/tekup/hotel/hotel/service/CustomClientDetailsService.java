package com.tekup.hotel.hotel.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tekup.hotel.hotel.dto.ClientPrincipal;
import com.tekup.hotel.hotel.model.Client;
import com.tekup.hotel.hotel.repository.ClientRepository;

@Service
public class CustomClientDetailsService implements UserDetailsService {

    @Autowired
   ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        /*User user = userRepository.findByEmail(email)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );*/
    	Client l = clientRepository.findByCourriel(email);
        if (l != null) {
        	return ClientPrincipal.create(l);
        }
        return null;
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Client user = clientRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("Client not found with id : " + id)
        );

        return ClientPrincipal.create(user);
    }
}