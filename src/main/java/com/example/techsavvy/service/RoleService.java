package com.example.techsavvy.service;

import com.example.techsavvy.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAll();

    Role getOneRole(Role role);
}
