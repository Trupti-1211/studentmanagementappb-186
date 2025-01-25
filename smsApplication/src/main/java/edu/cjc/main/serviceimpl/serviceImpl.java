package edu.cjc.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.main.model.Student;
import edu.cjc.main.repository.repository;
import edu.cjc.main.servicei.serviceI;

@Service
public class serviceImpl  implements serviceI{

	@Autowired
	repository sr;
	
	@Override
	public void saveStudent(Student s) {
		sr.save(s);
		
	}

	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
	}

	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		
		
		return sr.findByBatchNumber(batchNumber);
	}
	@Override
	public Student getStudentById(int id) {
	          Student s    =  sr.findById(id).get();
		return s;
	}

	@Override
	public void updateFees(int studentId, double ammount) {
          	Student s=sr.findById(studentId).get();
          	double amt=s.getFeesPaid()+ammount;
          	
          	s.setFeesPaid(amt);
          	sr.save(s);
	}

	@Override
	public void deleteStudent(int id) {
		
		sr.deleteById(id);
	}

}



