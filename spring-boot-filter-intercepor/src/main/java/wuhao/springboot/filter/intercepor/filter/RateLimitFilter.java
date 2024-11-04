package wuhao.springboot.filter.intercepor.filter;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author PC
 */
@Slf4j
public class RateLimitFilter implements Filter {

    private static final int LIMIT = 5;
    private static final int TIME_WINDOW = 60 * 1000;
    //不同IP地址的请求
    private static final  ConcurrentHashMap<String,UserRequest> USER_REQUESTS = new java.util.concurrent.ConcurrentHashMap<>();
    //存储不同IP地址验证码
    private static final  ConcurrentHashMap<String,String> CAPTCHA_STORE = new java.util.concurrent.ConcurrentHashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("RateLimitFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String clientIp = request.getRemoteAddr();
        UserRequest userRequest = USER_REQUESTS.compute(clientIp, (key, value) -> {
            if (value == null || System.currentTimeMillis() - value.timestamp > TIME_WINDOW) {
                return new UserRequest(1, System.currentTimeMillis());
            } else {
                value.count++;
                return value;
            }
        });

        if (userRequest.count > LIMIT) {
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
            String code = lineCaptcha.getCode();
            CAPTCHA_STORE.put(clientIp, code);

            response.setContentType("image/png");
            lineCaptcha.write(response.getOutputStream());
            // 使用已经获取的OutputStream
            return; // 终止过滤器链
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {
        log.info("RateLimitFilter 销毁");
    }

    private static class UserRequest {
        //计数
        int count;
        //最后一次请求时间戳
        long timestamp;

        UserRequest(int count , long timestamp){
            this.count = count;
            this.timestamp = timestamp;
        }
    }



}
