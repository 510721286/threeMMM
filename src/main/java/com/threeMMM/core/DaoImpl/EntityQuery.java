package com.threeMMM.core.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.Transformers;

import com.threeMMM.core.Dao.IEntityQuery;

public class EntityQuery<T> implements IEntityQuery<T> {
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Criteria criteria = null;
	private Class<?> clazz;
	private Order order;
	Logger logger = Logger.getLogger(EntityQuery.class);

	public EntityQuery(Class<T> clazz, SessionFactory factory) {
		this.clazz = clazz;
		this.sessionFactory = factory;
		createCriteria();
	}

	private void createCriteria() {
		Session session = getSession();
		session.clear();// 少了这一句
		criteria = session.createCriteria(clazz);
	}

	public IEntityQuery<T> between(String property, Object low, Object high) {
		criteria.add(Restrictions.between(property, low, high));
		return this;
	}

	public IEntityQuery<T> desc(String property, boolean desc) {
		if (desc) {
			// criteria.addOrder(Order.desc(property));
			order = Order.desc(property);
		}
		return this;
	}

	public IEntityQuery<T> asc(String property, boolean desc) {
		if (desc) {
			// criteria.addOrder(Order.desc(property));
			order = Order.asc(property);
		}
		return this;
	}

	public IEntityQuery<T> eq(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.eq(property, value));
		return this;
	}

	public IEntityQuery<T> eqProperty(String property, String otherProperty) {
		criteria.add(Restrictions.eqProperty(property, otherProperty));
		return this;
	}

	public IEntityQuery<T> setFetchedProperties(String... properties) {
		ProjectionList projectionList = Projections.projectionList();
		for (int i = 0; i < properties.length; i++) {
			projectionList.add(Projections.property(properties[i]), properties[i]);
		}
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(clazz));
		return this;
	}

	public IEntityQuery<T> createAlias(String associationPath, String alias) {
		criteria.createAlias(associationPath, alias);
		return this;
	}

	public IEntityQuery<T> isNull(String propertyName) {
		criteria.add(Restrictions.isNull(propertyName));
		return this;
	}

	public IEntityQuery<T> isEmpty(String propertyName) {
		criteria.add(Restrictions.isEmpty(propertyName));
		return this;
	}

	public IEntityQuery<T> isNotNull(String propertyName) {
		criteria.add(Restrictions.isNotNull(propertyName));
		return this;
	}

	public IEntityQuery<T> ge(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.ge(property, value));
		return this;
	}

	public IEntityQuery<T> in(String property, boolean ignoreNull, Object... values) {
		if (values == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.in(property, values));
		return this;
	}

	public IEntityQuery<T> le(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.le(property, value));
		return this;
	}

	public IEntityQuery<T> ne(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.ne(property, value));
		return this;
	}

	public IEntityQuery<T> like(String property, String value, boolean ignoreNull) {
		if ((value == null || value.trim().equals("")) && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.like(property, "%" + value + "%"));
		return this;
	}

	public IEntityQuery<T> gt(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.gt(property, value));
		return this;
	}

	public IEntityQuery<T> lt(String property, Object value, boolean ignoreNull) {
		if (value == null && ignoreNull) {
			return this;
		}
		criteria.add(Restrictions.lt(property, value));
		return this;
	}

	@Override
	public IEntityQuery<T> geProperty(String property, String otherPropertyName) {
		if (property == null && otherPropertyName == null) {
			return this;
		}
		criteria.add(Restrictions.geProperty(property, otherPropertyName));
		return this;
	}

	@Override
	public IEntityQuery<T> gtProperty(String property, String otherPropertyName) {
		if (property == null && otherPropertyName == null) {
			return this;
		}
		criteria.add(Restrictions.gtProperty(property, otherPropertyName));
		return this;
	}

	@Override
	public IEntityQuery<T> leProperty(String property, String otherPropertyName) {
		if (property == null && otherPropertyName == null) {
			return this;
		}
		criteria.add(Restrictions.leProperty(property, otherPropertyName));
		return this;
	}

	@Override
	public IEntityQuery<T> ltProperty(String property, String otherPropertyName) {
		if (property == null && otherPropertyName == null) {
			return this;
		}
		criteria.add(Restrictions.ltProperty(property, otherPropertyName));
		return this;
	}

	@Override
	public IEntityQuery<T> setFetchMode(String propertyName, FetchMode fetchType) {
		criteria.setFetchMode(propertyName, fetchType).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return this;
	}

	public T get() {
		criteria.setMaxResults(1);
		List<T> resultList = null;
		try {
			resultList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (resultList.size() != 0) {
			T t = resultList.get(0);
			return t;
		}
		return null;
	}

	public List<T> list() {
		setOrder(order);
		List<T> list = null;
		try {
			list = criteria.list();
		} finally {
			session.close();
		}
		return list;
	}

	public List<T> list(int maxResults) {
		setOrder(order);
		List<T> list = null;
		try {
			criteria.setMaxResults(maxResults);
			list = criteria.list();
		} finally {
			session.close();
		}
		return list;
	}

	public List<T> list(int startPosition, int maxResults) {
		setOrder(order);
		List<T> list = null;
		try {
			criteria.setMaxResults(maxResults);
			criteria.setFirstResult(startPosition);
			list = criteria.list();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int rowCount() {
		CriteriaImpl ci = (CriteriaImpl) criteria;
		Projection pro = ci.getProjection();
		Integer rouCount = 0;
		try {
			criteria.setProjection(Projections.rowCount());
			rouCount = Integer.parseInt(String.valueOf(criteria.uniqueResult().toString()));
			criteria.setProjection(pro);
		} finally {
			session.close();
		}
		return rouCount;
	}

	private Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	@Override
	public IEntityQuery<T> neProperty(String property, String otherProperty) {
		criteria.add(Restrictions.neProperty(property, otherProperty));
		return this;
	}

	public void setOrder(Order order) {
		if (order != null) {
			criteria.addOrder(order);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> querySQL(String queryString, Object[] parameters) {
		List<T> resultList = null;
		SQLQuery query = sessionFactory.openSession().createSQLQuery(queryString);
		try {
			if (null != parameters) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			resultList = query.list();
			session.flush();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> querySQLforMap(String queryString, Object[] parameters) {
		List<Map<String,Object>> resultList = null;
		Query query = sessionFactory.openSession().createSQLQuery(queryString).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		try {
			if (null != parameters) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			resultList = query.list();
			session.flush();
		} finally {
			session.close();
		}
		return resultList;
	}
}
