package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.PurchaseDto;
import com.wanfadger.ecommerce.dto.PurchaseResponseDto;
import com.wanfadger.ecommerce.entity.Address;
import com.wanfadger.ecommerce.entity.Customer;
import com.wanfadger.ecommerce.entity.Order;
import com.wanfadger.ecommerce.entity.OrderItem;
import com.wanfadger.ecommerce.repository.OrderRepository;
import com.wanfadger.ecommerce.service.CheckoutService;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderRepository orderRepository;

    public CheckoutServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public PurchaseResponseDto placeOrder(PurchaseDto dto) {
        // retrieve the order info from dto
        Order order = new Order();
        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        PurchaseDto.Order dtoOrder = dto.getOrder();

        order.setTotalPrice(dtoOrder.getTotalPrice());
        order.setTotalQuantity(dtoOrder.getTotalQuantity());
        order.setStatus(dtoOrder.getStatus());



        // populate order with orderItems
        Set<OrderItem> dtoOrderItems = dto.getOrderItems();
        Set<OrderItem> orderItemSet = dtoOrderItems.stream().map(o -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setQuantity(o.getQuantity());
            orderItem.setImageUrl(o.getImageUrl());
            orderItem.setProductId(o.getProductId());
            orderItem.setUnitPrice(o.getUnitPrice());
            return orderItem;
        }).collect(Collectors.toSet());

        order.setOrderItems(orderItemSet);

        // populate order with billingAddress and shippingAddress
        PurchaseDto.Address dtoShippingAddress = dto.getShippingAddress();
        Address shippingAddress = new Address();
        shippingAddress.setCity(dtoShippingAddress.getCity());
        shippingAddress.setCountry(dtoShippingAddress.getCountry().getName());
        shippingAddress.setStreet(dtoShippingAddress.getStreet());
        shippingAddress.setZipCode(dtoShippingAddress.getZipCode());
        shippingAddress.setState(dtoShippingAddress.getState().getName());
        order.setShippingAddress(shippingAddress);


        PurchaseDto.Address dtoBillingAddress = dto.getBillingAddress();
        Address billingAddress = new Address();
        billingAddress.setCity(dtoBillingAddress.getCity());
        billingAddress.setCountry(dtoBillingAddress.getCountry().getName());
        billingAddress.setStreet(dtoBillingAddress.getStreet());
        billingAddress.setZipCode(dtoBillingAddress.getZipCode());
        billingAddress.setState(dtoBillingAddress.getState().getName());
        order.setBillingAddress(billingAddress);
        order.setBillingAddress(billingAddress);
        // populate customer with order
        PurchaseDto.Customer dtoCustomer = dto.getCustomer();
        Customer customer = new Customer();
        customer.setFirstName(dtoCustomer.getFirstName());
        customer.setLastName(dtoCustomer.getLastName());
        customer.setEmail(dtoCustomer.getEmail());
        order.setCustomer(customer);
        // save to the database

        orderRepository.save(order);
        // return a response
        return new PurchaseResponseDto(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID number (UUID version-4)
        String s = UUID.randomUUID().toString();
        return orderRepository.existsByOrderTrackingNumberIgnoreCase(s) ? generateOrderTrackingNumber() : s;
    }
}
