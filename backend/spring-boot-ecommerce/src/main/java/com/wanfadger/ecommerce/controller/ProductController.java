package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.ProductDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.Product;
import com.wanfadger.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseDto<List<ProductDto>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseDto<ProductDto> getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }
}
