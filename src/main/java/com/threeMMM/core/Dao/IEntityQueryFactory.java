package com.threeMMM.core.Dao;



public interface IEntityQueryFactory {

	<E> IEntityQuery<E> createQuery(Class<E> clazz);
}
