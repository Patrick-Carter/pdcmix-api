package com.pdcmix.app.ws.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pdcmix.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, UUID>{
    UserEntity findByEmail(String email);
}
