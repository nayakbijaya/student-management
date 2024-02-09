package com.prv.sms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.prv.sms.entity.Student;
import com.prv.sms.repository.StudentRepository;
import com.prv.sms.vo.StudentVO;

@SpringBootTest
public class StudentServiceImplTest {
	@Mock
    private StudentRepository studentRepository;
	
	@Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;
    Student student;
    List<Student> mockStudents;
    
    @BeforeEach
    void setUp() throws Exception {
    	MockitoAnnotations.openMocks(this);
    	student = new Student();
        student.setId(1);
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setEmail("john.doe@example.com");
        student.setAge(25);
        student.setDob(new Date());
        student.setSex('M');
        student.setDept("Computer Science");
        student.setCoursename("Database Management");
        student.setRoleno("A12345");
        student.setSection("A");

        mockStudents = Arrays.asList(student);
    	StudentVO studentVO1 = new StudentVO();
    	studentVO1.setId(1);
    	studentVO1.setFirstname("John");
    	studentVO1.setLastname("Doe");
    	studentVO1.setEmail("john.doe@example.com");
    	studentVO1.setAge(25);
    	studentVO1.setDob(new Date());
    	studentVO1.setSex('M');
    	studentVO1.setDept("Computer Science");
    	studentVO1.setCoursename("Database Management");
    	studentVO1.setRoleno("A12345");
    	studentVO1.setSection("A");
    	when(modelMapper.map(student, StudentVO.class)).thenReturn(studentVO1);
    }

    @Test
    void testGetStudentsSuccess() {
        // Mock behavior of studentRepository
        when(studentRepository.findAll()).thenReturn(mockStudents);

        // Execute the method
        List<StudentVO> result = studentService.getStudents();

        // Verify the result
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstname());
    }

    @Test
    void testGetStudentsEmptyList() {
        // Mock behavior of studentRepository
        when(studentRepository.findAll()).thenReturn(new ArrayList<>());

        // Execute the method and expect an exception
        assertThrows(RuntimeException.class, () -> studentService.getStudents());
    }
}
