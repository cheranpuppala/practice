package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.UserRequest;
import com.cms.entity.UserEntity;
import com.cms.service.UserService;

@RestController
@RequestMapping("/userApi")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody  UserRequest request){
		String saveUserData = service.saveUserData(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUserData);
		
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable  Integer id, @RequestBody UserRequest request){
	 UserEntity updateUserData = service.updateUserData(id, request);
		return ResponseEntity.status(HttpStatus.OK).body(updateUserData);
		
	}	
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserEntity> getUser( @PathVariable Integer id){
	 UserEntity userById = service.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userById);
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity< List<UserEntity>> getAllUser( ){
	 List<UserEntity> allUsers = service.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
		
	}
	@DeleteMapping("/deleteData/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
	 String deleteUser = service.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleteUser);
		
	}

}
