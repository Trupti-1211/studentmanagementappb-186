package edu.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.main.model.Student;
@Repository
public interface repository extends JpaRepository<Student,Integer>{

	
	
	public List<Student> findByBatchNumber(String batchNumber);
}
