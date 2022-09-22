package com.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.FlatEntity;


@Repository
public interface FlatDAOInt extends CrudRepository<FlatEntity, Long>{

	
	
}