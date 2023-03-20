package com.blind.backend.controller;


import com.blind.backend.service.UserVerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class UserVerificationTokenController {

    private final UserVerificationTokenService userVerificationTokenService;

    @GetMapping("confirm")
    public void register(@RequestParam("token") String token) {
        userVerificationTokenService.confirmToken(token);
    }
}
