package com.ratingservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> ratingList = ratingServiceImpl.getAll();
		return new ResponseEntity<>(ratingList,HttpStatus.OK);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
		Rating rating = ratingServiceImpl.get(ratingId);
		return new ResponseEntity<>(rating,HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingUser(@PathVariable String userId){
		List<Rating> ratingList = (List<Rating>) ratingServiceImpl.getRatingByUserId(userId);
		return new ResponseEntity<> (ratingList,HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingHotel(@PathVariable String hotelId){
		List<Rating> ratingList = (List<Rating>) ratingServiceImpl.getRatingByhotelId(hotelId);
		return new ResponseEntity<> (ratingList,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Rating> updateRating(@RequestBody Rating r){
		Rating rating = ratingServiceImpl.upsert(r);
		return new ResponseEntity<>(rating,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating r){
		Rating rating = ratingServiceImpl.upsert(r);
		return new ResponseEntity<>(rating,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
		String status = ratingServiceImpl.delete(ratingId);
		return new ResponseEntity<> (status,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
