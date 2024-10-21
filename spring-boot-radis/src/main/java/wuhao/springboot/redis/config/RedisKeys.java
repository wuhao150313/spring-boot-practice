package wuhao.springboot.redis.config;




/**
 * @author PC
 */
public class RedisKeys {

    public static String getSmsKey(String phone) {
        return "sms:captcha" + phone;
    }

    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }

    public static String getUserIdKey(Long id){
        return  "sys:userId:" + id;
    }

}
