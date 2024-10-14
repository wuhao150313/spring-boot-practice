package wuhao.springboot.database.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.database.common.ResponseResult;
import wuhao.springboot.database.mapper.SpecialMapper;

/**
 * @author PC
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/zhihu")
public class SpecialController {
    private final SpecialMapper specialMapper;

    @GetMapping("/specials")
    public ResponseResult getSpecials() {
        return ResponseResult.builder()
                .code(200)
                .msg("请求成功")
                .data(specialMapper.findAll())
                .build();
    }


}
