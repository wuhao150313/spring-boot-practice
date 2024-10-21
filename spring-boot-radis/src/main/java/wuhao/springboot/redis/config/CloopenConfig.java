package wuhao.springboot.redis.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author PC
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wuhao.sms.ccp")
public class CloopenConfig {
    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;


}
