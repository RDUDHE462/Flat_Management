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

import com.demo.entities.DomesticHelpEntity;

import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.DomesticHelpService;

@RestController // use to handle request
@RequestMapping(value = "/domestichelpentity") // map specific request path
public class DomesticHelpEntityController {

	@Autowired // enable to inject dependency
	DomesticHelpService domesticHelpService;

	@GetMapping(value = "/show", produces = "application/json")		// http://localhost:8080/UserApp/domestichelpentity/show
	List<DomesticHelpEntity> showDomesticHelpEntity() {
		System.out.println("domesticHelp entity controller");
		List<DomesticHelpEntity> domesticHelpList = domesticHelpService.showDomesticHelpEntity();
		return domesticHelpList;
	}

	@GetMapping(value = "/show3", produces = "application/json")
	public ResponseEntity<DomesticHelpEntity> findById(@PathVariable("Id") long Id) {
		DomesticHelpEntity domesticHelp = domesticHelpService.findById(Id);
		return new ResponseEntity<DomesticHelpEntity>(domesticHelp, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")		// http://localhost:8080/UserApp/domestichelpentity
	ResponseEntity<DomesticHelpEntity> add(@RequestBody DomesticHelpEntity domesticHelp)
			throws DuplicateRecordException {

		DomesticHelpEntity id = domesticHelpService.add(domesticHelp);
		if (id.getId() == 0) {
			System.out.println("Before exception");

			throw new DuplicateRecordException("DomesticHelpEntity with this id already Exist");
		}
		System.out.println("DomesticHelpEntity name in controller is " + id);
		return ResponseEntity.ok(id);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")		// http://localhost:8080/UserApp/domestichelpentity
	ResponseEntity<DomesticHelpEntity> update(@RequestBody DomesticHelpEntity domesticHelp)
			throws RecordNotFoundException {
		DomesticHelpEntity id = domesticHelpService.update(domesticHelp);

		if (id == null) {
			throw new RecordNotFoundException(
					"DeliveryEntity with this name " + domesticHelp.getId() + "already Exist");

		}
		System.out.println("DomesticHelpEntity name in controller is " + id);
		return ResponseEntity.ok(id);
	}

	@DeleteMapping(value = "/show2/{DomesticHelpId}", produces = "application/json")		// http://localhost:8080/UserApp/domestichelpentity/show2/id
	public ResponseEntity<DomesticHelpEntity> deleteDomesticHelpById(
			@PathVariable("DomesticHelpId") long DomesticHelpId) throws RecordNotFoundException {
		domesticHelpService.deleteDomesticHelpById(DomesticHelpId);
		return new ResponseEntity<DomesticHelpEntity>(HttpStatus.OK);
	}
}