package com.demo.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entities.FlatRentEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.FlatRentService;



@RestController		//use to handle request
@RequestMapping(value = "/flatrententity")	// map specific request path
public class FlatRentEntityController {

	@Autowired			//enable to get object dependency
    FlatRentService flatRentService;



   @GetMapping(value = "/show", produces = "application/json")		//http://localhost:8080/UserApp/flatrententity/show
    List<FlatRentEntity> showFlatrentEntity() {
        System.out.println("Flat entity controller");
        List<FlatRentEntity> flatrentList = flatRentService.showFlatRentEntity();
        return flatrentList;
    }
     @GetMapping(value = "/show3", produces = "application/json")
       public ResponseEntity<FlatRentEntity> findById(@PathVariable("Id")long Id) {
       FlatRentEntity flatrent= flatRentService.findById(Id);
           return new ResponseEntity<FlatRentEntity>(flatrent,HttpStatus.OK);
       }

     @PostMapping(consumes = "application/json", produces = "application/json")		//http://localhost:8080/UserApp/flatrententity
     ResponseEntity<FlatRentEntity> add(@RequestBody FlatRentEntity flatrent) throws DuplicateRecordException {



        FlatRentEntity Id = flatRentService.add(flatrent);



        if (Id.getId() == 0) {
             System.out.println("Before Exception");
             throw new DuplicateRecordException("FlatRent entity with this Id already exist");
         }



        System.out.println("Flat Rent Entity name in controller is " + Id);
         return ResponseEntity.ok(Id);
     }
     
     @PutMapping(consumes = "application/json", produces = "application/json")		//http://localhost:8080/UserApp/flatrententity
     ResponseEntity<FlatRentEntity> update(@RequestBody FlatRentEntity flatrent) throws RecordNotFoundException {
         FlatRentEntity Id = flatRentService.update(flatrent);
         if (Id == null) {
             throw new RecordNotFoundException(
                     "Domestic help entity with this Id " + flatrent.getId() + "already exist");
         }
         System.out.println("FlatRentEntity name in controller is " + Id);
         return ResponseEntity.ok(Id);
     }



    @DeleteMapping(value = "/show2/{FlatRentId}", produces = "application/json")		//http://localhost:8080/UserApp/flatrententity/id
     public ResponseEntity<FlatRentEntity> deleteFlatRentById(@PathVariable("FlatRentId") long FlatRentId) {
         flatRentService.deleteFlatRentById(FlatRentId);
         return new ResponseEntity<FlatRentEntity>(HttpStatus.OK);
     }
 }