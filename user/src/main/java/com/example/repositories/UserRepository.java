package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.dataobjects.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	

	
}
