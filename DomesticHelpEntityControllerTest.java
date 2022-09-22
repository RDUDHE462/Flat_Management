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



import com.demo.controller.DomesticHelpEntityController;
import com.demo.entities.DomesticHelpEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.DomesticHelpService;



@ActiveProfiles("test")
@SpringBootTest
public class DomesticHelpEntityControllerTest {



   @Autowired
    private DomesticHelpService domesticHelpService;



   @MockBean



   private DomesticHelpEntityController domesticHelpCon;

   @SuppressWarnings("unused")
@Test
   void deleteDomesticHelpTest() throws ParseException, DuplicateRecordException {
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
       Date date = formatter.parse("06-06-2022");
       DomesticHelpEntity testDomesticHelpEntity = new DomesticHelpEntity("276", "suhasini", "Deepa", "Cleaning","09:00:00","10:00:00","date");
       DomesticHelpEntity testDomesticHelpEntitySaved = domesticHelpService.add(testDomesticHelpEntity);
       long domestichelpEntityTestId = testDomesticHelpEntitySaved.getId();
       domesticHelpService.deleteDomesticHelpById(domestichelpEntityTestId);
       Assertions.assertThrows(NoSuchElementException.class, () -> {
           domesticHelpService.findById(domestichelpEntityTestId);
       });



  }
   @SuppressWarnings("unused")
@Test
   public void saveDomesticHelpTest() throws ParseException, DuplicateRecordException {



      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
       Date date = formatter.parse("06-06-2022");



      DomesticHelpEntity testDomesticHelpEntity = new DomesticHelpEntity("276", "suhasini", "Deepa", "Cleaning","09:00:00","10:00:00","date");
       DomesticHelpEntity testDomesticHelpEntitySaved = domesticHelpService.add(testDomesticHelpEntity);
       long domesticHelpEntityTestId = testDomesticHelpEntitySaved.getId();



      DomesticHelpEntity testDomesticHelpEntityDB = domesticHelpService.findById(domesticHelpEntityTestId);
       Assertions.assertNotNull(testDomesticHelpEntityDB);



      domesticHelpService.deleteDomesticHelpById(domesticHelpEntityTestId);
   }

   @Test
   void TestRecordDomesticHelpByIdShouldThrowDelIdException() throws RecordNotFoundException {
       assertThrows(RecordNotFoundException.class, () -> {
           DomesticHelpEntity dh = new DomesticHelpEntity();
           domesticHelpService.update(dh);
       });
   }
   
   
}