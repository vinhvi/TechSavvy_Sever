package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Member;
import com.example.techsavvy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(memberService.addCustomer(member));
    }
}
