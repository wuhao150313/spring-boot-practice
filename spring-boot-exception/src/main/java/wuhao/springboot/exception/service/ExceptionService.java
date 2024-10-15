package wuhao.springboot.exception.service;

import org.springframework.stereotype.Service;
import wuhao.springboot.exception.exception.ServerException;

/**
 * @author PC
 */
@Service
public class ExceptionService {

    public void  unAuthorizedError(){
        throw new ServerException("没有登录");
    }

    public void systemError(){
        throw new ServerException("系统异常");
    }
}
