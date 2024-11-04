package wuhao.springboot.middle.mapper;

import org.apache.ibatis.annotations.Mapper;
import wuhao.springboot.middle.entity.User;

/**
 * @author PC
 */
@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
}