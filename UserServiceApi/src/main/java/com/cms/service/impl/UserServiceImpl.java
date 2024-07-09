package com.cms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dto.UserRequest;
import com.cms.entity.UserEntity;
import com.cms.exception.IdNotFoundException;
import com.cms.repo.UserRepo;
import com.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public String saveUserData(UserRequest request) {
		UserEntity entity = new UserEntity();
		/*
		 * entity.setEmail(request.getEmail()); entity.setName(request.getName());
		 */

		BeanUtils.copyProperties(request, entity);
		userRepo.save(entity);
		return "saved";
	}

	@Override
	public UserEntity updateUserData(Integer id, UserRequest request) {
		Optional<UserEntity> userEntity = userRepo.findById(id);

		if (userEntity.isPresent()) {
			UserEntity userEntity2 = userEntity.get();
			BeanUtils.copyProperties(request, userEntity2);
			userRepo.save(userEntity2);
			return userEntity2;
		}

		throw new IdNotFoundException(" id not found");
	}

	@Override
	public UserEntity getUserById(Integer id) {
		Optional<UserEntity> userEntity = userRepo.findById(id);

		if (userEntity.isPresent()) {
			UserEntity userEntity2 = userEntity.get();
			return userEntity2;
		}

		throw new IdNotFoundException(" id not found");
	}

	@Override
	public String deleteUser(Integer id) {
		
		 userRepo.deleteById(id);
		 
		 return "deleted";
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
