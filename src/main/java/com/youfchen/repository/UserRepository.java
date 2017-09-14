package com.youfchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youfchen.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUsernameAndPassword(String username,String password);
	
	UserEntity findByUsername(String username);

}
