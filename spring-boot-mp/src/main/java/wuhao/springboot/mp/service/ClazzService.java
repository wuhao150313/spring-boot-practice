package wuhao.springboot.mp.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wuhao.springboot.mp.entity.Clazz;
import wuhao.springboot.mp.entity.Teacher;
import wuhao.springboot.mp.mapper.ClazzMapper;

/**
 * @author PC
 */
@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;

    public Clazz getClazzWithTeacher(Long clazzId){
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz!= null){
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}
