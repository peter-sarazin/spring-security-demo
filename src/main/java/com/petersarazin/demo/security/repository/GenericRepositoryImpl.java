package com.petersarazin.demo.security.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericRepositoryImpl<T extends Serializable> implements GenericRepository<T>
{
	@PersistenceContext( type = PersistenceContextType.TRANSACTION )
	protected EntityManager em;
	
	public void persist( T entity )
	{ 
		if( entity == null )
		{
			throw new IllegalArgumentException( "entity must not be null." );
		}
		
		em.persist( entity );
	}

	public void merge( T entity )
	{ 
		if( entity == null )
		{
			throw new IllegalArgumentException( "entity must not be null." );
		}
		
		em.merge( entity );
	}

    public void remove( T entity )
	{
		if( entity == null )
		{
			throw new IllegalArgumentException( "entity must not be null." );
		}
		
        em.remove( em.contains( entity ) ? entity : em.merge( entity ) );
    }
	
	public void flush()
	{ 
		em.flush();
	}

	public T findById( Class<T> clazz, Serializable primaryKey )
	{
		if( primaryKey == null )
		{
			throw new IllegalArgumentException( "primaryKey must not be null." );
		}
		
		return em.find( clazz, primaryKey );
	}
	
	
	public List<T> findAll( Class<T> clazz )
	{
		if( clazz == null )
		{
			throw new IllegalArgumentException( "clazz must not be null." );
		}
		
		return findAll( clazz, clazz.getSimpleName() );
	}
	
	
	public List<T> findAll( Class<T> clazz, String tableName )
	{
		if( clazz == null )
		{
			throw new IllegalArgumentException( "clazz must not be null." );
		}
		else if( tableName == null )
		{
			throw new IllegalArgumentException( "tableName must not be null." );
		}

		return em.createQuery( "select e from " + tableName + " e", clazz ).getResultList();
	}
	
	
	public void addEqualsConditionToPredicateList( CriteriaBuilder cb, Root<T> entity, List<Predicate> predicateList, String propertyName, String propertyValue )
	{
		if( propertyValue != null && !( propertyValue.trim().isEmpty() ) )
		{
			Predicate predicate = cb.and( cb.equal( entity.get( propertyName ), propertyValue ) );
			predicateList.add( predicate );
		}
	}

	public void addContainsConditionToPredicateList( CriteriaBuilder cb, Root<T> entity, List<Predicate> predicateList, String propertyName, String propertyValue )
	{
		if( propertyValue != null && !( propertyValue.trim().isEmpty() ) )
		{
			Path path = entity.get( propertyName );
			Predicate predicate = cb.and( cb.like( path, "%" + propertyValue + "%" ) );
			predicateList.add( predicate );
		}
	}
	
	public void addStartsWithConditionToPredicateList( CriteriaBuilder cb, Root<T> entity, List<Predicate> predicateList, String propertyName, String propertyValue )
	{
		if( propertyValue != null && !( propertyValue.trim().isEmpty() ) )
		{
			Path path = entity.get( propertyName );
			Predicate predicate = cb.and( cb.like( path, propertyValue + "%" ) );
			predicateList.add( predicate );
		}
	}
	
	
}
