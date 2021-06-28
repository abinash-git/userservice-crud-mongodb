//package com.neosoft.main.controller;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.neosoft.main.entity.User;
//import com.neosoft.main.response.CustomResponse;
//import com.neosoft.main.service.impl.UserServiceImpl;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(value = UserController.class)
//class UserControllerTest {
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@MockBean
//	UserServiceImpl userService;
//
//	@Test
//	void shouldRegisterUser() throws JsonProcessingException, Exception {
//
//		User user = new User(101l, "Nitin", "Gadkari", "Male", new Date(1990, 01, 03), new Date(2021, 05, 11),
//				"nitin@gmail.com", "9040913456", 560026, false);
//		CustomResponse response = new CustomResponse(Boolean.TRUE, "User created");
//
//		when(userService.saveUser(user)).thenReturn(response);
//
//		String url = "/user/register";
//
//		mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(user)))
//				.andExpect(status().isOk());
//
//	}
//
//	@Test @Disabled
//	void shouldSaveUser() throws JsonProcessingException, Exception {
//
//		User user = new User(101L, "Nitin", "Gadkari", "Male", new Date(1990, 01, 03), new Date(2021, 05, 11),
//				"nitin@gmail.com", "9040913456", 560026, false);
//
//		CustomResponse response;
//
//		String jsonRequest = objectMapper.writeValueAsString(user);
//
//		String url = "/user/register";
//
//		MvcResult result = mockMvc
//				.perform(post(url)
//						.content(jsonRequest)
//						.contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk()).andReturn();
//		
//		String resultContext = result.getResponse().getContentAsString();
//		
//		response = objectMapper.readValue(resultContext, CustomResponse.class);
//		
//		assertTrue(response.isStatus()==Boolean.TRUE);
//
//	}
//
//	@Test
//	@Disabled
//	void shouldEditUser() throws JsonProcessingException, Exception {
//		long id = 101;
//		User existingUser = new User(101l, "Nitin", "dalal", "Male", new Date(1990, 01, 03), new Date(2021, 05, 11),
//				"nitin@gmail.com", "9040913456", 560026, false);
//
//		User user = new User(101l, "Nitin", "dalal", "Male", new Date(1990, 01, 03), new Date(2021, 05, 11),
//				"nitin@gmail.com", "9040913456", 560026, false);
//
//		when(userService.editUser(existingUser, existingUser.getUserId())).thenReturn(user);
//
//		String url = "http://localhost:8080/user/edit" + id;
//
//		mockMvc.perform(put(url).contentType("application/json").content(objectMapper.writeValueAsString(existingUser)))
//				.andExpect(status().isOk());
//	}
//
//
//	@Test
//	void testGetUserBySurname() {
//	}
//
//	@Test
//	void testGetUserByPin() {
//	}
//
//	@Test
//	void shoulGetAllUsers() throws Exception {
//
//		when(userService.findAllUser()).thenReturn(getUsers());
//
//		String url = "/user/allUsers";
//
//		MvcResult result = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
//		String actualJsonResponse = result.getResponse().getContentAsString();
//		String expectedJsonResponse = objectMapper.writeValueAsString(getUsers());
//
//		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
//	}
//
//	@Test
//	@Disabled
//	void testHardDeleteByUserId() throws Exception {
//		Long userId = (long) 1;
//
//		doNothing().when(userService).hardDeleteUserById(userId);
//
//		String url = "http://localhost:8080/user/hardDeleteById/" + userId;
//
//		mockMvc.perform(delete(url)).andExpect(status().isOk());
//
//		verify(userService, times(1)).hardDeleteUserById(userId);
//	}
//
//
//	public List<User> getUsers() {
//		List<User> list = new ArrayList<>();
//		list.add(new User(101l, "Nitin", "Gadkari", "Male", new Date(1990, 01, 03), new Date(2021, 05, 11),
//				"nitin@gmail.com", "9040913456", 560026, false));
//		list.add(new User(102l, "Arbind", "Malick", "Male", new Date(2000, 10, 25), new Date(2021, 03, 12),
//				"arbind@gmail.com", "9040913746", 560023, false));
//		list.add(new User(103l, "Arbind", "patnaik", "Male", new Date(1991, 11, 12), new Date(2020, 06, 13),
//				"nabin@gmail.com", "9040913123", 560027, false));
//
//		return list;
//	}
//
//}
