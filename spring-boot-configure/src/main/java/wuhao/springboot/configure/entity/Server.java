package wuhao.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author PC
 */
@Data
@Component
public class Server {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    @Value("${server.context-path}")
    private String path;


}