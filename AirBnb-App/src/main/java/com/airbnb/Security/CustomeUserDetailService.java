package com.airbnb.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airbnb.Model.Users;
import com.airbnb.Repository.UsersRepository;

@Service
public class CustomeUserDetailService  implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users=usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("UserIs not present here.."));
		
		return users;
	}
	
	
	

}
