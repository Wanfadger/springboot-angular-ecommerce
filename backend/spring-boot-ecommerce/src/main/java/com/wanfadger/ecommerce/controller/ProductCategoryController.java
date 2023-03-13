package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.ProductCategoryDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.ProductCategory;
import com.wanfadger.ecommerce.service.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/productCategory")
@CrossOrigin
public class ProductCategoryController  {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping()
    public ResponseDto<List<ProductCategoryDto>> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("/{id}")

    public ResponseDto<ProductCategoryDto> getOne(@PathVariable Long id) {
        return productCategoryService.getOne(id);
    }
}
