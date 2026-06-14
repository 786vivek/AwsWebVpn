package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.AppConstants;
import com.example.demo.config.JwtUtil;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.viewObject.Response;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(AppConstants.HOMECONTROLLER_APP)
//@CrossOrigin(origins = "http://localhost:3000/")
public class HomeController {

	  @Autowired private JwtUtil jwtUtil;
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());


	
	@Autowired
	private UserService userService;
	
	
	
	
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody User user) {
	        if (userService.validateUser(user.getName(), user.getPassword())==true) {
	        	
	            String token = jwtUtil.generateToken(user);
	            System.out.println("tokenjwt++++++++++"+token);
	            return ResponseEntity.ok(token);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	
	
	
	
	
	
	
	

	@GetMapping("/getalluser")
	@Operation(summary = "Get all users")
	public Response getfetchAllUser() {
		
        logger.info("Fetching users");
        logger.debug("Debug message");
	
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
		
		System.out.println(userDto.getClass());

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
	
	
	@GetMapping("path")										
	public RestTemplate getMethodName(@RequestParam String param) {
	
		
		return new RestTemplate();
	}
	
//	@PostMapping("path")										
//	public ResponseEntity<Response> getMethodNamepost(@RequestParam String param) {
//	
//		
//		return new RestTemplate();
//	}

}
