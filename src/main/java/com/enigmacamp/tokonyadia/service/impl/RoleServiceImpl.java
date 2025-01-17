package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.model.entity.Role;
import com.enigmacamp.tokonyadia.repository.RoleRepository;
import com.enigmacamp.tokonyadia.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getOrSave(Role.ERole role) {
        Optional<Role> optionalRole = roleRepository.findByName(role);
        // Kalo ada Role maka dia akan di return
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        // jika tidak ada rolenya maka akan buat role baru
        Role currentRole = Role.builder()
                .name(role)
                .build();

        return roleRepository.saveAndFlush(currentRole);
    }
}
