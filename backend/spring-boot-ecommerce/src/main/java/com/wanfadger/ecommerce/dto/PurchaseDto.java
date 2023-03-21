package com.wanfadger.ecommerce.dto;

import com.wanfadger.ecommerce.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems = new HashSet<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Customer{
        private String firstName;
        private String lastName;
        private String email;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ShippingAddress{
        private String street;
        private String city;
        private String state;
        private String county;
        private String zipCode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Address{
        private String street;
        private String city;
        private String state;
        private String country;
        private String zipCode;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Order{
        private BigDecimal totalPrice;
        private int totalQuantity;
        private String status;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class OrderItems{
       private String imageUrl;
       private int quantity;
       private BigDecimal unitPrice;
        private long productId;
    }


}
