package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.entities.FlatEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.FlatDAOInt;

@Service("service")
public class FlatEntityServiceImp implements FlatServiceInt{
  @SuppressWarnings("rawtypes")
@Autowired
  FlatDAOInt flatDao;
    @SuppressWarnings("unchecked")
	@Override
  public List<FlatEntity> showFlatEntity() {
    	//flat list is created which acts like an in memory database for flat object
    System.out.println("Service layer entity called");
    return (List<FlatEntity>) flatDao.findAll();
    
  }
    @SuppressWarnings("unchecked")
	@Transactional		//applies as a default to all methods
  @Override
  public FlatEntity add(FlatEntity request) throws DuplicateRecordException {
      Optional<FlatEntity> flat=flatDao.findById(request.getId());
      if(flat.isPresent()) {
    	  //value is present , ispresent() save method will return saved entity
        throw new DuplicateRecordException("flat entity with this name "+request.getId()+"already exist");
      }
      else {
    	  
        return (FlatEntity)flatDao.save(request);
      }
      
  
    
    
  }
    @SuppressWarnings("unchecked")
	@Transactional
  @Override
  public FlatEntity update(FlatEntity bean) throws RecordNotFoundException{
  
    Optional<FlatEntity> flat=flatDao.findById(bean.getId());
    if(flat.isPresent()) {
    	return (FlatEntity)flatDao.save(bean);
       
      }
      else {
    	  throw new RecordNotFoundException("flat entity with this name "+bean.getId()+"already exist");
       
      }
      
  
    
    
  }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public boolean deleteFlatById(long FlatId) {
        flatDao.deleteById(FlatId);
        return false ;
        
    }
  @SuppressWarnings("unchecked")
@Override
  public FlatEntity findById(long flatEntityTestId) {
    Optional <FlatEntity> flat=flatDao.findById(flatEntityTestId);
    return flat.get();
  }
  public void save(FlatEntity testFlatEntity) {
    
  }
}