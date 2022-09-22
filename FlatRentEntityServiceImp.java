package com.demo.service;



import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.FlatRentEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.FlatRentDAO;



@Service("flatrentservice")
public class FlatRentEntityServiceImp implements FlatRentService {



   @SuppressWarnings("rawtypes")
    @Autowired
    FlatRentDAO flatRentDao;
   
   @SuppressWarnings("unchecked")
   @Override
   public List<FlatRentEntity> showFlatRentEntity() {
	   //flatrent entity is created is act like a  memory database for flat rent object
       System.out.println("Service layer entity called");
       return (List<FlatRentEntity>) flatRentDao.findAll();



  }



  @SuppressWarnings("unchecked")
  @Override
   public FlatRentEntity add(FlatRentEntity request) throws DuplicateRecordException {
       
       Optional<FlatRentEntity> flatrent = flatRentDao.findById(request.getId());
       if (flatrent.isPresent()) {
    	   // //value is present , ispresent() save method will return saved entity
           throw new DuplicateRecordException(
                   "domestic help entity with this name " + request.getId() + "already exist");
       } else {
           return (FlatRentEntity) flatRentDao.save(request);
       }



  }
  
  @SuppressWarnings("unchecked")
  @Transactional
  @Override
  public FlatRentEntity update(FlatRentEntity bean) throws RecordNotFoundException{



   Optional<FlatRentEntity> flatrent = flatRentDao.findById(bean.getId());
     if(flatrent.isPresent()) {
         throw new RecordNotFoundException("flat rent entity with this name "+bean.getId()+"already exist");
     }
     else {
         return (FlatRentEntity)flatRentDao.save(bean);
     }
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public boolean deleteFlatRentById(long FlatRentId) {
      flatRentDao.deleteById(FlatRentId);
      return false;
  }



   @Override
      public FlatRentEntity findById(long flatRentEntityTestId) {
          @SuppressWarnings("unchecked")
          Optional <FlatRentEntity> flatrent=flatRentDao.findById(flatRentEntityTestId);
          return flatrent.get();
      }



 public void save(FlatRentEntity testFlatRentEntity) {
      
}
}