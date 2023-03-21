package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.CountryDto;
import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ProductCategoryDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.entity.Country;
import com.wanfadger.ecommerce.exceptions.MissingDataException;
import com.wanfadger.ecommerce.exceptions.NotFoundException;
import com.wanfadger.ecommerce.repository.CountryRepository;
import com.wanfadger.ecommerce.service.CountryService;
import com.wanfadger.ecommerce.service.ProductCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public ResponseDto<List<CountryDto>> getAll() {
        try {
            return new ResponseDto<>(this.countryRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public PageableResponseDto<List<CountryDto>> getAll(Map<String, String> queryParams) {
        try {
            String countyCode = queryParams.get("countyCode");
            if (countyCode.isEmpty()){
                throw new MissingDataException("Missing country code");
            }

            //            countryRepository.findCountryByCodeIgnoreCase(countyCode , )


   return null;
        }catch (Exception e){
            throw e;
        }

    }

    private CountryDto convertToDto(Country country){
        return CountryDto.builder()
                .id(country.getId())
                .code(country.getCode())
                .name(country.getName())
                .build();
    }

    @Override
    public ResponseDto<CountryDto> getOne(Long id) {
        try {
            Optional<Country> optional = this.countryRepository.findById(id);
            if (optional.isEmpty()) {
                throw new NotFoundException("Country not found");
            }
            return new ResponseDto<>(this.convertToDto(optional.get()));
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public ResponseDto<CountryDto> getOne(Map<String, String> queryParams) {
        try {
            String countyCode = queryParams.get("countryCode");
            if (countyCode == null || countyCode.isEmpty()){
                throw new MissingDataException("Missing country code");
            }

            Optional<Country> optional = this.countryRepository.findCountryByCodeIgnoreCase(countyCode);
            if (optional.isEmpty()) {
                throw new NotFoundException("Country With Code "+countyCode+" not found");
            }
            return new ResponseDto<>(this.convertToDto(optional.get()));
        }catch (Exception e){
            throw e;
        }
    }
}
