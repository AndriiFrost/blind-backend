package com.blind.backend.service.impl;

import com.blind.backend.entity.BlindUserEntity;
import com.blind.backend.repository.BlindUserRepository;
import com.blind.backend.service.BlindUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlindUserServiceImpl implements BlindUserService {

    private final BlindUserRepository blindUserRepository;

    @Override
    public BlindUserEntity findBlindUserById(Long blindUserId) {
        return blindUserRepository.findById(blindUserId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void confirmBlindUser(BlindUserEntity blindUserEntity) {
        blindUserEntity.setConfirmed(true);
        blindUserRepository.saveAndFlush(blindUserEntity);
    }
}
