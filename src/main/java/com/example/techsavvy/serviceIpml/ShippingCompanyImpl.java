package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.ShippingCompany;
import com.example.techsavvy.repository.ShippingCompanyRepository;
import com.example.techsavvy.service.ShippingCompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ShippingCompanyImpl implements ShippingCompanyService {
    private final ShippingCompanyRepository shippingCompanyRepository;

    @Override
    public ShippingCompany add(ShippingCompany shippingCompany) {
        return shippingCompanyRepository.save(shippingCompany);
    }

    @Override
    public ShippingCompany getById(int id) {
        return shippingCompanyRepository.findById(id);
    }

    @Override
    public ShippingCompany getByEmailOrPhone(String value) {
        ShippingCompany shippingCompany = shippingCompanyRepository.findByEmail(value);
        if (shippingCompany == null) {
            shippingCompany = shippingCompanyRepository.findByPhone(value);
        }
        return shippingCompany;
    }

    @Override
    public ShippingCompany update(ShippingCompany shippingCompany) {
        ShippingCompany oldShippingCompany = shippingCompanyRepository.findById(shippingCompany.getId());
        if (oldShippingCompany != null) {
            oldShippingCompany.setAddress(shippingCompany.getAddress());
            oldShippingCompany.setName(shippingCompany.getName());
            oldShippingCompany.setEmail(shippingCompany.getEmail());
            oldShippingCompany.setPhone(shippingCompany.getPhone());
            shippingCompanyRepository.save(oldShippingCompany);
        } else {
            return null;
        }
        return oldShippingCompany;
    }

    @Override
    public List<ShippingCompany> getList() {
        return shippingCompanyRepository.findAll();
    }


}
