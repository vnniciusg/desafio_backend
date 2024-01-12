package com.desafiobackend.infrastructure.repositories.transaction;

import com.desafiobackend.infrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraTransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
