package wuhao.springboot.mp.mapper;

import wuhao.springboot.mp.entity.Course;

import java.util.List;

public interface CourseMapper {

    List<Course> selectAll();
}
