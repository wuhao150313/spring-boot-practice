package wuhao.springboot.mp.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author PC
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private Long id;
    private String name;
}
