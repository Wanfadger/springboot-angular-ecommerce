package com.wanfadger.ecommerce.service;

import com.wanfadger.ecommerce.dto.ResponseDto;

import java.util.List;

public interface SharedService<T, R> {
    ResponseDto<List<R>> getAll();
    ResponseDto<R> getOne(Long id);
}
