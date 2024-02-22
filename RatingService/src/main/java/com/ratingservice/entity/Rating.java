package com.ratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {

	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	
	private String feedback;

//	public Rating(String ratingId, String userId, String hotelId, int rating, String feedback) {
//		super();
//		this.ratingId = ratingId;
//		this.userId = userId;
//		this.hotelId = hotelId;
//		this.rating = rating;
//		this.feedback = feedback;
//	}
	
	
	
}
