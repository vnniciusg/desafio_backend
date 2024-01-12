package com.desafiobackend.application.service.transaction;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.dto.request.transaction.CreateTransactionRequestDTO;

public interface TransactionService {

    Transaction createTransaction (CreateTransactionRequestDTO requestDTO) throws Exception;
}
