package com.desafiobackend.infrastructure.mapper.transaction;

import com.desafiobackend.domain.entities.Transaction;
import com.desafiobackend.infrastructure.entities.TransactionEntity;
import com.desafiobackend.infrastructure.mapper.user.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapperImpl implements TransactionMapper{
    private final UserMapper userMapper;

    public TransactionMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public Transaction toTransaction(TransactionEntity transactionEntity) {
       Transaction transaction = new Transaction();

       transaction.setId(transactionEntity.getId());
       transaction.setPayee(userMapper.toUser(transactionEntity.getPayee()));
       transaction.setPayer(userMapper.toUser(transactionEntity.getPayer()));
       transaction.setLocalDateTime(transactionEntity.getLocalDateTime());
       transaction.setValue(transactionEntity.getValue());

       return transaction;

    }
}
