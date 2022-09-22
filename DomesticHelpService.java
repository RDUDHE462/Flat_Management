package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.DomesticHelpEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;


@Service
public interface DomesticHelpService {
List<DomesticHelpEntity> showDomesticHelpEntity();
	public DomesticHelpEntity add(DomesticHelpEntity bean)throws DuplicateRecordException;
	
	public DomesticHelpEntity update(DomesticHelpEntity bean) throws RecordNotFoundException;
	
	
	public boolean deleteDomesticHelpById(long domesticHelpId);
	
	public DomesticHelpEntity findById(long Id);
	
	
	
}
