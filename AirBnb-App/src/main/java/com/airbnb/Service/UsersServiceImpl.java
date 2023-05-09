package com.airbnb.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.Users;
import com.airbnb.Repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UsersDTO registerNewUser(UsersDTO userDto) throws UsersNotfoundException {
		
		Users isPresent=usersRepository.findByEmail(userDto.getEmail());
		if(isPresent!=null) {
			throw new UsersNotfoundException("User Is already registerd with this emailid - "+userDto.getEmail());
			
		}
		
		Users user=modelMapper.map(userDto, Users.class);
		
		Users savedUsers=	usersRepository.save(user);
		
		
		
		
		return modelMapper.map(savedUsers, UsersDTO.class);
	}
	
	
}
