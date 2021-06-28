package com.neosoft.main.service;

import java.math.BigInteger;
import java.util.List;

import com.neosoft.main.entity.User;
import com.neosoft.main.response.CustomResponse;

public interface UserService {
	
	public CustomResponse saveUser(User user);
	public User editUser(User userDetails, BigInteger id);
	public List<User> findUserByName(String name);
	public List<User> findUserBySurname(String surname);
	public List<User> findUserByPin(long pin);
	public List<User> findAllUser();
	public void softDeleteUserById(BigInteger id);
	public void hardDeleteUserById(BigInteger id);
	public User findOne(BigInteger id);

}
