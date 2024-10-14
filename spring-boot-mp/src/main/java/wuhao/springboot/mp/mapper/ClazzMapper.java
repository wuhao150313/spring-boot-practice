package wuhao.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wuhao.springboot.mp.entity.Clazz;
import wuhao.springboot.mp.entity.Teacher;

/**
 * @author PC
 */
public interface ClazzMapper extends BaseMapper<Clazz> {

    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);

}
