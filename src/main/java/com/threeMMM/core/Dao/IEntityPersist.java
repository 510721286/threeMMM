package com.threeMMM.core.Dao;


public interface IEntityPersist {
	
	public void save(Object object);

	public void update(Object object);
	
	public void saveOrUpdate(Object object);
	
	public void remove(Object object);
	
	public void execute(String object); 
	
	public void execute(String sql,Object [] parameters);
}
