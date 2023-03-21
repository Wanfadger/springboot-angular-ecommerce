package com.wanfadger.ecommerce.service;

import com.wanfadger.ecommerce.dto.PurchaseDto;
import com.wanfadger.ecommerce.dto.PurchaseResponseDto;

public interface CheckoutService {

    PurchaseResponseDto placeOrder(PurchaseDto dto);
}
