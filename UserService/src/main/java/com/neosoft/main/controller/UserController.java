package com.neosoft.main.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.main.entity.User;
import com.neosoft.main.response.CustomResponse;
import com.neosoft.main.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;

	@PostMapping("/register")
	public CustomResponse registerUser(@Valid @RequestBody User user) {
		CustomResponse response = userServiceImpl.saveUser(user);
		return response;
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<User> editUser(@Valid @RequestBody User user, @PathVariable("id") BigInteger id) {
		User updatedUser = userServiceImpl.editUser(user, id);
		if (updatedUser != null) {
			return ResponseEntity.ok().body(updatedUser);
		} else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/byName/{name}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable("name") String name) {
		List<User> users = userServiceImpl.findUserByName(name);
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") BigInteger id) {
		User user = userServiceImpl.findOne(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/bySurname/{surname}")
	public ResponseEntity<List<User>> getUserBySurname(@PathVariable("surname") String surname) {
		List<User> users = userServiceImpl.findUserBySurname(surname);
		if (users != null) {
			return ResponseEntity.ok().body(users);
		} else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/byPin/{pin}")
	public ResponseEntity<List<User>> getUserByPin(@PathVariable("pin") long pin) {
		List<User> users = userServiceImpl.findUserByPin(pin);
		if (users != null) {
			return ResponseEntity.ok().body(users);
		} else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServiceImpl.findAllUser();
		if (users != null) {
			return ResponseEntity.ok().body(users);
		} else
			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/hardDeleteById/{id}")
	public ResponseEntity<Map<String, Boolean>> hardDeleteByUserId(@PathVariable("id") BigInteger id) {
		User user = userServiceImpl.findOne(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		userServiceImpl.hardDeleteUserById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/softDeleteById/{id}")
	public ResponseEntity<User> softDeleteByUserId(@PathVariable("id") BigInteger id) {
		User user = userServiceImpl.findOne(id);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		userServiceImpl.softDeleteUserById(id);
		return ResponseEntity.ok().build();
	}
}
