package com.gn128.networking.controller;

import com.gn128.networking.payload.JwtResponse;
import com.gn128.networking.payload.LoginRequest;
import com.gn128.networking.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author - rohit
 * Project - networking
 * Package - com.gn128.networking.controller
 * Created_on - December 04 - 2024
 * Created_at - 19:05
 */

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authenticationService.loginUser(loginRequest);
    }
}
