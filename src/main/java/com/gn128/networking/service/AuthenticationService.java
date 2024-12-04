package com.gn128.networking.service;

import com.gn128.networking.authentication.JwtService;
import com.gn128.networking.entity.User;
import com.gn128.networking.payload.JwtResponse;
import com.gn128.networking.payload.LoginRequest;
import com.gn128.networking.payload.ModuleResponse;
import com.gn128.networking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.service
 * Created_on - December 04 - 2024
 * Created_at - 19:08
 */

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    public JwtResponse loginUser(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetails principal = (UserDetails) authenticate.getPrincipal();
        User user = userRepository.findByEmail(principal.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found by Email"));
        String accessToken = jwtService.generateToken(user);
        return JwtResponse
                .builder()
                .accessToken(accessToken)
                .userId(user.getUserId())
                .build();
    }
}
