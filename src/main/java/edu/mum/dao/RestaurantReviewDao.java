package edu.mum.dao;

import java.util.List;

import edu.mum.domain.RestaurantReview;

public interface RestaurantReviewDao {

	void create(RestaurantReview restaurantReview);
	List<RestaurantReview> getReviewsByRestauarantId(int id);
}