package edu.mum.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Name should not be empty")
	private String restaurantName;
	@NotBlank(message = "State should not be empty")
	private String state;
	@NotBlank(message = "City should not be empty")
	private String city;
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "phone no is invalid")
	private String phoneNo;
	@NotBlank(message = "Description should not be empty")
	private String description;
	@Lob
	private byte[] restaurantImage;
	@Transient
	private String resImage;
	@OneToOne
	@JsonIgnore
	private User owner;
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant")
	private List<Meal> meals;

	@JsonIgnore
	@OneToMany(mappedBy = "restaurantR")
	private Set<RestaurantReview> restaurantRreviews = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Set<RestaurantReview> getRestaurantRreviews() {
		return restaurantRreviews;
	}

	public void setRestaurantRreviews(Set<RestaurantReview> restaurantRreviews) {
		this.restaurantRreviews = restaurantRreviews;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getRestaurantImage() {
		return restaurantImage;
	}

	public void setRestaurantImage(byte[] restaurantImage) {
		this.restaurantImage = restaurantImage;
	}

	public String getResImage() {
		return Base64Utils.encodeToString(getRestaurantImage());
	}
}
