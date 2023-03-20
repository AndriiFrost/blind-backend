package com.blind.backend.service;


import com.blind.backend.entity.UserVerificationToken;

public interface UserVerificationTokenService {

    UserVerificationToken createUserVerificationToken(Long blindUserId);

    void confirmToken(String token);
}
