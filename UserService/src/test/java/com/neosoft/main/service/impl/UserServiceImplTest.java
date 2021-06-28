//package com.neosoft.main.service.impl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.neosoft.main.entity.User;
//import com.neosoft.main.repository.UserRepository;
//import com.neosoft.main.response.CustomResponse;
//import com.neosoft.main.service.UserService;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTest {
//
//	@Mock
//	private UserRepository repo;
//	private UserService service;
//	@Mock
//	private CustomResponse response;
//	
//	@Mock
//	User user;
//
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.openMocks(this);
//		service = new UserServiceImpl(repo);
//	}
//
//	@Test
//	void shouldFindAllUser() {
//		// when
//		service.findAllUser();
//		// then
//		verify(repo).findAllByOrderByDobAscJoiningDateAsc();
//	}
//
//	@Test
//	void shouldSaveUser() {
//		User user = new User();
//		user.setUserId(101l);
//		user.setFirstName("Nitin");
//		user.setSurname("Gadkari");
//		user.setEmail("nitin@gmail.com");
//		user.setDob(new Date(1990, 01, 03));
//		user.setJoiningDate(new Date(2021, 05, 11));
//		user.setGender("Male");
//		user.setMobile("9040913456");
//		user.setPin(560026);
//		user.setDeleted(false);
//
//		// when
//		service.saveUser(user);
//
//		// then
//		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
//		verify(repo).save(userArgumentCaptor.capture());
//
//		User capturedUser = userArgumentCaptor.getValue();
//		assertThat(capturedUser).isEqualTo(user);
//
//	}
//}
