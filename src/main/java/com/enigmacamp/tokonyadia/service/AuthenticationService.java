package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.model.dto.request.AuthRequestDTO;
import com.enigmacamp.tokonyadia.model.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.model.dto.response.LoginResponse;
import com.enigmacamp.tokonyadia.model.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse registerCustomer(AuthRequestDTO<CustomerRequest> authRequestDTO);
    LoginResponse login(AuthRequestDTO<String> request);
}
