package com.prv.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prv.sms.service.StudentService;
import com.prv.sms.vo.StudentVO;

@RestController
@RequestMapping(value="sms")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public ResponseEntity<List<StudentVO>> getStudents(){
		LOGGER.info("Inside getstudent controller");
		return ResponseEntity.ok(studentService.getStudents());
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentVO> getStudentById(@PathVariable("id") int id){
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	@PostMapping("/student")
	public ResponseEntity<StudentVO> addStudent(@RequestBody StudentVO studentVO){
		return ResponseEntity.ok(studentService.addStudent(studentVO));
	}
	@PutMapping("/student")
	public ResponseEntity<StudentVO> editStudent(@RequestBody StudentVO studentVO){
		return ResponseEntity.ok(studentService.editStudent(studentVO));
	}
	@DeleteMapping("/student")
	public ResponseEntity<String> deleteStudents(@RequestBody StudentVO studentVO){
		return ResponseEntity.ok(studentService.deleteStudent(studentVO));
	}
}
