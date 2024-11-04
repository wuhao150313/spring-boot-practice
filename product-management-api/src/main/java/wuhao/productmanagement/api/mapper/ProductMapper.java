package wuhao.productmanagement.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wuhao.productmanagement.api.entity.Product;

/**
 * @author PC
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
