package com.MongoDBExample.mdb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MongoDBExample.mdb.entity.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {

	Users getUserById(Integer id);

}
