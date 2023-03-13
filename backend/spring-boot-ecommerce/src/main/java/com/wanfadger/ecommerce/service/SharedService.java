package com.wanfadger.ecommerce.service;

import java.util.List;

public interface SharedService<T, R> {
    List<R> getAll();
    R getOne(Long id);
}
