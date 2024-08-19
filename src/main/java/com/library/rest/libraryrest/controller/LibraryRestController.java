package com.library.rest.libraryrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.libraryrest.model.LibStudModel;

@RestController
@RequestMapping("/libraryrest")
public class LibraryRestController {
	
	@Autowired
	LibraryRestService libraryRestService;

	
	@PostMapping("/saveLibStudent")
	List<LibStudModel> saveLibStudent(@RequestBody LibStudModel libStudModel){
		
		List<LibStudModel> libstudmemberlist=libraryRestService.saveLibStudent(libStudModel);
		
		
		return libstudmemberlist;
	}
	
	@GetMapping("/getLibStudent/{rollNo}")
	LibStudModel getLibStudent(@PathVariable(name = "rollNo") String rollNo) {
		System.out.println(rollNo);
		return libraryRestService.getLibStudent(rollNo);
	}
	
	@DeleteMapping("/removeLibStudent")
	List<LibStudModel> removeLibStudent(@RequestParam (name = "rollNo") String rollNo) {
		System.out.println(rollNo);
		return libraryRestService.removeLibStudent(rollNo);
	}
	
	
}
