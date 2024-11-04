package wuhao.productmanagement.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wuhao.productmanagement.api.entity.Product;
import wuhao.productmanagement.api.service.ProductService;
import wuhao.productmanagement.api.utils.OssUtil;

import java.util.List;

/**
 * @author PC
 */
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final OssUtil ossUtil;

    // 获取所有商品
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.list();
    }

    // 获取单个商品
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // 创建商品
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    // 更新商品
    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        productDetails.setId(id);
        return productService.updateById(productDetails);
    }

    // 删除商品
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.removeById(id);
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return ossUtil.uploadFile(file);
    }

}