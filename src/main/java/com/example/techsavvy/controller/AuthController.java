package com.example.techsavvy.controller;


import com.example.techsavvy.entity.Account;
import com.example.techsavvy.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        String token = accountService.login(account);
        if (token != null) {
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.badRequest().body("Tài khoản hoặc mật khẩu khôn đúng !!");
        }

    }
}
