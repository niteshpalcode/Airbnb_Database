package com.airbnb.Service;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;


public interface UsersService {
	
	public UsersDTO registerNewUser(UsersDTO userDto) throws UsersNotfoundException;

}
