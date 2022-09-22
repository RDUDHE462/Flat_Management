package com.demo.controller.test;



import static org.junit.jupiter.api.Assertions.assertThrows;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import org.springframework.test.context.ActiveProfiles;

import com.demo.controller.FlatRentEntityController;
import com.demo.entities.FlatRentEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.FlatRentService;


@SuppressWarnings("unused")
@ActiveProfiles("test")
@SpringBootTest
public class FlatRentEntityControllerTest {

   @Autowired
    private FlatRentService FlatRentService;

   @MockBean
   private FlatRentEntityController flatRentCon;

   @Test
   void deleteFlatRentTest() throws ParseException, DuplicateRecordException {
       FlatRentEntity testFlatRentEntity = new FlatRentEntity("Salini", "98", "9000", "2bhk");
       FlatRentEntity testFlatRentEntitySaved = FlatRentService.add(testFlatRentEntity);
       long flatRentEntityTestId = testFlatRentEntitySaved.getId();
       FlatRentService.deleteFlatRentById(flatRentEntityTestId);
       Assertions.assertThrows(NoSuchElementException.class, () -> {
           FlatRentService.findById(flatRentEntityTestId);
       });



  }

   @Test
   public void saveFlatRentTest() throws ParseException, DuplicateRecordException {
       FlatRentEntity testFlatRentEntity = new FlatRentEntity("Salini", "98", "9000", "2bhk");
       FlatRentEntity testFlatRentEntitySaved = FlatRentService.add(testFlatRentEntity);
       long flatRentEntityTestId = testFlatRentEntitySaved.getId();



      FlatRentEntity testFlatRentEntityDB = FlatRentService.findById(flatRentEntityTestId);
       Assertions.assertNotNull(testFlatRentEntityDB);



      FlatRentService.deleteFlatRentById(flatRentEntityTestId);
   }
   
  /* @Test
   void TestRecordFlatRentByIdShouldThrowFlatIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
         FlatRentEntity f2 = new FlatRentEntity();
         FlatRentService.update(f2);
       });
   }*/



  
   
}
