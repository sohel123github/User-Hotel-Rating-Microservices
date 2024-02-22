package com.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.userservice.dao.UserRepository;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.entity.Hotel;
import com.userservice.service.UserServiceImpl;

@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	UserRepository userRepository;
	
	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	List<User> myUsers;
	
	@Test
	@Order(1)
	public void test_getAll () {
		List<User> myUsers = new ArrayList<>();
		myUsers.add(new User("sbsa1","Abhay","abhay@gmmail.com","Java developer"));
		myUsers.add(new User("jfds2","Raj","raj@gmmail.com","Python developer"));
		
		when(userRepository.findAll()).thenReturn(myUsers); //Mocking
		
		assertEquals(2,userServiceImpl.getAll().size());
	}

	@Test
	@Order(2)
	public void test_get() {
		User user = new User("sbsa1","Abhay","abhay@gmmail.com","Java developer");
		Hotel hotel = new Hotel("DemoHotel","Grand Regal","Islampur","Great Hotel");
		Rating[] ratingList = {new Rating("2sf","sbsa1","saeo3",8,"Greate Hotel",hotel)};
		
		String userId = "sbsa1";
		
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));  //Mocking

		when(restTemplate.getForObject("http://RATING-SERVICE/ratings/users/sbsa1", Rating[].class)).thenReturn(ratingList);
		
		when(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/saeo3", Hotel.class)).thenReturn(hotel);

		User userResponse = userServiceImpl.get(userId);

		assertEquals(userId, userResponse.getUserId());
		assertEquals(hotel.getHotelId(), userResponse.getRatings().get(0).getHotel().getHotelId());
	}

//	@Test
//	@Order(3)
//	public void test_upsert() {
//		User user = new User("sba1","Karan","karan@gmail.com","Tester");
//		
//		when(userRepository.save(user)).thenReturn(user);
//		
//		asserstEquals(user,userServiceImpl.upsert(user));
//		
//	}

//	@Test
//	@Order(4)
//	public void test_delete() {
//		User u = new User("def","Ram","ram@gmail.com","Developer");
//		
//		String userId = "def";
//		when(userRepository.deleteById(userId )).thenRet
//	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
