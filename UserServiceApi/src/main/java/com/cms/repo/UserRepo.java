package com.cms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
