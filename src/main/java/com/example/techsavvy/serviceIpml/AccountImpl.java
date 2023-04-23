package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.config.JwtService;
import com.example.techsavvy.entity.Account;
import com.example.techsavvy.entity.Employee;
import com.example.techsavvy.entity.Member;
import com.example.techsavvy.repository.AccountRepository;
import com.example.techsavvy.service.AccountService;
import com.example.techsavvy.service.EmployeeService;
import com.example.techsavvy.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Override
    public Optional<Account> getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account getById(Integer id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public Account formatAccount(Account account) {
        Account account1 = new Account();
        account1.setId(account.getId());
        account1.setRoles(account.getRoles());
        account1.setEmail(account.getEmail());
        account1.setPassWordAccount(account1.getPassWordAccount());
        return null;
    }

    @Override
    public Account register(Account account) {
        String password = account.getPassWordAccount();
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        String encodedPassword = passwordEncoder.encode(password);
        account.setPassWordAccount(encodedPassword);

        return accountRepository.save(account);
    }


    @Override
    public String login(Account account) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        var user = accountRepository.findByEmail(account.getEmail()).orElseThrow();
        return jwtService.generateToken(user);
    }


}
