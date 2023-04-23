package com.example.techsavvy.service;


import com.example.techsavvy.entity.Member;

import java.util.List;

public interface MemberService {
    Member addCustomer(Member member);

    Member getById(String id);

    List<Member> getAll();

    Member getOne(Member member);

}
