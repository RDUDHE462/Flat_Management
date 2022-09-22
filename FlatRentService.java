package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.FlatRentEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@Service
public interface FlatRentService {
List<FlatRentEntity> showFlatRentEntity();
	public FlatRentEntity add(FlatRentEntity bean) throws DuplicateRecordException;
	
	public FlatRentEntity update(FlatRentEntity bean)throws RecordNotFoundException;
	
	
	public boolean deleteFlatRentById(long FlatRentId);
	public FlatRentEntity findById(long Id);
	
	
	
}
