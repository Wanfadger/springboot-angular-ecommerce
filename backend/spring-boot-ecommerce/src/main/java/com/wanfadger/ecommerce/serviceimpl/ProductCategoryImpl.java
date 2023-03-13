package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.ProductCategoryDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.ProductCategory;
import com.wanfadger.ecommerce.exceptions.NotFoundException;
import com.wanfadger.ecommerce.repository.ProductCategoryRepository;
import com.wanfadger.ecommerce.repository.ProductRepository;
import com.wanfadger.ecommerce.service.ProductCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductCategoryImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    public ProductCategoryImpl(ProductCategoryRepository productCategoryRepository,
                               ProductRepository productRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ResponseDto<List<ProductCategoryDto>> getAll() {
        return new ResponseDto<>(productCategoryRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseDto<ProductCategoryDto> getOne(Long id) {
        Optional<ProductCategory> optional = productCategoryRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Product Category not found");
        }
        return new ResponseDto<>(this.convertToDto(optional.get()));
    }

    private ProductCategoryDto convertToDto(ProductCategory productCategory){
        return ProductCategoryDto.builder()
                .categoryName(productCategory.getCategoryName())
                .id(productCategory.getId())
                .build();
    }

}
