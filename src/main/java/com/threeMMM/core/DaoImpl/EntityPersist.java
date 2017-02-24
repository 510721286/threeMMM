package com.threeMMM.core.DaoImpl;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.threeMMM.core.Dao.IEntityPersist;

//
public class EntityPersist implements IEntityPersist {
	@Autowired
	private SessionFactory sessionFactory;

	Logger logger = Logger.getLogger(EntityPersist.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void remove(Object object) {
		Session session = getSession();
		try {
			session.delete(object);
			session.flush();
		} finally {
			session.close();
		}
	}

	public void save(Object object) {
		Session session = getSession();
		try {
			session.save(object);
			session.flush();
		} finally {
			session.close();
		}
	}

	public void saveOrUpdate(Object object) {
		Session session = getSession();
		try {
			session.saveOrUpdate(object);
			session.flush();
		} finally {
			session.close();
		}
	}

	public void update(Object object) {
		Session session = getSession();
		try {
			session.update(object);
			session.flush();
		} finally {
			session.close();
		}
	}

	private Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public void execute(String sql) {
		Session session = getSession();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			session.flush();
		} finally {
			session.close();
		}
	}

	public void execute(String sql, Object[] parameters) {
		Session session = getSession();
		try {
			SQLQuery query = session.createSQLQuery(sql);
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
			query.executeUpdate();
			session.flush();
		} finally {
			session.close();
		}
	}
}
