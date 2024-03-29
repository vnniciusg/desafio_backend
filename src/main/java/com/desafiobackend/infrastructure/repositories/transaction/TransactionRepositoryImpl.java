package com.desafiobackend.infrastructure.repositories.transaction;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.domain.repositories.TransactionRepository;
import com.desafiobackend.dto.request.transaction.CreateTransactionRequestDTO;
import com.desafiobackend.infrastructure.entities.TransactionEntity;
import com.desafiobackend.infrastructure.entities.UserEntity;
import com.desafiobackend.infrastructure.mapper.transaction.TransactionMapper;
import com.desafiobackend.infrastructure.mapper.user.UserMapper;
import com.desafiobackend.infrastructure.repositories.user.InfraUserRepository;
import com.desafiobackend.services.AuthorizationService;
import com.desafiobackend.services.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final InfraTransactionRepository infraTransactionRepository;
    private final InfraUserRepository infraUserRepository;
    private final UserMapper userMapper;
    private final TransactionMapper transactionMapper;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    @Autowired
    public TransactionRepositoryImpl(InfraTransactionRepository infraTransactionRepository, InfraUserRepository infraUserRepository, UserMapper userMapper, TransactionMapper transactionMapper, AuthorizationService authorizationService, NotificationService notificationService) {
        this.infraTransactionRepository = infraTransactionRepository;
        this.infraUserRepository = infraUserRepository;
        this.userMapper = userMapper;
        this.transactionMapper = transactionMapper;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }

    @Override
    @Transactional
    public Transaction createTransaction(CreateTransactionRequestDTO requestDTO) throws Exception {

        UserEntity payeeEntity = infraUserRepository.findById(requestDTO.payee()).orElseThrow(() ->new EntityNotFoundException("Beneficiário com ID " + requestDTO.payee() + " não encontrado"));
        UserEntity payerEntity = infraUserRepository.findById(requestDTO.payer()).orElseThrow(() ->new EntityNotFoundException("Pagador com ID " + requestDTO.payer() + " não encontrado"));

        User payer = userMapper.toUser(payerEntity);
        User payee = userMapper.toUser(payeeEntity);

        payer.validateTransaction(requestDTO.value());

        boolean IsAuthorized = this.authorizationService.authorizeTransaction(payer, requestDTO.value());
        if (!IsAuthorized){
            throw new Exception("Transação não autorizada");
        }

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setPayer(payerEntity);
        transactionEntity.setPayee(payeeEntity);
        transactionEntity.setAmount(requestDTO.value());
        transactionEntity.setLocalDateTime(LocalDateTime.now());

        payeeEntity.setBalance(payeeEntity.getBalance().add(requestDTO.value()));
        payerEntity.setBalance(payerEntity.getBalance().subtract(requestDTO.value()));

        this.infraUserRepository.save(payeeEntity);
        this.infraUserRepository.save(payeeEntity);

        TransactionEntity transactionEntityResponse = this.infraTransactionRepository.save(transactionEntity);

        notificationService.sendNotification(payer,"Transação realizada com sucesso");
        notificationService.sendNotification(payee,"Transação recebida com sucesso");

        return transactionMapper.toTransaction(transactionEntityResponse);

    }
}
