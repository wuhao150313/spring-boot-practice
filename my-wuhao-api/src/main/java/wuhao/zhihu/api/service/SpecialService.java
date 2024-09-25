package wuhao.zhihu.api.service;

import wuhao.zhihu.api.entity.Special;

import java.util.List;


/**
 * @author PC
 */
public interface SpecialService {
    List<Special> getAll();

    List<Special> getByPage(int limit, int offset);
}
