package com.srinath.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class FoodController {
	
	
	@Autowired
	UserRepo user;
		
	@Autowired
	FoodRepo food;
	
	@GetMapping("/foodItems")
	public List<Food> getfoodItems() {
		List<Food> foods =food.findAll();	
		return foods;
	}	
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return user.findAll();
	}	
	
	
	@GetMapping("/users/{userId}")
	public Optional<User> getUser(@PathVariable ("userId") int id) {
		return user.findById(id);
	}	
	
	@PostMapping("/users")
	public String addUser(@RequestBody User u) {
		List<Food> foods =food.findAll();
		List<String> list = new ArrayList<>();
		for(Food f : foods) {
			list.add(f.getName());
		}
		if(list.contains(u.getFood()))
			{
			user.save(u);
			return u + " successfully saved ";
			}
		else
			return u.getFood() + " is not availabe in the Master food list ";
		
	}
	
	@PutMapping("/users")
	public String updateUserFood(@RequestBody User u) {
		List<Food> foods =food.findAll();
		List<String> list = new ArrayList<>();
		for(Food f : foods) {
			list.add(f.getName());
		}
		if(list.contains(u.getFood()))
			{
			user.save(u);
			return u + " successfully saved ";
			}
		else
			return u.getFood() + " is not availabe in the Master food list ";
	}	
	
	
	@DeleteMapping("/users/{userId}")
	public String deleteUserFood(@PathVariable("userId") int id) {
		User u = user.getOne(id);
		user.delete(u);
		return "deleted";
	}	
	
	
	
	
	
}
