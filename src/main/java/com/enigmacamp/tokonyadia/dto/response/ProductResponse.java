package com.enigmacamp.tokonyadia.dto.response;


import com.enigmacamp.tokonyadia.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse{
    private String id;
    private String name;
    private Long price;
    private Integer stock;
}
