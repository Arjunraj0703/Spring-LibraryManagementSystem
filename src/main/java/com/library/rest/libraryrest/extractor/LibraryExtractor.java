package com.library.rest.libraryrest.extractor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.library.rest.libraryrest.entity.LibrarystudentEntity;
import com.library.rest.libraryrest.model.LibStudModel;

@Component
public class LibraryExtractor {

	public LibrarystudentEntity getLibStudEntityFromModel(LibStudModel libStudModel){
		LibrarystudentEntity le=new LibrarystudentEntity();
		if(libStudModel.getLibrarystudentid() !=null) {
		le.setLibrarystudentid(libStudModel.getLibrarystudentid());
		}
		le.setRollno(libStudModel.getRollNo());
		le.setSection(libStudModel.getSection());
		le.setAge(libStudModel.getAge());
		
		return le;
	}
	
	public List<LibStudModel> convertAllLibStudToModel(List<LibrarystudentEntity> librarystudentEntitys){
		List<LibStudModel> retLibStudModelList=new ArrayList<LibStudModel>();

		for(LibrarystudentEntity librarystudentEntity: librarystudentEntitys) {
			LibStudModel libStudMo=new LibStudModel();
			libStudMo.setRollNo(librarystudentEntity.getRollno());
			libStudMo.setAge(librarystudentEntity.getAge());
			libStudMo.setSection(librarystudentEntity.getSection());
			retLibStudModelList.add(libStudMo);
		}
		return retLibStudModelList;
	}
}
