package com.blind.backend.repository;

import com.blind.backend.entity.BlindUserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlindUserRepository extends JpaRepository<BlindUserEntity, Long> {

    Optional<BlindUserEntity> findByEmail(String email);

}
