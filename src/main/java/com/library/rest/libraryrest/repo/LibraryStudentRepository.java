package com.library.rest.libraryrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.rest.libraryrest.entity.LibrarystudentEntity;

@Repository
public interface LibraryStudentRepository extends JpaRepository<LibrarystudentEntity, Integer>  {

	
	@Query(nativeQuery = true, value="select * from librarystudent  le where le.rollno=:rollno")
	List<LibrarystudentEntity> findByRollno(String rollno);
	
	@Query("delete from LibrarystudentEntity le where le.rollno=:rollno")
	void deleteByRollno(String rollno);
}
