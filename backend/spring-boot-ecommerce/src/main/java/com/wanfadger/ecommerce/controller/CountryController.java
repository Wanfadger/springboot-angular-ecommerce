package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.CountryDto;
import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin
public class CountryController {


    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseDto<List<CountryDto>> getAll(){
        return this.countryService.getAll();
    }

    @GetMapping("/search")
    public PageableResponseDto<List<CountryDto>> search(@RequestParam Map<String , String> queryParams){
        return this.countryService.getAll(queryParams);
    }
    @GetMapping("/searchOne")
    public ResponseDto<CountryDto> searchOne(@RequestParam Map<String , String> queryParams){
        return this.countryService.getOne(queryParams);
    }

}

