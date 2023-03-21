package com.wanfadger.ecommerce.repository;

import com.wanfadger.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {

    boolean existsByOrderTrackingNumberIgnoreCase(String uuid);
}
