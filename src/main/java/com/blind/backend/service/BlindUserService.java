package com.blind.backend.service;

import com.blind.backend.entity.BlindUser;

public interface BlindUserService {

    BlindUser findBlindUserById(Long blindUserId);

    void confirmBlindUser(BlindUser blindUser);
}
