package com.desafiobackend.domain.repositories;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.dto.request.transaction.CreateTransactionRequestDTO;

public interface TransactionRepository {
    Transaction createTransaction(CreateTransactionRequestDTO requestDTO) throws Exception;
}
