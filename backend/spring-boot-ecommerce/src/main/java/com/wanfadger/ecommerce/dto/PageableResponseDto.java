package com.wanfadger.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponseDto<T> {
    int totalPages;
    long totalElements;

    T data;
}
