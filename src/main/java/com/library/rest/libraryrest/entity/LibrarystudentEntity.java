package com.library.rest.libraryrest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "librarystudent",schema = "library")
public class LibrarystudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer librarystudentid;
	
	@Column(name = "rollno")
	String rollno;
	int age;
	String section;
	public int getLibrarystudentid() {
		return librarystudentid;
	}
	public void setLibrarystudentid(int librarystudentid) {
		this.librarystudentid = librarystudentid;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
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
	
}
