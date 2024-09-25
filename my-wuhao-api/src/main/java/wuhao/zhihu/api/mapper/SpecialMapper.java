package wuhao.zhihu.api.mapper;

import wuhao.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author PC
 */
public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit , int offset);

}
