package wuhao.springboot.redis.controller;


import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wuhao.springboot.redis.cache.TokenStoreCache;

import wuhao.springboot.redis.enums.ErrorCode;
import wuhao.springboot.redis.exception.ServerException;
import wuhao.springboot.redis.result.Result;
import wuhao.springboot.redis.service.UserService;

import wuhao.springboot.redis.utils.JwtUtil;
import wuhao.springboot.redis.vo.UserInfoVO;
import wuhao.springboot.redis.vo.UserLoginVO;

/**
 * @author PC
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "手机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone,
                                            @RequestParam("code") String code)
    {
        return Result.ok(userService.loginByPhone(phone, code));
    }

    @GetMapping("info")
    @Operation(summary = "查询用户信息")
    public Result<UserInfoVO> userInfo(){
        HttpServletRequest request=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String accessToken= JwtUtil.getAccessToken(request);

        if(StringUtils.isBlank(accessToken)){
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        if(!JwtUtil.validate(accessToken)){
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        UserLoginVO user=tokenStoreCache.getUser(accessToken);

        if(ObjectUtils.isEmpty(user)){
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }

        boolean enabledFlag= userService.checkUserEnabled(user.getPkId());
        if(!enabledFlag){
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }

        return Result.ok(userService.userInfo(user.getPkId()));
    }
    }
