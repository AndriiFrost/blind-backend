package com.blind.backend.repository;

import com.blind.backend.entity.BlindUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlindUserRepository extends JpaRepository<BlindUser, Long> {

    Optional<BlindUser> findByEmail(String email);

}
