package edu.mum.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.dao.RestaurantDao;
import edu.mum.domain.Restaurant;
import edu.mum.domain.User;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RestaurantServiceImpl implements IRestaurantService {
	@Autowired
	private RestaurantDao restaurantDao;

	public void addRestaurant(Restaurant restaurant, MultipartFile image) {
		String ownerName = restaurant.getOwner().getUserName();
		System.out.println(restaurant.getOwner().getId());
		User owner = restaurantDao.getUserByName(ownerName);
		restaurant.setOwner(owner);
		try {
			restaurant.setRestaurantImage(image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		restaurantDao.create(restaurant);
	}

	public List<Restaurant> findAll() {
		return restaurantDao.findAll();
	}

	public Restaurant findRestaurantById(int id) {
		return restaurantDao.findById(id);
	}

	public void updateRestaurant(Restaurant restaurant, MultipartFile image) {
		String ownerName = restaurant.getOwner().getUserName();
		System.out.println(restaurant.getOwner().getId());
		User owner = restaurantDao.getUserByName(ownerName);
		restaurant.setOwner(owner);
		try {
			restaurant.setRestaurantImage(image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		restaurantDao.update(restaurant);
	}

	public void deleteRestaurant(int id) {
		restaurantDao.delete(id);
	}

	public List<User> getOwners() {
		return restaurantDao.getOwners();
	}

	public List<Restaurant> getRestaurantByName(String restaurantName) {
		return restaurantDao.getRestaurantByName(restaurantName);
	}

	public List<Restaurant> getRestaurantByState(String state) {
		return restaurantDao.getRestaurantByState(state);
	}

	public List<Restaurant> getRestaurantByCity(String city) {
		return restaurantDao.getRestaurantByState(city);
	}

}
