package com.wanfadger.ecommerce.dto;

import com.wanfadger.ecommerce.entity.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private long id;
    private String code;
    private String name;

   // private Set<StateDto> states = new HashSet<>();
}
