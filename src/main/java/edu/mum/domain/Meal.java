package edu.mum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity

public class Meal {
	@Override
	public String toString() {
		return "Meal [id=" + id + ", mealName=" + mealName + ", price=" + price + ", description=" + description
				+ ", restaurant=" + restaurant + ", menuType=" + menuType + "]";
	}

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "mealname")
	@NotEmpty(message = "Meal must have some name")
	private String mealName;

	@NumberFormat(style = Style.NUMBER)
	// @NotNull(message = "minmum price must have some name")
	@Min(value = 1, message = "minmum price must have some name")
	private double price;

	@NotEmpty
	private String description;

	@ManyToOne

	private Restaurant restaurant;

	@Enumerated(EnumType.STRING)
	@Column(name = "menu_type")
	private Menu menuType;

	public Menu getMenuType() {
		return menuType;
	}

	public void setMenuType(Menu menuType) {
		this.menuType = menuType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
