package com.airbnb.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.airbnb.Model.Listing;
import com.airbnb.Model.Users;

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
public class ReviewDTO {
	private Integer reviewId;

	private double rating;
	
	private String comment;
	
	private LocalDateTime createdAt;
	
	private ListingDTO1 listing;
	
	private UserDTO1 users;
}
