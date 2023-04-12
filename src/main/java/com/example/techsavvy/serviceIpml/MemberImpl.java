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
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberImpl implements MemberService {
    private final MemberRepository memberRepository;
    @Override
    public Member addCustomer(Member member) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        return  memberRepository.save(member);
    }

    @Override
    public Member getCustomerById(int id) {
        return null;
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
