package com.blind.backend.service.impl;

import com.blind.backend.entity.BlindUser;
import com.blind.backend.entity.UserVerificationToken;
import com.blind.backend.repository.UserVerificationTokenRepository;
import com.blind.backend.service.BlindUserService;
import com.blind.backend.service.UserVerificationTokenService;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserVerificationTokenServiceImpl implements UserVerificationTokenService {

    private final UserVerificationTokenRepository userVerificationTokenRepository;

    private final BlindUserService blindUserService;

    @Override
    @Transactional
    public UserVerificationToken createUserVerificationToken(Long blindUserId) {
        BlindUser blindUser = blindUserService.findBlindUserById(blindUserId);
        UserVerificationToken verificationToken = UserVerificationToken.builder()
                .blindUser(blindUser)
                .token(UUID.randomUUID().toString())
                .expiresAt(LocalDateTime.now().plusDays(1))
                .build();
        userVerificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public void confirmToken(String token) {
        UserVerificationToken userVerificationToken = userVerificationTokenRepository.findByToken(token)
                .orElseThrow(IllegalStateException::new);

        if (LocalDateTime.now().isAfter(userVerificationToken.getExpiresAt())) {
            throw new IllegalStateException("token expired");
        }

        blindUserService.confirmBlindUser(userVerificationToken.getBlindUser());
    }
}
