package com.example.techsavvy.repository;


import com.example.techsavvy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    Member findCustomerById(String id);
}
