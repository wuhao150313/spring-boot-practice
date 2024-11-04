package wuhao.springboot.filter.intercepor.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PC
 */
@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        return "test";
    }
}
