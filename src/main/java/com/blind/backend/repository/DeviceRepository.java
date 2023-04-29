package com.blind.backend.repository;

import com.blind.backend.entity.DeviceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    List<DeviceEntity> findAllByBlindUserEntityIsNull();
}
