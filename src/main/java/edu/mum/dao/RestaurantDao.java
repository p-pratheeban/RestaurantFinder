package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Restaurant;
import edu.mum.domain.User;

public interface RestaurantDao {

	void create(Restaurant restaurant);
	void update(Restaurant restaurant);
	void delete(int id);
	Restaurant findById(int id);
	List<Restaurant> findAll();
	List<User> getOwners();
	User getUserByName(String userName);
	List<Restaurant> getRestaurantByName(String restaurantName);
	List<Restaurant> getRestaurantByState(String state);
	List<Restaurant> getRestaurantByCity(String city);
	
}