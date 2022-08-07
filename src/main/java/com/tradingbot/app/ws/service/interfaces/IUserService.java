package com.tradingbot.app.ws.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tradingbot.app.ws.shared.dto.UserDto;

public interface IUserService extends UserDetailsService{
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
}

