package wuhao.springboot.redis.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author PC
 */
public class CommonUtils {

    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}
