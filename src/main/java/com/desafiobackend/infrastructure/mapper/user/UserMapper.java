package com.desafiobackend.infrastructure.mapper.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.infrastructure.entities.UserEntity;

import java.util.List;

public interface UserMapper {
    User toUser (UserEntity userEntity);

    List<User> toUsers(List<UserEntity> userEntityList);

}
