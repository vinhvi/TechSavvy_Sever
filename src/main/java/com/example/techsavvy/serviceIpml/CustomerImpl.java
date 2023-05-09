package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Customer;
import com.example.techsavvy.repository.CustomerRepository;
import com.example.techsavvy.service.AccountService;
import com.example.techsavvy.service.AddressService;
import com.example.techsavvy.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    private final AccountService accountService;

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setAddress(addressService.save(customer.getAddress()));
        if (customer.getAccount() != null) {
            customer.setAccount(accountService.register(customer.getAccount()));
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(String id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer getByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public String randomId() {
        Random random = new Random();
        String id = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            id = "KH" + String.format("%04d", number);
            if (customerRepository.findCustomerById(id) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return id;
    }
}
