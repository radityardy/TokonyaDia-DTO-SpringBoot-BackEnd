package com.enigmacamp.tokonyadia.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private String id;
    private CustomerResponse customer;
    private Date date;
    private List<TransactionDetailResponse> transactionDetails;
    private Long totalPayment;
}
