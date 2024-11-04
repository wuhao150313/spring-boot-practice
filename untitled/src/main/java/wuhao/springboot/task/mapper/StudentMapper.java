package wuhao.springboot.task.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wuhao.springboot.task.entity.Student;

/**
 * @author PC
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
