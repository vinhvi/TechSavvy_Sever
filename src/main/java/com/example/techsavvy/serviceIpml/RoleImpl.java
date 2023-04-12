package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Role;
import com.example.techsavvy.repository.RoleRepository;
import com.example.techsavvy.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getOneRole(Role role) {
        return null;
    }
}
