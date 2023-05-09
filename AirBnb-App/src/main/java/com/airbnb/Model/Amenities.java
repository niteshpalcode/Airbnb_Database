package com.airbnb.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="amenities")
@Data
@Getter
@Setter
public class Amenities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer amenityId;
	@Column(name ="amenity_name" )
	private String amenityName;
	
	
	

}