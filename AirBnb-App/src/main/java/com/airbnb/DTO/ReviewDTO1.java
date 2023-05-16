package com.airbnb.DTO;

import java.time.LocalDateTime;

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
public class ReviewDTO1 {
	private Integer reviewId;

	private double rating;
	
	private String comment;
	
	private LocalDateTime createdAt;
}
