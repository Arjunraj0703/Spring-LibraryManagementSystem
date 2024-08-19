package com.library.rest.libraryrest.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.rest.libraryrest.entity.LibrarystudentEntity;
import com.library.rest.libraryrest.exception.ServiceException;
import com.library.rest.libraryrest.extractor.LibraryExtractor;
import com.library.rest.libraryrest.model.LibStudModel;
import com.library.rest.libraryrest.repo.LibraryStudentRepository;

@Service
public class LibraryRestService {

	List<LibStudModel> libstudmemberlist=new ArrayList<LibStudModel>();
	
	@Autowired
	@Qualifier("myRest")
	RestTemplate restTemplate;
	
	@Autowired
	LibraryStudentRepository libraryStudentRepository;
	
	@Autowired
	LibraryExtractor libraryExtractor;

	
	public List<LibStudModel> saveLibStudent(LibStudModel libStudModel) {
		List<LibStudModel> libStudModelList=new ArrayList<LibStudModel>();

		//if (libStudModel != null && libStudModel.getBooks() !=null &&!libStudModel.getBooks().isEmpty() && libStudModel.getBooks().size() <= 2) {
			//libstudmemberlist.add(libStudModel);
			
			//ResponseEntity<String> res=restTemplate.exchange("http://localhost:9090/getReport", HttpMethod.GET,HttpEntity.EMPTY, String.class);
			//System.out.println(res.getBody());
			
			;
			
			libraryStudentRepository.save(libraryExtractor.getLibStudEntityFromModel(libStudModel));
			
			List<LibrarystudentEntity> libStudList=libraryStudentRepository.findAll();
			
			
			for(LibrarystudentEntity librarystudentEntity: libStudList) {
				LibStudModel libStudMo=new LibStudModel();
				libStudMo.setRollNo(librarystudentEntity.getRollno());
				libStudMo.setAge(librarystudentEntity.getAge());
				libStudMo.setSection(librarystudentEntity.getSection());
				libStudModelList.add(libStudModel);
			}
			
			
			/*
			 * }else { throw new ServiceException("More than 2 books re not allowed..!"); }
			 */
		return libStudModelList;
	}


	public LibStudModel getLibStudent(String rollNo) {
		// TODO Auto-generated method stub
		LibStudModel retLibStudModel=new LibStudModel();
		retLibStudModel.setMsg("Student Not available");

		for(LibStudModel libStudModel:libstudmemberlist) {
			if(libStudModel.getRollNo()!=null && libStudModel.getRollNo().equals(rollNo)) {
				retLibStudModel= libStudModel;
				retLibStudModel.setMsg(null);
			}
		}
	
		return retLibStudModel;
	}


	public List<LibStudModel> removeLibStudent(String rollNo) {
		// TODO Auto-generated method stub
		List<LibStudModel> retLibStudModelList=new ArrayList<LibStudModel>();

		List<LibrarystudentEntity> listTobeDeleted =libraryStudentRepository.findByRollno(rollNo);
		
		for(LibrarystudentEntity librarystudentEntity:listTobeDeleted ) {
			libraryStudentRepository.delete(librarystudentEntity);
		}
		
		List<LibrarystudentEntity> libStudList=libraryStudentRepository.findAll();
		
		
		return libraryExtractor.convertAllLibStudToModel(libStudList);
	}

}
