package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.entities.DomesticHelpEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.DomesticHelpDAOInt;


@Service("domesticservice")
public class DomesticHelpEntityServiceImp implements DomesticHelpService{
	@SuppressWarnings("rawtypes")
	@Autowired
	DomesticHelpDAOInt domesticHelpDao;
    @SuppressWarnings("unchecked")
	@Override
	public List<DomesticHelpEntity> showDomesticHelpEntity() {
    	//domestichelp list is created act like a memory database for domestichelp object
		System.out.println("Service layer entity called");
		return (List<DomesticHelpEntity>) domesticHelpDao.findAll();
		
	}
    @SuppressWarnings("unchecked")
	@Transactional  //applies to default to all method
	@Override
	public DomesticHelpEntity add(DomesticHelpEntity request) throws DuplicateRecordException{
    	Optional<DomesticHelpEntity> domesticHelp=domesticHelpDao.findById(request.getId());
    	
    	if(domesticHelp.isPresent()) {
    		// //value is present , ispresent() save method will return saved entity
    			throw new DuplicateRecordException("DomesticHelp Entity with this name "+request.getId()+"already Exist");
    		}
    	else
    	{
    		return (DomesticHelpEntity)domesticHelpDao.save(request);
    	}
    
    	
		
	}
    @SuppressWarnings("unchecked")
	@Transactional
	@Override
	public DomesticHelpEntity update(DomesticHelpEntity bean) throws RecordNotFoundException{
    	//domesticHelpDao.save(bean);
		Optional<DomesticHelpEntity> domesticHelp=domesticHelpDao.findById(bean.getId());
		if(domesticHelp.isPresent()) {
			return (DomesticHelpEntity) domesticHelpDao.save(bean);
		}
		else
		{
			throw new RecordNotFoundException("DomesticHelp Entity  id "+bean.getId()+"Doesn't Exist");
		}
		
    	}
		//DomesticHelpEntity beanupdated=updatedDomesticHelp.get();
		//return (DomesticHelpEntity)domesticHelpDao.save(bean);
	//}
    
    @SuppressWarnings("unchecked")
	@Override
    public boolean deleteDomesticHelpById(long DomesticHelpId) {
        domesticHelpDao.deleteById(DomesticHelpId);
        return false ;
		
	}
    @Override
    public DomesticHelpEntity findById(long domesticHelpEntityTestId) {
        @SuppressWarnings("unchecked")
        Optional <DomesticHelpEntity> domesticHelp=domesticHelpDao.findById(domesticHelpEntityTestId);
        return domesticHelp.get();
    }



public void save(DomesticHelpEntity testDomesticHelpEntity) {
    
    
}

	

}