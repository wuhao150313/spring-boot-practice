package wuhao.springboot.mp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.mp.entity.Student;
import wuhao.springboot.mp.service.StudentService;

/**
 * @author PC
 */
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    /**
     * 获取学⽣及其课程信息
     */
    @GetMapping("/{id}/courses")
    public Student getStudentWithCourses(@PathVariable Long id) {
        return studentService.getStudentWithCourses(id);
    }
}
