package com.pdcmix.app.ws.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pdcmix.app.ws.io.entity.UserEntity;
import com.pdcmix.app.ws.repo.IUserRepo;
import com.pdcmix.app.ws.security.JwtTokenUtil;
import com.pdcmix.app.ws.service.interfaces.IUserService;
import com.pdcmix.app.ws.shared.dto.UserDto;

@Service("userService")
public class UserService implements IUserService{

    @Autowired
    IUserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
	private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        UserEntity exists = userRepo.findByEmail(user.getEmail());

        if (exists != null) {
            throw new RuntimeException("User already exists");
        }

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity newUser = userRepo.save(userEntity);

        final String token = setToken(user.getEmail());

        UserDto returnValue = new UserDto();
        returnValue.setToken(token);
        BeanUtils.copyProperties(newUser, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepo.findById(UUID.fromString(uuid));

        if (!userEntity.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(userEntity.get().getId().toString(), userEntity.get().getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepo.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    public UserDto login(UserDto user) {
        UserEntity userEntity = userRepo.findByEmail(user.getEmail());

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if (!bCryptPasswordEncoder.matches(user.getPassword(), userEntity.getEncryptedPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        final String token = setToken(user.getId().toString());

        UserDto returnValue = new UserDto();
        returnValue.setToken(token);

        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    private String setToken(String uuid) {
        final UserDetails userDetails = this.loadUserByUsername(uuid);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return token;
    }

    
    
}
