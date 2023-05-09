package com.airbnb.Model;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="review")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;

	private double rating;
	
	private String comment;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "listing_id")
	private Listing listing;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "guest_id")
	private Users users;
}
