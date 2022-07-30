package com.tradingbot.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradingbot.app.ws.shared.dto.UserDto;
import com.tradingbot.app.ws.ui.model.request.UserLoginReqModel;
import com.tradingbot.app.ws.ui.model.response.UserLoginResModel;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUser() {
		return "get user was called";
	}
	
	@PostMapping
	public UserLoginResModel createUser(@RequestBody UserLoginReqModel userLoginModel) {
		UserLoginResModel returnValue = new UserLoginResModel();
		
		BeanUtils.copyProperties(userLoginModel, returnValue);
		returnValue.setMessage("hello");
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
