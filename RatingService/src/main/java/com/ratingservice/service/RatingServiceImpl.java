package com.ratingservice.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratingservice.dao.RatingRepository;
import com.ratingservice.entity.Rating;
import com.ratingservice.service.exception.ResourceNotFoundException;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Rating> getAll() {
		List<Rating> ratingList = ratingRepository.findAll();
		return ratingList;
	}

	@Override
	public Rating get(String ratingId) {
		Rating rating  = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found.."));
		return rating;
	}
	
	@Override
	public List<Rating> getRatingByUserId(String userId){
		return ratingRepository.getRatingByuserId(userId);
	}
	
	@Override
	public List<Rating> getRatingByhotelId(String hotelId) {
		return ratingRepository.getRatingByhotelId(hotelId);
	}

	@Override
	public Rating upsert(Rating rating) {
		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		ratingRepository.save(rating);
		return rating;
	}

	@Override
	public String delete(String ratingId) {
		ratingRepository.deleteById(ratingId);
		return "deleted successfully..";
	}

	

}
