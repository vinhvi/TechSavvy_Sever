package com.example.techsavvy.controller;


import com.example.techsavvy.entity.Account;
import com.example.techsavvy.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerAccount(@RequestBody Account account){
        Account registeredAccount = accountService.register(account);
        if (registeredAccount == null){
            return ResponseEntity.ok().body(false);
        }
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account){

        return ResponseEntity.ok().body(accountService.login(account));
    }
}
