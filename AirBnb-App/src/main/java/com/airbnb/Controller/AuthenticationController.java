package com.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthenticationController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/add")
	public ResponseEntity<UsersDTO> registerNewUserHandler(@RequestBody UsersDTO usersDTO) throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.registerNewUser(usersDTO),HttpStatus.CREATED);
	}
}
