package edu.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.main.model.Student;
import edu.cjc.main.servicei.serviceI;

@Controller
public class HomeController {

	@Autowired
	serviceI si;
	
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		if(username.equals("admin") && password.equals("admin"))
		{
			List<Student> list=si.getAllStudents();
			m.addAttribute("data",list);
			return "admin";
		}else {
			m.addAttribute("login_fail","ivalid login");
			return "login";
		}
	}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		      si.saveStudent(s);
		   List<Student> list=si.getAllStudents();   
		      m.addAttribute("data",list);
		return "admin";
	}
	@RequestMapping("/search")
	public String searchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
		List<Student> list=si.searchStudentsByBatch(batchNumber);
		m.addAttribute("data", list);
		return "admin";
	}
	@RequestMapping("/fees")
	public String onFees(@RequestParam("id") int id,Model m) {
		Student stu=si.getStudentById(id);
		m.addAttribute("st", stu);
		return "feesupdate";
	}
	
	@RequestMapping("/payfees")
	public String updateFees(@RequestParam("studentid") int studentId,@RequestParam("ammount") double ammount,Model m) {
		si.updateFees(studentId,ammount);
		m.addAttribute("data",si.getAllStudents());
		return "admin";
	}
	
	@RequestMapping("/remove")
	public String deleteStudent(@RequestParam("id") int id,Model m) {
		    si.deleteStudent(id);
		m.addAttribute("data", si.getAllStudents());
		return "admin";
	}
	
	
	
}

	
	

