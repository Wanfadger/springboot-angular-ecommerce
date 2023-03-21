package com.wanfadger.ecommerce.repository;

import com.wanfadger.ecommerce.entity.Country;
import com.wanfadger.ecommerce.entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

    Page<State> findAllByCountry_Id(long countryId , Pageable pageable);
    Page<State> findAllByCountry_CodeIgnoreCase(String code , Pageable pageable);

}
