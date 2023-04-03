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
    public static class Customer{
        private String firstName;
        private String lastName;
        private String email;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address{
        private String street;
        private String city;
        private State state;
        private Country country;
        private String zipCode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Country{
        private long id;
        private String code;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class State{
        private long id;
        private String name;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Order{
        private BigDecimal totalPrice;
        private int totalQuantity;
        private String status;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItems{
       private String imageUrl;
       private int quantity;
       private BigDecimal unitPrice;
        private long productId;
    }


}
