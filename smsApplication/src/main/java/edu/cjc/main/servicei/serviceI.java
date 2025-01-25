package edu.cjc.main.servicei;

import java.util.List;

import edu.cjc.main.model.Student;

public interface serviceI {

	void saveStudent(Student s);
public List<Student> getAllStudents();
public List<Student> searchStudentsByBatch(String batchNumber);
Student getStudentById(int id);
void updateFees(int studentId, double ammount);
void deleteStudent(int id);
}


