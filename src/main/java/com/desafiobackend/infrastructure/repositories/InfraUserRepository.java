package com.desafiobackend.infrastructure.repositories;

import com.desafiobackend.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfraUserRepository extends JpaRepository<UserEntity, Long> {
}
