package com.dcoimbra.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dcoimbra.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
