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

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.prv.sms.entity.Student;
import com.prv.sms.repository.StudentRepository;
import com.prv.sms.vo.StudentVO;

@SpringBootTest
public class StudentServiceImplTest {
	@Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void testGetStudentsSuccess() {
        // Mock data
        Student student = new Student();
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

        List<Student> mockStudents = Arrays.asList(student);

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
