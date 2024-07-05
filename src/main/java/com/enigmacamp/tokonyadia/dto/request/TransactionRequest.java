package com.enigmacamp.tokonyadia.dto.request;

import com.enigmacamp.tokonyadia.entity.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
    private String customerId;
    private List<TransactionDetailRequest> transactionDetails;
}
