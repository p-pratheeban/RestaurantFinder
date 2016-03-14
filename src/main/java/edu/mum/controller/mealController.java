package edu.mum.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Meal;
import edu.mum.domain.Menu;
import edu.mum.domain.Restaurant;
import edu.mum.domain.RestaurantReview;
import edu.mum.domain.User;
import edu.mum.service.IMealService;
import edu.mum.service.IOwnerService;
import edu.mum.service.IRestaurantService;

@Controller
public class mealController {

	@Autowired
	public IRestaurantService restaurantService;

	@Autowired
	public IMealService mealService;
	@Autowired
	public IOwnerService ownerService;

	@RequestMapping(value = "/welcome")
	public String getUser() {
		return "welcome";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String restaurnatList(Model model) {
		List<Restaurant> restaurants = restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "restaurantlist";
	}

	@RequestMapping(value = "/addrestaurant", method = RequestMethod.GET)
	public String addRestauant(Model model) {
		User woner = new User();
		woner.getUserName();
		RestaurantReview review = new RestaurantReview();
		model.addAttribute("reviews", review);
		List<User> owners = ownerService.getOwner();
		List<Integer> ownerlist = new ArrayList<>();
		for (User owner : owners) {
			ownerlist.add(owner.getId());
		}
		model.addAttribute("owners", ownerlist);
		model.addAttribute("restaurant", new Restaurant());
		/*
		 * List<Meal> mealList = mealService.getMealByName(restaurantId);
		 * model.addAttribute("mealList", mealList);
		 */

		return "addrestaurant";
	}

	@RequestMapping(value = "/view/addrestaurant", method = RequestMethod.POST)
	public String restaurnatList(@ModelAttribute Restaurant restaurant) {
		// User woner = new User();
		// woner.getId();
		// restaurant.setOwner(woner);
		// restaurantService.addRestaurant(restaurant);
		return "redirect:/list";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getRestaurantDetail(@PathVariable("id") int id, Model model) {
		Restaurant restaurant = restaurantService.findRestaurantById(id);
		model.addAttribute("restaurant", restaurant);

		List<Menu> menuList = Arrays.asList(Menu.values());
		System.out.println(menuList);
		model.addAttribute("menuType", menuList);
		List<Meal> mealist = mealService.getAllMeal();
		model.addAttribute("meals", mealist);
		List<Meal> mealList = mealService.getMealByName(id);
		System.out.println("meal size :" + mealList.size());
		model.addAttribute("mealList", mealList);
		return "restaurantdetail";
	}

	@RequestMapping(value = "/meal/{menuType}/restaurant/{restaurantId}", method = RequestMethod.GET)
	public String mealForm(@PathVariable("menuType") String menuType, Model model,
			@PathVariable("restaurantId") Integer restaurantId) {
		model.addAttribute("meal", new Meal());
		model.addAttribute("menuType", menuType);
		model.addAttribute("restaurantId", restaurantId);
		// System.out.println("resturantId:" + restaurantId);
		/*
		 * List<Meal> mealList = mealService.getMealByName(restaurantId);
		 * model.addAttribute("mealList", mealList);
		 */
		return "meal";
	}

	@RequestMapping(value = "restaurant/{restaurantId}/addMeal", method = RequestMethod.POST)
	public String addMeal(@Valid @ModelAttribute Meal meals, BindingResult result,
			@PathVariable("restaurantId") Integer restaurantId) {
		// System.out.println(meals.getDescription() + ", " +
		// meals.getMealName() + " restauranat ID:" + restaurantId);
		if (result.hasErrors()) {
			System.out.println("You hvace some error !!!!!!!!!!!!");
			return "meal";
		} else {
			mealService.addMail(meals, restaurantId);
			return "redirect:/list";
		}
	}

	@RequestMapping(value = "/{restaurantId}/delete/{id}", method = RequestMethod.GET)
	public String deleteMeal(@PathVariable("id") Integer id, @PathVariable("restaurantId") Integer restaurantId) {
		Meal meal = mealService.getMailById(id);
		mealService.deleteMeal(meal);
		return "redirect:/view/" + restaurantId;
	}

	@RequestMapping(value = "/{menuType}/{restaurantId}/edit/{id}", method = RequestMethod.GET)
	public String editmeal(@PathVariable("id") Integer id, @PathVariable("restaurantId") Integer restaurantId,
			@PathVariable("menuType") String menuType, Model model) {
		Meal meal = mealService.getMailById(id);
		model.addAttribute("meal", meal);
		model.addAttribute("menuType", menuType);
		model.addAttribute("restaurantId", restaurantId);

		return "editMeal";
	}

	@RequestMapping(value = "{restaurantId}/update/{mealId}", method = RequestMethod.POST)
	public String updateMeal(Meal meal, @PathVariable("restaurantId") Integer restaruantId,
			@PathVariable("mealId") Integer mealId) {
		// System.out.println("<<<<<<<<<<<<<<<<<<<<<<" + meal.toString() +
		// restaruantId);

		meal.setId(mealId);
		mealService.updateMeal(meal, restaruantId);
		return "redirect:/view/" + restaruantId;
	}
}
