package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ProductDto;
import com.wanfadger.ecommerce.dto.PurchaseDto;
import com.wanfadger.ecommerce.dto.PurchaseResponseDto;
import com.wanfadger.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping()
    public PurchaseResponseDto checkout(@RequestBody PurchaseDto dto) {
//        System.out.println("PURCHASING");
//        System.out.println(dto);
        return checkoutService.placeOrder(dto);
    }
}
