package com.airbnb.Service;

import com.airbnb.DTO.ListingDTO;
import com.airbnb.DTO.ListingDTO1;
import com.airbnb.DTO.ReviewDTO;
import com.airbnb.DTO.ReviewDTO1;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.ReviewNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;

public interface ReviewService {

	public ReviewDTO addComment(Integer userId,Integer listingId,ReviewDTO reviewDTO)throws
		UsersNotfoundException,ListingNotFoundException;
	public String deleteComment(Integer reviewId) throws ReviewNotFoundException;
	
	public ReviewDTO1 update(Integer reviewId,ReviewDTO1 reviewDTO)  throws ReviewNotFoundException;
}
