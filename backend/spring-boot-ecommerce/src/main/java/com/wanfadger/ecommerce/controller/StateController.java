package com.wanfadger.ecommerce.controller;

import com.wanfadger.ecommerce.dto.PageableResponseDto;
import com.wanfadger.ecommerce.dto.ResponseDto;
import com.wanfadger.ecommerce.dto.StateDto;
import com.wanfadger.ecommerce.service.StateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/states")
@CrossOrigin
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }


    @GetMapping
    public ResponseDto<List<StateDto>> getAll(){
        return this.stateService.getAll();
    }

    @GetMapping("/search")
    public PageableResponseDto<List<StateDto>> searchAll(@RequestParam Map<String , String> queryMap){
        return this.stateService.getAll(queryMap);
    }
}
