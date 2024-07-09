package com.cms.service;

import java.util.List;

import com.cms.dto.UserRequest;
import com.cms.entity.UserEntity;

public interface UserService {

	
	public String  saveUserData(UserRequest request);
	
	public UserEntity updateUserData(Integer id,UserRequest request);
	
	public UserEntity getUserById(Integer id);
	
	public String deleteUser(Integer id);
	
	public List<UserEntity> getAllUsers();
	
	
	
	
	
	

	
	
}
