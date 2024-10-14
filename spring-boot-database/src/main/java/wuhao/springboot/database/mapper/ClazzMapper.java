package wuhao.springboot.database.mapper;


import org.apache.ibatis.annotations.Param;
import wuhao.springboot.database.entity.Clazz;

/**
 * @author PC
 */
public interface ClazzMapper {

    Clazz getClazzById(int clazzId);

    Clazz getClazz(int clazzId);

}
