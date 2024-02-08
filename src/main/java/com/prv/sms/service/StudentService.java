package com.prv.sms.service;

import java.util.List;


import com.prv.sms.vo.StudentVO;


public interface StudentService {
	List<StudentVO> getStudents();
	StudentVO getStudentById(int id);
	StudentVO addStudent(StudentVO studentVO);
	StudentVO editStudent(StudentVO studentVO);
	String deleteStudent(StudentVO studentVO);
	
}
