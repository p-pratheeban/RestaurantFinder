package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.User;
import edu.mum.domain.Role;
import edu.mum.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	public void setPersonService(UserService us){
		this.userService = us;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", Role.values());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user2";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u){
		
		if(u.getId() == 0){
			//new person, add it
			this.userService.addUser(u);
		}else{
			//existing person, call update
			this.userService.updateUser(u);
		}
		
		return "redirect:/user/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/user/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("roles", Role.values());
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user2";
    }
	
}

