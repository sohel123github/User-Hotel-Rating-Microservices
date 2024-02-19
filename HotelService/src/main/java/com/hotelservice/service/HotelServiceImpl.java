package com.hotelservice.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelservice.dao.HotelRepository;
import com.hotelservice.entity.Hotel;
import com.hotelservice.service.exception.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> getAll() {
		List<Hotel> hotelList = hotelRepository.findAll();
		return hotelList;
	}

	@Override
	public Hotel get(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException ("Resource Not Found.."));
		return hotel;
	}

	@Override
	public Hotel upsert(Hotel h) {
		String randomHotelId = UUID.randomUUID().toString();
		h.setHotelId(randomHotelId);
		Hotel hotel = hotelRepository.save(h);
		return hotel;
	}

	@Override
	public String deleteHotel(String hotelId) {
		hotelRepository.deleteById(hotelId);
		return "deleted successfully..";
	}

}
