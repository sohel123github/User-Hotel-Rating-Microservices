package com.hotelservice.controller;

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

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotelList = hotelServiceImpl.getAll();
		return new ResponseEntity<>(hotelList, HttpStatus.OK);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = hotelServiceImpl.get(hotelId);
		return new ResponseEntity<>(hotel,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel h){
		Hotel hotel = hotelServiceImpl.upsert(h);
		return new ResponseEntity<> (hotel, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel h){
		Hotel hotel = hotelServiceImpl.upsert(h);
		return new ResponseEntity<>(hotel,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
		String status = hotelServiceImpl.deleteHotel(hotelId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
