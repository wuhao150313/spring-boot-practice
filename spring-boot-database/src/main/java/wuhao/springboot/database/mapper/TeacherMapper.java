package wuhao.springboot.database.mapper;

import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;
import wuhao.springboot.database.entity.Teacher;

/**
 * @author PC
 */
public interface TeacherMapper {

    Teacher findTeacherById(int teacherId);

}
