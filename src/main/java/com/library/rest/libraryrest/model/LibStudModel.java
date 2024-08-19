package com.library.rest.libraryrest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class LibStudModel {

	@JsonInclude(value = Include.NON_NULL)
	String name;
	@JsonInclude(value = Include.NON_NULL)
	String rollNo;
	@JsonInclude(value = Include.NON_NULL)
	int age;
	@JsonInclude(value = Include.NON_NULL)
	String section;
	@JsonInclude(value = Include.NON_NULL)
	List<Book> books;
	
	Integer librarystudentid; 
	
	String msg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getLibrarystudentid() {
		return librarystudentid;
	}
	public void setLibrarystudentid(Integer librarystudentid) {
		this.librarystudentid = librarystudentid;
	}
	
	
}
