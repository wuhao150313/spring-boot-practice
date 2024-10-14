package wuhao.springboot.database.mapper;


import wuhao.springboot.database.entity.Section;

import java.util.List;

/**
 * @author PC
 */
public interface SpecialMapper {

    List<Section> findAll();
}
