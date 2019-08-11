package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataobjects.MyUserDetails;
import com.example.dataobjects.ResponseClass;
import com.example.dataobjects.User;
import com.example.repositories.UserPersonalDetailsRepository;
import com.example.repositories.UserRepository;

@RestController
public class UserController{

	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	UserPersonalDetailsRepository personalRepo;
	
		
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	ResponseClass response = new ResponseClass();

	
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public ResponseClass saveUserData(@Valid @RequestBody User userData) 
	{
		userData.getUserPersonalDetails().setUser(userData);
		
		String encodedPassword = new BCryptPasswordEncoder(16).encode(userData.getPassWord());
		userData.setPassWord(encodedPassword);
		//userData.setAuthorities(new SimpleGrantedAuthority("ADMIN").getAuthority());
		MyUserDetails myUserDetails = new MyUserDetails(userData);
		myUserDetails.getAuthorities();
		userRepository.save(userData);
		response.setSuccess("true");
		response.setTimeStamp(sdf.format(System.currentTimeMillis()));
		return response;
	}
	
	@RequestMapping(value = "/getUserData", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> getUserData(@RequestParam String id) 
	{
		
		if(userRepository.existsById(Integer.parseInt(id))) {
			//Optional<Users> responseUserq = userRepository.findById(Integer.parseInt(id));
			ResponseEntity<Optional<User>> responseUser = ResponseEntity.ok().body(userRepository.findById(Integer.parseInt(id)));
			return responseUser;
		}
		else
		{
			ResponseEntity<Optional<User>> responseUser = new ResponseEntity(null, HttpStatus.NOT_FOUND);
			return responseUser;
		}
		
	}
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public Iterable<User> getUserList() 
	{
		return userRepository.findAll();
		
		
	}
		/*@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
		public ResponseEntity<String> loginUser(@RequestParam String id) 
		{
			ResponseEntity<String> response;
			Optional<Users> resultUser = userRepository.findById(Integer.parseInt(id));
			resultUser.get().setAuthority((resultUser.get().getRole()));
			if (resultUser.get().getAuthority().equals("ROLE_ADMIN")) {
				 response = new ResponseEntity("Authorised User", HttpStatus.OK);
				}
			else {
				response = new ResponseEntity("UnAuthorised user", HttpStatus.UNAUTHORIZED);
				
			}
			return response;
				
			
			
	}*/
	
}
