package wuhao.springboot.redis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wuhao.springboot.redis.entity.User;

/**
 * @author PC
 */
public interface UserMapper extends BaseMapper<User> {

    default User getByPhone(String phone) {
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone,phone));
    }
}
