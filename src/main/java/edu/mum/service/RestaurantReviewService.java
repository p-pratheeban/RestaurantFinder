package edu.mum.service;

import java.util.List;

import edu.mum.domain.Restaurant;
import edu.mum.domain.RestaurantReview;

public interface RestaurantReviewService {
	void addRestaurantView(RestaurantReview restaurantReview, Restaurant restaurant);

	List<RestaurantReview> getReviewsByRestauarantId(int id);
}