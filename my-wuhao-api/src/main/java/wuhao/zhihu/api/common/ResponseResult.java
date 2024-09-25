package wuhao.zhihu.api.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;
}
