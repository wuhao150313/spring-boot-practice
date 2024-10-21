package wuhao.springboot.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -2126582984558319477L;

    private String id;
    private String name;
    private Address address;
}
