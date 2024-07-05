package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.dto.request.TransactionRequest;
import com.enigmacamp.tokonyadia.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse create(TransactionRequest transactionRequest);
}
