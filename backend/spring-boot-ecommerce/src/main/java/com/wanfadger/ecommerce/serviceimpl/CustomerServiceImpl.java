package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.CountryDto;
import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.repository.CustomerRepository;
import com.wanfadger.ecommerce.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseDto<List<CountryDto>> getAll() {
        return null;
    }

    @Override
    public PageableResponseDto<List<CountryDto>> getAll(Map<String, String> queryParams) {
        return null;
    }

    @Override
    public ResponseDto<CountryDto> getOne(Long id) {
        return null;
    }

    @Override
    public ResponseDto<CountryDto> getOne(Map<String, String> queryParams) {
        return null;
    }
}
