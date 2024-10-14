package wuhao.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wuhao.springboot.mp.entity.Course;
import wuhao.springboot.mp.entity.StudentCourse;

import java.util.List;

/**
 * @author PC
 */
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT c. * FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(long studentId);
}
