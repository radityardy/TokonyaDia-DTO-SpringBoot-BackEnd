package com.enigmacamp.tokonyadia.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    private Long price;
    private Integer stock;
}
