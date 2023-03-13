package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.ProductDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.Product;
import com.wanfadger.ecommerce.exceptions.NotFoundException;
import com.wanfadger.ecommerce.repository.ProductRepository;
import com.wanfadger.ecommerce.service.ProductService;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseDto<List<ProductDto>> getAll() {
        return new ResponseDto<>(productRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseDto<ProductDto> getOne(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Product Category not found");
        }
        return new ResponseDto<>(this.convertToDto(optional.get()));
    }

    private ProductDto convertToDto(Product product){
        ProductDto build = ProductDto.builder()
                .dateCreated(product.getDateCreated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .unitsInStock(product.getUnitsInStock())
                .active(product.isActive())
                .imageUrl(product.getImageUrl())
                .unitPrice(product.getUnitPrice())
                .description(product.getDescription())
                .name(product.getName())
                .sku(product.getSku())
                .id(product.getId())
                .build();

        if(product.getLastUpdated() != null){
            build.setLastUpdated(product.getLastUpdated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }

        return build;
    }
}
