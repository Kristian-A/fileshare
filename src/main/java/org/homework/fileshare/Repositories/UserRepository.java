package org.homework.fileshare.Repositories;

import org.homework.fileshare.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    UserEntity findByEmailIdIgnoreCase(String emailId);
}

