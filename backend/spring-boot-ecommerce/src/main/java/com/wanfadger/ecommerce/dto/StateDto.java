package com.wanfadger.ecommerce.dto;

import com.wanfadger.ecommerce.entity.State;
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
public class StateDto {
    private long id;
    private String name;

}
