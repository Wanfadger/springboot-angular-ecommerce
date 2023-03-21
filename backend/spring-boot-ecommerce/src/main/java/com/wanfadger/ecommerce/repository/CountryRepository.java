package com.wanfadger.ecommerce.repository;

import com.wanfadger.ecommerce.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country , Long> {

    Optional<Country> findCountryByCodeIgnoreCase(String code);
}
