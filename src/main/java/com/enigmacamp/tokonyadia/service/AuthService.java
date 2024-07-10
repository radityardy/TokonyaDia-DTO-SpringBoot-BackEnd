package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.model.dto.request.AuthRequest;
import com.enigmacamp.tokonyadia.model.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.model.dto.response.LoginResponse;
import com.enigmacamp.tokonyadia.model.dto.response.RegisterResponse;

import java.util.Optional;

public interface AuthService {
    RegisterResponse registerCustomer(AuthRequest<CustomerRequest> authRequest);
    LoginResponse loginCustomer(AuthRequest<String> authRequest);
}
