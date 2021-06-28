package com.neosoft.main.repository;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.neosoft.main.entity.User;

@Repository
public class UserRepositoryImpl {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void softdeleteById(BigInteger id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(id));
		Update update = new Update();
		update.set("deleted", true);
		mongoTemplate.findAndModify(query, update, User.class);
	}
}
