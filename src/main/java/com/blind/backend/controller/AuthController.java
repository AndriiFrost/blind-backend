package com.blind.backend.controller;

import com.blind.backend.dto.request.AuthenticationRequest;
import com.blind.backend.dto.request.RegisterRequest;
import com.blind.backend.dto.response.AuthenticationResponse;
import com.blind.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
