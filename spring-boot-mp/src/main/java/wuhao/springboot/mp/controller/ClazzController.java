package wuhao.springboot.mp.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.mp.entity.Clazz;
import wuhao.springboot.mp.service.ClazzService;

/**
 * @author PC
 */
@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {

    private final ClazzService clazzService;
    /**
     * 获取班级和对应⽼师信息
     */
    @GetMapping("/{id}")
    public Clazz getClazzWithTeacher(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }
}