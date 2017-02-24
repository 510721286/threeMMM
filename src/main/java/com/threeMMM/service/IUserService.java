package com.threeMMM.service;

import org.springframework.transaction.annotation.Transactional;

import com.threeMMM.model.UserEntity;

public interface IUserService {
	@Transactional
	public void add(UserEntity entity);
}
