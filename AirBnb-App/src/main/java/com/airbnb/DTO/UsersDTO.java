package com.airbnb.DTO;

import java.util.ArrayList;
import java.util.List;

import com.airbnb.Model.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Data
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
public class UsersDTO {

	private Integer userid;
	
	private String firstname;

	private String lastname;

	private String email;

	private String password;
	
	private List<RolesDTO> roles=new ArrayList<>();
	
}
