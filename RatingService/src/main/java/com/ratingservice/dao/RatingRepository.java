package com.ratingservice.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingservice.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{

	public List<Rating> getRatingByuserId(String userId);
	
	public List<Rating> getRatingByhotelId(String hotelId);
	
	
	
}
