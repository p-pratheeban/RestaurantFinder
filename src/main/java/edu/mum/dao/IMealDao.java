package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Meal;

public interface IMealDao {
	public List<Meal> getMealByName(Integer restaurantid);
}
