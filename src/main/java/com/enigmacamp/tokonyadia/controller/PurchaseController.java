package com.enigmacamp.tokonyadia.controller;

import com.enigmacamp.tokonyadia.constant.APIUrl;
import com.enigmacamp.tokonyadia.model.dto.request.TransactionRequest;
import com.enigmacamp.tokonyadia.model.dto.response.TransactionResponse;
import com.enigmacamp.tokonyadia.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.TRANSACTION_API)
public class PurchaseController {

    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponse savePurchase(@RequestBody TransactionRequest request){

        return transactionService.create(request);

    }
}
