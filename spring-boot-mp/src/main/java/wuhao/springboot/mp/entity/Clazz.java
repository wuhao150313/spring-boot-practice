package wuhao.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PC
 */
@Data
public class Clazz{
    private Long id;
    private String name;
    private Long teacherId;
    // ⽤于⼀对⼀映射
    @TableField(exist = false)
    private Teacher teacher;

}

