package com.desafiobackend.infrastructure.mapper.user;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.infrastructure.entities.UserEntity;

public interface UserMapper {
    User toUser (UserEntity userEntity);

}
