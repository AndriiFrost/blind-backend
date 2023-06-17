package com.blind.backend.service;

import com.blind.backend.entity.BlindUserEntity;

public interface BlindUserService {

    BlindUserEntity findBlindUserById(Long blindUserId);


    BlindUserEntity findCurrentUser();

    void confirmBlindUser(BlindUserEntity blindUserEntity);
}
