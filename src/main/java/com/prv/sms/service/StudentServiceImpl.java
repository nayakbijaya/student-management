package com.prv.sms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prv.sms.entity.Student;
import com.prv.sms.repository.StudentRepository;
import com.prv.sms.vo.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<StudentVO> getStudents() {
		try {
			LOGGER.info("Inside getStudents");
			final List<Student> students = studentRepository.findAll();
			if (students.isEmpty()) {
				LOGGER.info("Student list is empty");
				throw new RuntimeException("Student list is empty");
			}
			LOGGER.info("Total student found {}", students.size());
			/*
			 * // Initialise the return type List<StudentVO> studentVOs = new
			 * ArrayList<StudentVO>(); // process the entity to convert dto/vo type
			 * students.forEach(student->{ // create dto/vo type objcet for each student
			 * from db StudentVO studentVO = new StudentVO(); // set all the required field
			 * value from student object studentVO.setId(student.getId());
			 * studentVO.setFirstname(student.getFirstname());
			 * studentVO.setLastname(student.getLastname());
			 * studentVO.setEmail(student.getEmail()); studentVO.setAge(student.getAge());
			 * studentVO.setDob(student.getDob()); studentVO.setSex(student.getSex());
			 * studentVO.setDept(student.getDept());
			 * studentVO.setCoursename(student.getCoursename());
			 * studentVO.setRoleno(student.getRoleno());
			 * studentVO.setSection(student.getSection()); // add to the list
			 * studentVOs.add(studentVO); }); return studentVOs;
			 */
			// Process the entity to convert to DTO/VO type using model mapper
			List<StudentVO> studentVOs = students.stream().map(student -> modelMapper.map(student, StudentVO.class))
					.collect(Collectors.toList());
			System.err.println("studentVOs: " + studentVOs.size());
			return studentVOs;
		} catch (final Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public StudentVO getStudentById(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentVO addStudent(final StudentVO studentVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentVO editStudent(final StudentVO studentVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(final StudentVO studentVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
