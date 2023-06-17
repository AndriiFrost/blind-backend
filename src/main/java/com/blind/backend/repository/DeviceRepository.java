package com.blind.backend.repository;

import com.blind.backend.entity.BlindUserEntity;
import com.blind.backend.entity.DeviceEntity;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

    List<DeviceEntity> findAllByBlindUserEntityIsNull();

    List<DeviceEntity> findAllByBlindUserEntity(BlindUserEntity blindUserEntity);

    Optional<DeviceEntity> findByBlindUserEntityAndDeviceId(BlindUserEntity blindUserEntity, Long deviceId);

    Optional<DeviceEntity> findBySpecialDeviceCodeAndSpecialDevicePasswordCode(String specialDeviceCode,
                                                                 String specialDevicePasswordCode);
}
