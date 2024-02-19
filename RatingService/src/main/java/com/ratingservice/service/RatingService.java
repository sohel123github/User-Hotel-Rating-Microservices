package com.ratingservice.service;

import java.util.List;
import com.ratingservice.entity.Rating;

public interface RatingService {

	public List<Rating> getAll();
	
	public Rating get(String ratingId);
	
	public List<Rating> getRatingByUserId(String userId);
	
	public List<Rating> getRatingByhotelId(String hotelId);
	
	public Rating upsert(Rating rating);
	
	public String delete(String ratingId);
	
}
