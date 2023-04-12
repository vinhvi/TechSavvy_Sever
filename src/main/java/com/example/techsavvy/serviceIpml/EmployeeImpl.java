package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Employee;
import com.example.techsavvy.entity.Role;
import com.example.techsavvy.repository.EmployeeRepository;
import com.example.techsavvy.repository.RoleRepository;
import com.example.techsavvy.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        employee.setPassword(encoder.encode(employee.getPassword()));
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
        employee1.setPassword(employee.getPassword());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        Role role = new Role();
        Set<Role> roles = employee1.getRoles();
        Set<Role> roles1 = new HashSet<>();
        Role[] arr = roles.toArray(new Role[0]);
        for (Role value : arr) {
            role.setId(value.getId());
            role.setName(value.getName());
            roles1.add(role);
        }
        employee1.setRoles(roles1);

        return employee1;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        return getOneEmployee(employee);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        Employee employee;
        for (Employee employee1 : employeeList) {
            employee = getOneEmployee(employee1);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public void addRoleToEmployee(String email, String roleName) {
        Employee employee = employeeRepository.findEmployeeByEmail(email);
        Role role = roleRepository.findRoleByName(roleName);
        employee.getRoles().add(role);
    }
}
