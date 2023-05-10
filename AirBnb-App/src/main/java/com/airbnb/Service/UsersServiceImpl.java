package com.airbnb.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.Roles;
import com.airbnb.Model.Users;
import com.airbnb.Repository.RoleRepository;
import com.airbnb.Repository.UsersRepository;
import com.airbnb.Security.AppConstant;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public UsersDTO registerNewUser(UsersDTO userDto) throws UsersNotfoundException {
		
		Optional<Users> isPresent=usersRepository.findByEmail(userDto.getEmail());
		if(isPresent.isPresent()) {
			throw new UsersNotfoundException("User Is already registerd with this emailid - "+userDto.getEmail());	
		}
		
		
		
		Users user=modelMapper.map(userDto, Users.class);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Roles normal_role=	roleRepository.findById(AppConstant.NORMAL_USER).orElseThrow(()->new RuntimeException("Not Found"));
		user.getRoles().add(normal_role);
		Users savedUsers=	usersRepository.save(user);
		
		return modelMapper.map(savedUsers, UsersDTO.class);
	}

	@Override
	public UsersDTO registerAdmin(UsersDTO usersDTO) throws UsersNotfoundException {
		Optional<Users> isPresent=usersRepository.findByEmail(usersDTO.getEmail());
		if(isPresent.isPresent()) {
			throw new UsersNotfoundException("User Is already registerd with this emailid - "+usersDTO.getEmail());	
		}
		
		
		
		Users user=modelMapper.map(usersDTO, Users.class);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Roles admin_role=	roleRepository.findById(AppConstant.ADMIN_USER).orElseThrow(()->new RuntimeException("Not Found"));
		user.getRoles().add(admin_role);
		Users savedUsers=	usersRepository.save(user);
		
		return modelMapper.map(savedUsers, UsersDTO.class);
	}

	@Override
	public UsersDTO useGetById(Integer userId) throws UsersNotfoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		
		return modelMapper.map(users, UsersDTO.class);
		
	}

	@Override
	public List<UsersDTO> allUser() throws UsersNotfoundException {
		List<Users> users=usersRepository.findAll();
	 List<UsersDTO> userdtos=users.stream().map((u)->modelMapper.map(u, UsersDTO.class)).collect(Collectors.toList());
		
		return userdtos;
	}

	@Override
	public UsersDTO updateUser(UsersDTO usersDTO, Integer userId) throws UsersNotfoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		
		users.setEmail(usersDTO.getEmail());
		users.setFirstname(usersDTO.getFirstname());
		users.setLastname(usersDTO.getLastname());
		users.setPassword(passwordEncoder.encode(usersDTO.getPassword()));

		Users updateUser= usersRepository.save(users);
		
		return modelMapper.map(updateUser, UsersDTO.class);
		
	}

	@Override
	public String deleteUser(Integer userId) throws UsersNotfoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		users.getRoles().clear();
		
		usersRepository.delete(users);
		return "User deleted";
	}
	
	
}
