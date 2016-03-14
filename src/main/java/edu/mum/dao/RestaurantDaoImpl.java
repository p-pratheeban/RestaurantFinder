package edu.mum.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Restaurant;
import edu.mum.domain.Role;
import edu.mum.domain.User;

@Repository
@Transactional
public class RestaurantDaoImpl implements RestaurantDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void create(Restaurant restaurant) {
		sessionFactory.getCurrentSession().persist(restaurant);
	}

	@Override
	public void update(Restaurant restaurant) {
		sessionFactory.getCurrentSession().update(restaurant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from  Restaurant").list();
	}

	public Restaurant findById(int id) {
		return (Restaurant) sessionFactory.getCurrentSession().get(Restaurant.class, id);
	}

	@Override
	public void delete(int id) {
		Restaurant restaurant = findById(id);
		sessionFactory.getCurrentSession().delete(restaurant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getOwners() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT user from User user JOIN user.roles role where role=:role");
		query.setParameter("role", Role.ROLE_OWNER);
		return query.list();
	}

	public User getUserByName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT user from User user where userName=:userName");
		query.setParameter("userName", userName);
		return (User) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantByName(String restaurantName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Restaurant.class);
		criteria.add(Restrictions.ilike("restaurantName", "%"+restaurantName+"%"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantByState(String state) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Restaurant.class);
		criteria.add(Restrictions.ilike("state", "%"+state+"%"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantByCity(String city) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Restaurant.class);
		criteria.add(Restrictions.ilike("state", "%"+city+"%"));
		return criteria.list();
	}
	
}