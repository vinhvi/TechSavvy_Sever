package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Account;
import com.example.techsavvy.entity.Address;
import com.example.techsavvy.entity.Employee;
import com.example.techsavvy.entity.Role;
import com.example.techsavvy.repository.AddressRepository;
import com.example.techsavvy.repository.EmployeeRepository;
import com.example.techsavvy.repository.RoleRepository;
import com.example.techsavvy.service.AccountService;
import com.example.techsavvy.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AccountService accountService;

    private final AddressRepository addressRepository;

    @Override
    public Employee createEmployee(Employee employee) {

        Account account = accountService.getById(employee.getAccount().getId());
        if (account == null) {
            throw new IllegalArgumentException("Account not null");
        }
        employee.setAccount(account);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getOneEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setId(employee.getId());
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setSex(employee.getSex());
        employee1.setPhone(employee.getPhone());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        Address address = addressRepository.findById(employee.getAddress().getId());
        Account account = employee.getAccount();
        Account account1 = new Account();
        account1.setId(account.getId());
        employee1.setAccount(account1);
        employee1.setAddress(address);
        employee1.setImportDate(employee.getImportDate());
        return employee1;
    }

    @Override
    public Employee getById(String id) {

        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee getByEmail(String email) {
        return getOneEmployee(employeeRepository.findEmployeeByEmail(email));
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employees.add(getOneEmployee(employee));
        }
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String generateId() {
        Random random = new Random();
        String id = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            id = "NV" + String.format("%04d", number);
            if (employeeRepository.findEmployeeById(id) == null) {
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
