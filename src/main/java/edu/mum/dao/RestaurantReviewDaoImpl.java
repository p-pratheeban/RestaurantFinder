package edu.mum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.domain.RestaurantReview;

@Repository
@Transactional
public class RestaurantReviewDaoImpl implements RestaurantReviewDao {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void create(RestaurantReview restaurantReview) {
		sessionFactory.getCurrentSession().save(restaurantReview);
	}

	@SuppressWarnings("unchecked")
	public List<RestaurantReview> getReviewsByRestauarantId(int id) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT review from RestaurantReview review  where review.restaurantR.id=:restid");
		query.setParameter("restid", id);
		return query.list();
	}
}
