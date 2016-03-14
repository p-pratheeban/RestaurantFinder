package edu.mum.service;

import java.util.List;

import edu.mum.domain.Meal;

public interface IMealService {
	public void addMail(Meal meal, Integer restaurantId);

	public List<Meal> getAllMeal();

	public Meal getMailById(Integer id);

	public List<Meal> getMealByName(Integer restaurantId);

	public void deleteMeal(Meal meal);

	public Meal updateMeal(Meal meal, Integer restauantid);
}
