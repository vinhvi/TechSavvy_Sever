package com.example.techsavvy.service;

import com.example.techsavvy.entity.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> getByEmail(String email);

    Account getById(Integer id);

    Account formatAccount(Account account);

    Account register(Account account);

    String login(Account account);
}
