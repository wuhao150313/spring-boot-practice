package wuhao.springboot.mp.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wuhao.springboot.mp.entity.Course;
import wuhao.springboot.mp.entity.Student;
import wuhao.springboot.mp.mapper.StudentCourseMapper;
import wuhao.springboot.mp.mapper.StudentMapper;

import java.util.List;

/**
 * @author PC
 */
@Service
@AllArgsConstructor
public class StudentService {

    private final StudentCourseMapper studentCourseMapper;
    private final StudentMapper studentMapper;

    public Student getStudentWithCourses(Long studentId){
        Student student = studentMapper.selectById(studentId);
        if(student != null){
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;

    }
}
