package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.viewObject.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/getalluser")
	public Response getfetchAllUser() {
	
		return new Response().setResponseCode(200).setResponseDesc("success")
				.setResponseObject(userService.fetchAllUser().toArray());
		// return
		// setResponseDesc("success").setResponseObject(userService.fetchAllUser().toArray());
	}

	@PostMapping("/user")
	public Response getfetchAll() {

		return new Response().setResponseCode(200).setResponseDesc("success")
				.setResponseObject(userService.fetchAllUser().toArray());
	
	}

	@PutMapping("/users/{id}")
	public Response updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
		
		System.out.println(userDto.getClass().getName());

		return new Response().setResponseCode(200).setResponseDesc("success")
				.setResponseObject(userService.updateUser(id,new User()));//,user.getEmail(),user.getPassword()));/ userService.updateUser(id, user);
	}

	@PostMapping("/users")
	public Response saveUser(@Valid @RequestBody User user) {
		return new Response().setResponseCode(200).setResponseDesc("success")
				.setResponseObject(userService.addUser(user));
		// userService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public Response deleteUser(@PathVariable Integer id) {
		return new Response().setResponseCode(200).setResponseDesc("success")
				.setResponseObject(userService.deleteUser(id));
	}

}
