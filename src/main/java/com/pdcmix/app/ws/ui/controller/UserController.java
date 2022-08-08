package com.tradingbot.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradingbot.app.ws.service.UserService;
import com.tradingbot.app.ws.shared.dto.UserDto;
import com.tradingbot.app.ws.ui.model.request.UserAuthReqModel;
import com.tradingbot.app.ws.ui.model.response.UserSignupResModel;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user was called";
	}
	
	@PostMapping("/signup")
	public UserSignupResModel createUser(@RequestBody UserAuthReqModel userLoginModel) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userLoginModel, userDto);

		UserSignupResModel response = new UserSignupResModel();
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, response);
		
		return response;
	}

	@PostMapping("/login")
	public UserSignupResModel loginUser(@RequestBody UserAuthReqModel userLoginModel) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userLoginModel, userDto);

		UserSignupResModel response = new UserSignupResModel();
		UserDto createdUser = userService.login(userDto);
		BeanUtils.copyProperties(createdUser, response);
		
		return response;
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
