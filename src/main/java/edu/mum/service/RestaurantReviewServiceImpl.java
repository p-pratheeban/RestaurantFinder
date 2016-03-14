package edu.mum.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.dao.RestaurantReviewDao;
import edu.mum.domain.Restaurant;
import edu.mum.domain.RestaurantReview;
import edu.mum.domain.User;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RestaurantReviewServiceImpl implements RestaurantReviewService {

	@Autowired
	private RestaurantReviewDao restaurantReviewDao;

	public void addRestaurantView(RestaurantReview restaurantReview, Restaurant restaurant) {
		restaurantReview.setRestaurantR(restaurant);
		restaurantReview.setReviewDate(new Date());
		User user = new User();
		user.setId(1);
		restaurantReview.setUser(user);
		restaurantReviewDao.create(restaurantReview);
	}

	public List<RestaurantReview> getReviewsByRestauarantId(int id) {
		return restaurantReviewDao.getReviewsByRestauarantId(id);
	}
}
