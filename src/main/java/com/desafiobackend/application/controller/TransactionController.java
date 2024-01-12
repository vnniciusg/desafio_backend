package com.desafiobackend.application.controller;

import com.desafiobackend.application.service.transaction.TransactionService;
import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.dto.request.transaction.CreateTransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody CreateTransactionRequestDTO requestDTO) throws Exception {
        Transaction transaction = this.transactionService.createTransaction(requestDTO);
        return new ResponseEntity<>(transaction,HttpStatus.CREATED);
    }
}
