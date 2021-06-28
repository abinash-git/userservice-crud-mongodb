package com.neosoft.main.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.main.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {

	Optional<List<User>> findByFirstName(String name);

	Optional<List<User>> findBySurname(String surname);

	Optional<List<User>> findByPin(long pin);
	
	User findByEmail(String email);
	
	List<User> findAllByOrderByDobAscJoiningDateAsc();
	
//	@Modifying
//	@Query("update User u set u.deleted=1 WHERE u.userId = :id")
//	void softDeleteUserById(@Param("id")Long id);
	
	
}
