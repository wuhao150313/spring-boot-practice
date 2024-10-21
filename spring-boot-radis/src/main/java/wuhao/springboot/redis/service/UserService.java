package wuhao.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wuhao.springboot.redis.entity.User;
import wuhao.springboot.redis.vo.UserInfoVO;
import wuhao.springboot.redis.vo.UserLoginVO;

/**
 * @author PC
 */
public interface UserService extends IService<User> {


    UserLoginVO loginByPhone(String phone, String code);

    boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}
