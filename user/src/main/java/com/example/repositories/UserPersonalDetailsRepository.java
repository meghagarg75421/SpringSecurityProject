package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.tokens.Token.ID;

import com.example.dataobjects.UserPersonalDetails;

public interface UserPersonalDetailsRepository extends CrudRepository<UserPersonalDetails, ID>{

}
