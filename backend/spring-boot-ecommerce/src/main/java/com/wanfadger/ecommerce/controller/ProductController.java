package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ProductDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.Product;
import com.wanfadger.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public PageableResponseDto<List<ProductDto>> search(@RequestParam Map<String , String> queryParams) {
        return productService.getAll(queryParams);
    }


    @GetMapping("/{id}")
    public ResponseDto<ProductDto> getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }
}
