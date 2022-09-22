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

import com.demo.entities.FlatEntity;

import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.FlatServiceInt;

@RestController // use to handle request
@RequestMapping(value = "/flatentity") // map specific request path
public class FlatEntityController {

	@Autowired // enable to get object dependency
	FlatServiceInt flatService;

	@GetMapping(value = "/show", produces = "application/json") // http://localhost:8080/UserApp/flatentity/show
	List<FlatEntity> showFlatEntity() {
		System.out.println("flat entity controller");
		List<FlatEntity> flatList = flatService.showFlatEntity();
		return flatList;
	}

	@GetMapping(value = "/show3", produces = "application/json")
	public ResponseEntity<FlatEntity> findById(@PathVariable("Id") long Id) {
		// ResponseEntity represent whole HTTP response like status code, headers and
		// body
		FlatEntity flat = flatService.findById(Id);
		return new ResponseEntity<FlatEntity>(flat, HttpStatus.OK);

	}

	@PostMapping(consumes = "application/json", produces = "application/json") // http://localhost:8080/UserApp/flatentity
	ResponseEntity<FlatEntity> add(@RequestBody FlatEntity flat) throws DuplicateRecordException {

		FlatEntity id = flatService.add(flat);

		if (id.getId() == 0) {
			System.out.println("Before Exception");
			throw new DuplicateRecordException("Flat entity with this id already exist");
		}
		System.out.println("FlatEntity name in controller is " + id);
		return ResponseEntity.ok(id);

	}

	@PutMapping(consumes = "application/json", produces = "application/json") // http://localhost:8080/UserApp/flatentity
	public ResponseEntity<FlatEntity> update(@RequestBody FlatEntity flat) throws RecordNotFoundException {
		// @RequestBody is responsible for binding the HTTPRequest to the body of the
		// web request
		FlatEntity id = flatService.update(flat);
		if (id == null) {
			throw new RecordNotFoundException("Domestic help entity with this id " + flat.getId() + "already exist");
		}
		System.out.println("DomesticHelpEntity name in controller is " + id);
		return ResponseEntity.ok(id);

	}

	@DeleteMapping(value = "/show2/{FlatId}", produces = "application/json") // http://localhost:8080/UserApp/flatentity/id
	public ResponseEntity<FlatEntity> deleteFlatById(@PathVariable("FlatId") long FlatId)
			throws RecordNotFoundException {
		flatService.deleteFlatById(FlatId);
		return new ResponseEntity<FlatEntity>(HttpStatus.OK);
	}
}