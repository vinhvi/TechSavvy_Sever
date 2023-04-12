package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findRoleById(int id);

    Role findRoleByName(String name);
}
