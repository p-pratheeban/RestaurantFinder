package edu.mum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Meal;

@Repository
@Transactional
public class MealDaoService implements IMealDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Meal> getMealByName(Integer restaurantid) {
		String hql = "Select m from Meal m Where m.restaurant.id=:restaurantId";

		@SuppressWarnings("unchecked")
		List<Meal> meals = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("restaurantId", restaurantid).list();

		// System.out.println("======== : " + meals.size());

		return meals;
	}

}
