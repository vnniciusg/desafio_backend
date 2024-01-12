package com.desafiobackend.infrastructure.mapper.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public User toUser(UserEntity userEntity) {
        User user = new User();

        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setBalance(userEntity.getBalance());
        user.setDocument(userEntity.getDocument());

        return user;

    }
}
