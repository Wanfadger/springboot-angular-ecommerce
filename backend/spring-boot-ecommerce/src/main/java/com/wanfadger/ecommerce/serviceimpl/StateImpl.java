package com.wanfadger.ecommerce.serviceimpl;

import com.wanfadger.ecommerce.dto.CountryDto;
import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.dto.StateDto;
import com.wanfadger.ecommerce.entity.Country;
import com.wanfadger.ecommerce.entity.Product;
import com.wanfadger.ecommerce.entity.State;
import com.wanfadger.ecommerce.exceptions.NotFoundException;
import com.wanfadger.ecommerce.repository.StateRepository;
import com.wanfadger.ecommerce.service.CountryService;
import com.wanfadger.ecommerce.service.StateService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StateImpl implements StateService {

    private final StateRepository stateRepository;

    public StateImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public ResponseDto<List<StateDto>> getAll() {
        return new ResponseDto<>(this.stateRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @Override
    public PageableResponseDto<List<StateDto>> getAll(Map<String, String> queryParams) {
        int size = 50;
        int page = 0;
        if(queryParams != null && queryParams.get("size") != null && !queryParams.get("size").isEmpty()){
            size = Integer.parseInt(queryParams.get("size"));
        }

        if(queryParams != null && queryParams.get("page") != null && !queryParams.get("page").isEmpty()){
            page = Integer.parseInt(queryParams.get("page"));
        }

        //category
//        if(queryParams != null && queryParams.get("country") != null && !queryParams.get("country").isEmpty()){
//            Page<State> statePage = stateRepository.findAllByCountry_Id(Long.valueOf(queryParams.get("country")) , PageRequest.of(page , size));
//            return new PageableResponseDto<>(statePage.getTotalPages(),
//                    statePage.getTotalElements(),
//                    statePage.getContent().stream().map(this::convertToDto).collect(Collectors.toList())
//            );
//        }


        //product name
        if(queryParams != null && queryParams.get("countryCode") != null && !queryParams.get("countryCode").isEmpty()){
            Page<State> statePage = stateRepository.findAllByCountry_CodeIgnoreCase(queryParams.get("countryCode") , PageRequest.of(page , size));
            return new PageableResponseDto<>(statePage.getTotalPages(),
                    statePage.getTotalElements(),
                    statePage.getContent().stream().map(this::convertToDto).collect(Collectors.toList())
            );
        }



        Page<State> productPage = stateRepository.findAll(PageRequest.of(page , size));
        return new PageableResponseDto<>(productPage.getTotalPages(),
                productPage.getTotalElements(),
                productPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList())
        );
    }

    private StateDto convertToDto(State state){
        return StateDto.builder()
                .id(state.getId())
                .name(state.getName())
                .build();
    }

    @Override
    public ResponseDto<StateDto> getOne(Long id) {
        Optional<State> optional = this.stateRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("State not found");
        }
        return new ResponseDto<>(this.convertToDto(optional.get()));
    }

    @Override
    public ResponseDto<StateDto> getOne(Map<String, String> queryParams) {
        return null;
    }
}
