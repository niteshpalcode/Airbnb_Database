package com.airbnb.Service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.ListingDTO1;
import com.airbnb.DTO.LocationDTO;
import com.airbnb.DTO.ReviewDTO;
import com.airbnb.DTO.ReviewDTO1;
import com.airbnb.DTO.UserDTO1;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.ReviewNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.Listing;
import com.airbnb.Model.Reviews;
import com.airbnb.Model.Users;
import com.airbnb.Repository.ListingRepository;
import com.airbnb.Repository.ReviewRepository;
import com.airbnb.Repository.UsersRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository repository;
	@Autowired
	private ListingRepository listingRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private  ModelMapper modelMapper;
	@Override
	public ReviewDTO addComment(Integer userId, Integer listingId, ReviewDTO reviewDTO)
			throws UsersNotfoundException, ListingNotFoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		
		Listing list=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No listing is found.."));

		Reviews reviews=modelMapper.map(reviewDTO,Reviews.class);
		reviews.setCreatedAt(LocalDateTime.now());
		reviews.setUsers(users);
		reviews.setListing(list);
		UserDTO1 userDTO1= modelMapper.map(users, UserDTO1.class);
		ListingDTO1 listingDTO1=modelMapper.map(list, ListingDTO1.class);
		Reviews reviews1 =repository.save(reviews);
		ReviewDTO saved= modelMapper.map(reviews1, ReviewDTO.class);
		
		LocationDTO ldto= modelMapper.map(list.getLocation(), LocationDTO.class); 
		
		ListingDTO1 ldto1=	modelMapper.map(list, ListingDTO1.class);
		ldto1.setLocationDTO(ldto);

		saved.setListing(ldto1);
		saved.setUsers(userDTO1);
//		saved.setListing(listingDTO1);

		return saved;
	}
	@Override
	public String deleteComment(Integer reviewId) throws ReviewNotFoundException {
		Reviews reviews=repository.findById(reviewId).orElseThrow(()->new ReviewNotFoundException("No review is present "));
		
		reviews.setListing(null);
		reviews.setUsers(null);
		repository.delete(reviews);
		return "Deleted successfully .....";
	}
	@Override
	public ReviewDTO1 update(Integer reviewId, ReviewDTO1 reviewDTO) throws ReviewNotFoundException {
		Reviews reviews=repository.findById(reviewId).orElseThrow(()->new ReviewNotFoundException("No review is present "));
		
		reviews.setRating(reviewDTO.getRating());
		reviews.setComment(reviewDTO.getComment());
		reviews.setCreatedAt(LocalDateTime.now());
		
		Reviews reviews2= 	repository.save(reviews);
		
		return modelMapper.map(reviews2, ReviewDTO1.class);
	}
	
	
}
