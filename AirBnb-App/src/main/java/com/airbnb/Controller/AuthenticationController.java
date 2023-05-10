package com.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/user/save")
	public ResponseEntity<UsersDTO> registerNewUserHandler(@RequestBody UsersDTO usersDTO) throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.registerNewUser(usersDTO),HttpStatus.CREATED);
	}
	@PostMapping("/admin/save")
	public ResponseEntity<UsersDTO> registerAsAdminHandler(@RequestBody UsersDTO usersDTO) throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.registerAdmin(usersDTO),HttpStatus.CREATED);
	}
	
}
