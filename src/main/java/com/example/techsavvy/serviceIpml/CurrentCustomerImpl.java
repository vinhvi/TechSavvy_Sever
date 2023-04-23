package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.CurrentCustomer;
import com.example.techsavvy.repository.CurrentCustomerRepository;
import com.example.techsavvy.service.CurrentCustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CurrentCustomerImpl implements CurrentCustomerService {

    private final CurrentCustomerRepository currentCustomerRepository;

    @Override
    public CurrentCustomer create(CurrentCustomer currentCustomer) {
        return currentCustomerRepository.save(currentCustomer);
    }

    @Override
    public List<CurrentCustomer> getAll() {
        List<CurrentCustomer> currentCustomers = currentCustomerRepository.findAll();
        List<CurrentCustomer> currentCustomerList = new ArrayList<>();
        CurrentCustomer currentCustomer = new CurrentCustomer();
        for (CurrentCustomer currentCustomer1 : currentCustomers) {
            currentCustomer = getOne(currentCustomer1);
            currentCustomerList.add(currentCustomer);
        }
        return currentCustomerList;
    }

    @Override
    public CurrentCustomer getOne(CurrentCustomer currentCustomer) {
        CurrentCustomer currentCustomer1 = new CurrentCustomer();
        currentCustomer1.setId(currentCustomer.getId());
        currentCustomer1.setEmail(currentCustomer.getEmail());
        currentCustomer1.setAddress(currentCustomer.getAddress());
        currentCustomer1.setSex(currentCustomer.getSex());
        currentCustomer1.setFirstName(currentCustomer.getFirstName());
        currentCustomer1.setLastName(currentCustomer.getLastName());
        currentCustomer1.setPhone(currentCustomer.getPhone());
        return currentCustomer1;
    }


    @Override
    public CurrentCustomer getByEmail(String email) {
        CurrentCustomer currentCustomer1 = currentCustomerRepository.findByEmail(email);
        return getOne(currentCustomer1);
    }

    @Override
    public CurrentCustomer getByPhone(String phone) {
        CurrentCustomer currentCustomer1 = currentCustomerRepository.findByPhone(phone);
        return getOne(currentCustomer1);
    }
}
