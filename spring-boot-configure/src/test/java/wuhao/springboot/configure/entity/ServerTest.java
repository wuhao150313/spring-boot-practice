package wuhao.springboot.configure.entity;

import static org.junit.jupiter.api.Assertions.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Server.class)
class ServerTest {
    @Resource
    private Server server;

    @Test
    void testServer() {
        System.out.println(server);
    }
}