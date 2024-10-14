package wuhao.springboot.database.mapper;







import wuhao.springboot.database.entity.Course;

import java.util.List;

    /**
     * @author PC
     */
    public interface CourseMapper {
        List<Course> selectAll();
    }



