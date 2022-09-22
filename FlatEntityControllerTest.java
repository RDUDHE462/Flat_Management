package com.demo.controller.test;



import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;


import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ActiveProfiles;

import com.demo.controller.FlatEntityController;
import com.demo.entities.FlatEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;

import com.demo.service.FlatServiceInt;

@SuppressWarnings("unused")
@ActiveProfiles("test")
@SpringBootTest
public class FlatEntityControllerTest {



   @Autowired
    private FlatServiceInt flatService;

   @MockBean
   private FlatEntityController flatCon;



   @Test
    void deleteFlatTest() throws ParseException, DuplicateRecordException {
      
        FlatEntity testFlatEntity = new FlatEntity("Vivek", "901", "30", "1 bhk");
        FlatEntity testFlatEntitySaved = flatService.add(testFlatEntity);
        long flatEntityTestId = testFlatEntitySaved.getId();
        flatService.deleteFlatById(flatEntityTestId);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
          flatService.findById(flatEntityTestId);
        });
        
   }

   @Test
    public void saveFlatTest() throws ParseException, DuplicateRecordException {

     FlatEntity testFlatEntity = new FlatEntity("Vivek", "901", "30", "1 bhk");
       FlatEntity testFlatEntitySaved = flatService.add(testFlatEntity);
       long flatEntityTestId = testFlatEntitySaved.getId();

       FlatEntity testFlatEntityDB = flatService.findById(flatEntityTestId);
        Assertions.assertNotNull(testFlatEntityDB);



      flatService.deleteFlatById(flatEntityTestId);
    }
   
   @Test
   void TestRecordFlatByIdShouldThrowFlaIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
          FlatEntity f = new FlatEntity();
          flatService.update(f);
       });
   }
}
