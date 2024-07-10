package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.model.dto.request.AuthRequest;
import com.enigmacamp.tokonyadia.model.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.model.dto.response.LoginResponse;
import com.enigmacamp.tokonyadia.model.dto.response.RegisterResponse;
import com.enigmacamp.tokonyadia.model.entity.Customer;
import com.enigmacamp.tokonyadia.model.entity.Role;
import com.enigmacamp.tokonyadia.model.entity.User;
import com.enigmacamp.tokonyadia.repository.UserRepository;
import com.enigmacamp.tokonyadia.service.AuthService;
import com.enigmacamp.tokonyadia.service.CustomerService;
import com.enigmacamp.tokonyadia.service.RoleService;
import com.enigmacamp.tokonyadia.service.UserService;
import com.enigmacamp.tokonyadia.utils.exeptions.ResourceNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    private final CustomerService customerService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public RegisterResponse registerCustomer(AuthRequest<CustomerRequest> request) {
        Role role = roleService.getOrSave(Role.ERole.CUSTOMER);
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        User user = User.builder()
                .username(request.getUsername().toLowerCase())
                .password(request.getPassword())
                .roles(roles)
                .build();
        userRepository.save(user);


        customerService.createCustomer(request.getData().orElseThrow(
                () -> new ResourceNotFoundExeption("Customer data is required")
        ));

        return RegisterResponse.builder()
                .username(user.getUsername())
                .role(role.getName())
                .build();
    }

    @Override
    public LoginResponse loginCustomer(AuthRequest<String> authRequest) {
        return LoginResponse.builder().build();
    }
}
