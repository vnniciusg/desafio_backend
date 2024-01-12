package com.desafiobackend.infrastructure.mapper.transaction;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.infrastructure.entities.TransactionEntity;

public interface TransactionMapper {
    Transaction toTransaction(TransactionEntity transactionEntity);
}
