package com.desafiobackend.application.service.transaction;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.domain.repositories.TransactionRepository;
import com.desafiobackend.dto.request.transaction.CreateTransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(CreateTransactionRequestDTO requestDTO) throws Exception {
        return this.transactionRepository.createTransaction(requestDTO);
    }
}
