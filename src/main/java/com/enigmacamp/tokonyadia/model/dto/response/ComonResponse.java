package com.enigmacamp.tokonyadia.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComonResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
}
