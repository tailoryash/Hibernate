package com.goal.jpademo.service;

import com.goal.jpademo.dto.StudentCourseDto;
import com.goal.jpademo.entity.relation.Course;
import com.goal.jpademo.entity.relation.Student;
import com.goal.jpademo.repository.CourseRepository;
import com.goal.jpademo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public Student findStudent(int id) {
        return studentRepository.findBydId(id);
    }

    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(int id) {
       studentRepository.deleteById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.saveStudent(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public String enroll(StudentCourseDto studentCourseDto) {
        Student student = studentRepository.findBydId(studentCourseDto.getStudentId());
        Course course = courseRepository.findById(studentCourseDto.getCourseId());
        if(student != null && course != null){
            studentRepository.saveStudentAndCourse(student,course);
            return "Enrolled Successfully";
        }
        return "Invalid Data";
    }

    public List<Student> studentsWithStartingLetterA() {
        return studentRepository.studentsWithStartingLetterA();
    }
}

