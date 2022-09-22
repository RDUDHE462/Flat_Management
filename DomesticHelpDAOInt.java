package com.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.DomesticHelpEntity;


@Repository
public interface DomesticHelpDAOInt extends CrudRepository<DomesticHelpEntity, Long>{

	
	
}
