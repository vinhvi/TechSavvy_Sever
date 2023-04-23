package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Member;
import com.example.techsavvy.entity.Role;
import com.example.techsavvy.repository.MemberRepository;
import com.example.techsavvy.repository.RoleRepository;
import com.example.techsavvy.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberImpl implements MemberService {
    private final MemberRepository memberRepository;
    @Override
    public Member addCustomer(Member member) {
        return  memberRepository.save(member);
    }

    @Override
    public Member getById(String id) {
        return memberRepository.findCustomerById(id);
    }

    @Override
    public List<Member> getAll() {
        return null;
    }

    @Override
    public Member getOne(Member member) {
        return null;
    }
}
