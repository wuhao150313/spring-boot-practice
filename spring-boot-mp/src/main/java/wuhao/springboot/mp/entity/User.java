package wuhao.springboot.mp.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author PC
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;

}
