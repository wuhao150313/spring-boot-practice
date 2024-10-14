package wuhao.springboot.mp.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wuhao.springboot.mp.entity.Clazz;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class ClazzServiceTest {

    @Resource
    private ClazzService clazzService;

    @Test
    void getClazzWithTeacher() {
        Clazz clazzWithTeacher = clazzService.getClazzById(1L);
        log.info(clazzWithTeacher.toString());
    }
}