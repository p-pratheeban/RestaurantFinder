package edu.mum.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.mum.domain.Restaurant;
import edu.mum.domain.User;

public interface IRestaurantService {
	void addRestaurant(Restaurant restaurant, MultipartFile image);

	List<Restaurant> findAll();

	Restaurant findRestaurantById(int id);

	void updateRestaurant(Restaurant restaurant, MultipartFile image);

	void deleteRestaurant(int id);

	List<User> getOwners();

	List<Restaurant> getRestaurantByName(String restaurantName);

	List<Restaurant> getRestaurantByState(String state);

	List<Restaurant> getRestaurantByCity(String city);

}