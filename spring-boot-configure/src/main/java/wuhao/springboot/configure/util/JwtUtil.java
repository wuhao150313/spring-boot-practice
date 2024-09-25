package wuhao.springboot.configure.util;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import wuhao.springboot.configure.config.JwtConfig;

import java.util.Date;
import java.util.Map;

/**
 * @author PC
 */
@Component
public class JwtUtil {

    @Resource
    private JwtConfig jwtConfig;

    public String generateToken(Map<String, Object> claims) {
        claims.put("exp", new Date(System.currentTimeMillis() + jwtConfig.getExpiration()));
        return JWTUtil.createToken(claims, jwtConfig.getSecret().getBytes());
    }

    public boolean validateToken(String token){
        return JWTUtil.verify(token, jwtConfig.getSecret().getBytes());
    }

    }

