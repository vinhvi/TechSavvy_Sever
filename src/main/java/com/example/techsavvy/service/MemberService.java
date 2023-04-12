package com.example.techsavvy.service;


import com.example.techsavvy.entity.Member;

import java.util.List;

public interface MemberService {
    Member addCustomer(Member member);

    Member getCustomerById(int id);

    List<Member> getAll();

    Member getOne(Member member);

}
