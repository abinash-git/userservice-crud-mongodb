package com.neosoft.main.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.main.entity.User;
import com.neosoft.main.exception.ResourceNotFoundException;
import com.neosoft.main.repository.UserRepository;
import com.neosoft.main.repository.UserRepositoryImpl;
import com.neosoft.main.response.CustomResponse;
import com.neosoft.main.service.UserService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;
	
	public CustomResponse saveUser(User user) {
		CustomResponse response = new CustomResponse();

		if (user != null) {
			if (userRepository.findByEmail(user.getEmail()) == null) {
				User save = userRepository.save(user);
				if (save != null) {
					response.setStatus(true);
					response.setMessage("User Created");
				} else {
					response.setStatus(false);
					response.setMessage("User Creation Failed");
				}
			} else {
				response.setStatus(false);
				response.setMessage("User Already Exist! Please provide different email!");
			}
		}
		else {
			response.setStatus(false);
			response.setMessage("Null User!");
		}

		return response;
	}

	public User editUser(User userDetails, BigInteger id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		user.setUserId(id);
		user.setFirstName(userDetails.getFirstName());
		user.setSurname(userDetails.getSurname());
		user.setEmail(userDetails.getEmail());
		user.setDob(userDetails.getDob());
		user.setMobile(userDetails.getMobile());
		user.setJoiningDate(userDetails.getJoiningDate());
		user.setGender(userDetails.getGender());
		user.setPin(userDetails.getPin());
		userRepository.save(user);
		return user;

	}

	public List<User> findUserByName(String name) {
		return userRepository.findByFirstName(name)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with name: " + name));
	}

	public List<User> findUserBySurname(String surname) {
		return userRepository.findBySurname(surname)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with surname: " + surname));
	}

	public List<User> findUserByPin(long pin) {
		return userRepository.findByPin(pin)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with pin: " + pin));
	}

	public List<User> findAllUser() {
		return userRepository.findAllByOrderByDobAscJoiningDateAsc();
	}

	public void softDeleteUserById(BigInteger id) {
		userRepositoryImpl.softdeleteById(id);	
	}

	public void hardDeleteUserById(BigInteger id) {
		userRepository.deleteById(id);
	}

	public User findOne(BigInteger id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

}
