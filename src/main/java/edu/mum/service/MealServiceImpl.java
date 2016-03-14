package edu.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.IGenericDao;
import edu.mum.dao.IMealDao;
import edu.mum.dao.RestaurantDao;
import edu.mum.domain.Meal;
import edu.mum.domain.Restaurant;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MealServiceImpl implements IMealService {

	@Autowired
	private IGenericDao<Meal, Integer> mealDao;

	@Autowired
	private RestaurantDao restaurantDao;

	@Autowired
	private IMealDao mealDAO;

	@Override
	public void addMail(Meal meal, Integer restaurantId) {
		Restaurant restaurant = restaurantDao.findById(restaurantId);
		meal.setRestaurant(restaurant);
		mealDao.create(meal);

	}

	@Override
	public List<Meal> getAllMeal() {
		return mealDao.findAll(Meal.class);
	}

	@Override
	public Meal getMailById(Integer id) {
		return mealDao.findById(id, Meal.class);
	}

	@Override
	public List<Meal> getMealByName(Integer restaurantId) {
		return mealDAO.getMealByName(restaurantId);
	}

	@Override
	public void deleteMeal(Meal meal) {
		mealDao.delete(meal);

	}

	@Override
	public Meal updateMeal(Meal meal, Integer restaurantId) {

		Restaurant restaurant = restaurantDao.findById(restaurantId);
		meal.setRestaurant(restaurant);
		return mealDao.update(meal);
	}

}
