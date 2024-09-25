package wuhao.springboot.configure.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wuhao.springboot.configure.entity.Special;

import java.util.List;

/**
 * @author PC
 */
@Mapper
public interface SpecialMapper {
    @Select("SELECT * FROM list ORDER BY updated DESC ")
    List<Special> findAll();

}
