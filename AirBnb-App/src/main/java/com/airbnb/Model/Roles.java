package com.airbnb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
	@Id
	private Integer roleId;
	
	private String roleName;

}
