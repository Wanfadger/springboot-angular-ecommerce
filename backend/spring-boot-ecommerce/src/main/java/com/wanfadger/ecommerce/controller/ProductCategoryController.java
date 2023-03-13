package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.ProductCategoryDto;
import com.wanfadger.ecommerce.entity.ProductCategory;
import com.wanfadger.ecommerce.service.ProductCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/productCategory")
public class ProductCategoryController  {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping()
    public List<ProductCategoryDto> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("/{id}")

    public ProductCategoryDto getOne(@PathVariable Long id) {
        return productCategoryService.getOne(id);
    }
}
