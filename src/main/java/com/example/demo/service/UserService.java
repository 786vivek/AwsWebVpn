package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

//	public U updateUser(User user);
	public User addUser(User user);
public List<User> fetchAllUser();
public String deleteUser(Integer id);
public User updateUser(Integer id, User user);
//String deleteUser(Integer id);
}
