package com.threeMMM.core.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.threeMMM.core.Dao.IEntityQuery;
import com.threeMMM.core.Dao.IEntityQueryFactory;

public class EntityQueryFactory implements IEntityQueryFactory {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public <E> IEntityQuery<E> createQuery(Class<E> clazz) {
		return new EntityQuery<E>(clazz, sessionFactory);
	}
}
