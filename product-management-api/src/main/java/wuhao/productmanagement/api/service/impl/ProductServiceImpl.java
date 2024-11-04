package wuhao.productmanagement.api.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import wuhao.productmanagement.api.entity.Product;
import wuhao.productmanagement.api.mapper.ProductMapper;
import wuhao.productmanagement.api.service.ProductService;

/**
 * @author PC
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}