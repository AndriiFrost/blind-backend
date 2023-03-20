package com.blind.backend.service;


import com.blind.backend.dto.request.AuthenticationRequest;
import com.blind.backend.dto.request.RegisterRequest;
import com.blind.backend.dto.response.AuthenticationResponse;

public interface AuthService {
    void register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
