package com.example.techsavvy.controller;

import com.example.techsavvy.entity.Account;
import com.example.techsavvy.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/manage")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account/getByEmail/{email}")
    public ResponseEntity<Optional<Account>> getById(@PathVariable("email") String email){
        return ResponseEntity.ok().body(accountService.getByEmail(email));
    }
}
