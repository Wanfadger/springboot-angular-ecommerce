package com.wanfadger.ecommerce.service;

import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ResponseDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SharedService<T, R> {
    ResponseDto<List<R>> getAll();
    PageableResponseDto<List<R>> getAll(Map<String , String> queryParams);
    ResponseDto<R> getOne(Long id);
    ResponseDto<R> getOne(Map<String , String> queryParams);
}
