package com.tekup.hotel.hotel.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tekup.hotel.hotel.dto.ApiResponse;
import com.tekup.hotel.hotel.dto.ClientPrincipal;
import com.tekup.hotel.hotel.dto.LoginRequest;
import com.tekup.hotel.hotel.dto.SignUpRequest;
import com.tekup.hotel.hotel.model.Client;
import com.tekup.hotel.hotel.security.JwtTokenProvider;
import com.tekup.hotel.hotel.service.ClientService;
import com.tekup.hotel.hotel.service.CustomClientDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenUtil;
	@Autowired
	private CustomClientDetailsService clientDetailsService;
	@Autowired
	private ClientService clientService;
	@Autowired
    PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenProvider tokenProvider;
	@PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getCourriel(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        ClientPrincipal user = tokenProvider.getUser(authentication);
        Client cl = new Client(user.getId(),user.getNom(),user.getPrenom(),user.getCourriel(),user.getTelephone(),user.getDateDeNaissance(),user.getEnfant(),user.getPassword(),
        		user.getReservations(),user.getFactures());
        HashMap<String, Object> re = new HashMap<String, Object>();
        re.put("jwtToken", jwt);
        re.put("client", cl);
        //SendEmail.sendmail(loginRequest.getEmail(), "login", "you login");
        return ResponseEntity.ok(re);
    }
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	/*@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(clientService.existsByCourrier(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Client user = new Client(null,signUpRequest.getFirstName(), signUpRequest.getLastName(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (!roleRepository.findByName(RoleName.ROLE_ADMIN).isPresent() ) {
        	Role roleUser = new Role();
            roleUser.setName(RoleName.ROLE_ADMIN);
            roleRepository.save(roleUser);
        }
      
        
        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getFirstName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }*/
	/*@PutMapping("/updatepassword")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody LoginRequest loginRequest) {
		User user = userService.findByEmail(loginRequest.getEmail());
		if(user == null) {
            return new ResponseEntity(new ApiResponse(false, "Email not exist!"),
                    HttpStatus.BAD_REQUEST);
        }
		user.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
		User userupdated = userService.save(user);
		URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(user.getEmail()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "password updated successfully"));
	}*/
}
