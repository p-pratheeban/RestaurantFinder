package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Restaurant;
import edu.mum.domain.RestaurantReview;
import edu.mum.domain.User;
import edu.mum.service.RestaurantReviewService;
import edu.mum.service.IRestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	IRestaurantService restaurantService;

	@Autowired
	RestaurantReviewService restaurantReviewService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newRestaurantPage(Model model) {
		model.addAttribute("restValues", new Restaurant());
		List<User> owners = restaurantService.getOwners();
		model.addAttribute("owners", owners);
		return "restaurant/addRestaurant";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addRestaurant(@Valid @ModelAttribute("restValues") Restaurant restaurant, BindingResult bindingResult,
			@RequestParam("image") MultipartFile image) {
		if (bindingResult.hasErrors()) {
			return "restaurant/addRestaurant";
		} else {
			restaurantService.addRestaurant(restaurant, image);
			return "redirect:../restaurant/findall";
		}

	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public String getAllRestaurants(Model model) {
		List<Restaurant> restaurants = restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "restaurant/restaurantList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getRestaurantById(@PathVariable int id, Model model) {
		Restaurant restaurant = restaurantService.findRestaurantById(id);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/restaurantDetail";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult bindingResult,
			@PathVariable int id, @RequestParam("image") MultipartFile image) {

		if (bindingResult.hasErrors()) {
			return "redirect:../../restaurant/findall";
		} else {
			restaurantService.updateRestaurant(restaurant, image);
			return "redirect:../../restaurant/findall";
		}

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		restaurantService.deleteRestaurant(id);
		return "redirect:../../restaurant/findall";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchtPage() {
		return "restaurant/search";
	}

	@RequestMapping(value = "/searchbyname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Restaurant> searchByName(@RequestParam("name") String name) {
		List<Restaurant> restaurants = null;
		if (!name.isEmpty() && name != null) {
			restaurants = restaurantService.getRestaurantByName(name);
		}
		return restaurants;
	}

	@RequestMapping(value = "/searchbystate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Restaurant> searchByState(@RequestParam("state") String state) {
		List<Restaurant> restaurants = null;
		if (!state.isEmpty() && state != null) {
			restaurants = restaurantService.getRestaurantByState(state);
		}
		return restaurants;
	}

	@RequestMapping(value = "/searchbycity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Restaurant> searchByCity(@RequestParam("city") String city) {
		List<Restaurant> restaurants = null;
		if (!city.isEmpty() && city != null) {
			restaurants = restaurantService.getRestaurantByCity(city);
		}
		return restaurants;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String getRestaurant(@PathVariable int id, Model model) {
		Restaurant restaurant = restaurantService.findRestaurantById(id);
		model.addAttribute("restaurant", restaurant);
		List<RestaurantReview> reviews = restaurantReviewService.getReviewsByRestauarantId(id);
		model.addAttribute("reviews", reviews);
		model.addAttribute("review", new RestaurantReview());
		return "restaurant/restaurantFeedback";
	}

	@RequestMapping(value = "/review/{id}", method = RequestMethod.POST)
	public String addRestaurantReview(@ModelAttribute("review") RestaurantReview restaurantReview, @PathVariable int id,
			RedirectAttributes redirectAttrs) {
		Restaurant restaurant = restaurantService.findRestaurantById(id);
		restaurantReviewService.addRestaurantView(restaurantReview, restaurant);
		redirectAttrs.addAttribute("id", id);
		return "redirect:/restaurant/view/{id}";

	}
}
