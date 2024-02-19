package com.hotelservice.service;

import java.util.List;
import com.hotelservice.entity.Hotel;

public interface HotelService {

	public List<Hotel> getAll();
	
	public Hotel get(String hotelId);
	
	public Hotel upsert(Hotel hotel);
	
	public String deleteHotel(String hotelId);
	
}
