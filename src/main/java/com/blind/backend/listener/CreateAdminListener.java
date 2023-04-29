package com.blind.backend.listener;

import com.blind.backend.entity.BlindUserEntity;
import com.blind.backend.entity.enumeration.Role;
import com.blind.backend.repository.BlindUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAdminListener {

    @Value("${device.user.admin.firstName}")
    private String adminFirstName;

    @Value("${device.user.admin.lastName}")
    private String adminLastName;

    @Value("${device.user.admin.email}")
    private String adminEmail;

    @Value("${device.user.admin.password}")
    private String adminPassword;

    private final BlindUserRepository blindUserRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void createAdminUser(){
        if(blindUserRepository.findByEmail(adminEmail).isPresent()){
            return;
        }
        BlindUserEntity blindUserEntity = BlindUserEntity.builder()
                .firstName(adminFirstName)
                .lastName(adminLastName)
                .email(adminEmail)
                .password(passwordEncoder.encode(adminPassword))
                .role(Role.ADMIN)
                .confirmed(true)
                .build();
        blindUserRepository.save(blindUserEntity);
    }
}
