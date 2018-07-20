package com.petersarazin.demo.security.repository;

import java.io.Serializable;
import java.util.List;


public interface GenericRepository<T extends Serializable>
{
	T findById( Class<T> clazz, Serializable primaryKey );
	void persist( T entity );
	void merge( T entity );
	void remove( T entity );
	void flush();
	
	/**
	 * In order for this to work your class name must be equal to your table name. Alternatively use the version that takes the
	 * table name separately as the second parameter.
	 * 
	 * @see findAll( Class<T> clazz, String tableName )
	 * 
	 * @param clazz
	 * @return
	 */
	List<T> findAll( Class<T> clazz );
	
	List<T> findAll( Class<T> clazz, String tableName );
}