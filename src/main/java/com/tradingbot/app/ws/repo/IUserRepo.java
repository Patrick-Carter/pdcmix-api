package com.tradingbot.app.ws.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradingbot.app.ws.io.entity.UserEntity;

@Repository
public interface IUserRepo extends CrudRepository<UserEntity, UUID>{
    UserEntity findByEmail(String email);
}
