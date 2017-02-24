package com.threeMMM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeMMM.core.Dao.IEntityPersist;
import com.threeMMM.core.Dao.IEntityQueryFactory;
import com.threeMMM.model.UserEntity;
import com.threeMMM.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	protected IEntityQueryFactory entityQueryFactory;

	@Autowired
	protected IEntityPersist entityPersist;

	public void add(UserEntity entity) {
		List<UserEntity> t = entityQueryFactory.createQuery(UserEntity.class).between("id", 1, 12)
				.eq("username", "admin1", false).list();
		entityPersist.save(entity);
		System.out.println(t.size());
	}

}
