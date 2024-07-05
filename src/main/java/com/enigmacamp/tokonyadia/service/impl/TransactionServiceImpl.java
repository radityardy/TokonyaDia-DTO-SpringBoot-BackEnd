package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.dto.request.TransactionRequest;
import com.enigmacamp.tokonyadia.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.dto.response.TransactionResponse;
import com.enigmacamp.tokonyadia.entity.Customer;
import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.entity.Transaction;
import com.enigmacamp.tokonyadia.entity.TransactionDetail;
import com.enigmacamp.tokonyadia.repository.TransactionDetailRepository;
import com.enigmacamp.tokonyadia.repository.TransactionRepository;
import com.enigmacamp.tokonyadia.service.CustomerService;
import com.enigmacamp.tokonyadia.service.ProductService;
import com.enigmacamp.tokonyadia.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDetailRepository repo;
    private final CustomerService customerService;
    private final ProductService productService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TransactionResponse create(TransactionRequest transactionRequest) {
        Customer customer = customerService.getById(transactionRequest.getCustomerId());
        Transaction transaction = Transaction.builder()
                .customer(customer)
                .build();
        Long totalPayment;
        List<TransactionDetail> transactionDetails = transactionRequest.getTransactionDetails().stream().map(detailRequest -> {
            Product product = productService.getProductById(detailRequest.getProductId());
            if (product.getStock() - detailRequest.getQty() < 0) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Stock tidak mencukupi");
            }
            product.setStock(product.getStock() - detailRequest.getQty());
//            totalPayment += product.getPrice();
            TransactionDetail trxDetail = TransactionDetail.builder()
                   .product(product)
                   .qty(detailRequest.getQty())
                    .productPrice(product.getPrice())
                   .build();
            repo.saveAndFlush(trxDetail);
            return trxDetail;
        }).toList();
        return null;
    }
}
