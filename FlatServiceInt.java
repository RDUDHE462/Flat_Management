package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.FlatEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@Service
public interface FlatServiceInt {
	List<FlatEntity> showFlatEntity();

	public FlatEntity add(FlatEntity bean)throws DuplicateRecordException;
	
	public FlatEntity update(FlatEntity bean)throws RecordNotFoundException;
	
	

	public boolean deleteFlatById(long flatId);
	
	public FlatEntity findById(long Id);
	
	
}