package com.neosoft.main.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Document(collection = "users")
public class User {

	@Id
	private BigInteger userId;

	@NotNull(message = "First Name cannot be null")
	@NotBlank
	@Size(min = 3, max = 15, message = "Fist name must be between 3 and 15 characters")
	private String firstName;

	@NotNull
	@Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
	private String surname;
	
	@NotBlank(message = "Gender must not be blank")
	@NotNull(message = "Gender cannot be null")
	private String gender;

	@NotNull(message = "Dob cannot be null")
	private Date dob;

	@NotNull(message = "Joining date cannot be null")
	private Date joiningDate;

	@NotBlank(message = "Email should not be blank")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank
	@NotNull(message = "Mobile must not be null")
	@Size(min=10,max=10, message = "Mobile number should be 10 digit")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobile;

	@NotNull(message = "Pin must not be null")
	private long pin;
	
	@NotNull	
	private boolean deleted;

}
