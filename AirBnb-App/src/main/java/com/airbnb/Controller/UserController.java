package com.airbnb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Repository.UsersRepository;
import com.airbnb.Service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/airbnb/users")
public class UserController {
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/view/{userId}")
	public ResponseEntity<UsersDTO> getUserByIdHandler(@PathVariable ("userId" )Integer userId) throws UsersNotfoundException
	{
		return new ResponseEntity<UsersDTO>(usersService.useGetById(userId),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable ("userId" )Integer userId) throws UsersNotfoundException
	{
		return new ResponseEntity<String>(usersService.deleteUser(userId),HttpStatus.OK);
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<UsersDTO> updateUserHandler(@PathVariable ("userId" )Integer userId,@RequestBody UsersDTO usersDTO)throws UsersNotfoundException{
		return new ResponseEntity<UsersDTO>(usersService.updateUser(usersDTO, userId),HttpStatus.ACCEPTED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("viewAll")
	public ResponseEntity<List<UsersDTO>> viewAllUserHandler() throws UsersNotfoundException{
		return new ResponseEntity<List<UsersDTO>>(usersService.allUser(),HttpStatus.ACCEPTED);
	}
	
}
