package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.ShippingCompany;
import com.example.techsavvy.repository.ShippingCompanyRepository;
import com.example.techsavvy.service.ShippingCompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return getOne(shippingCompanyRepository.findById(id));
    }

    @Override
    public ShippingCompany getByEmailOrPhone(String value) {
        ShippingCompany shippingCompany = shippingCompanyRepository.findByEmail(value);
        if (shippingCompany == null) {
            shippingCompany = shippingCompanyRepository.findByPhone(value);
            if (shippingCompany == null) {
                throw new RuntimeException("Không tìm thấy đơn vị vận chuyển với " + value);
            }
        }
        return getOne(shippingCompany);
    }

    @Override
    public ShippingCompany update(ShippingCompany shippingCompany) {
        return null;
    }

    @Override
    public ShippingCompany getOne(ShippingCompany shippingCompany) {
        ShippingCompany shippingCompany1 = new ShippingCompany();
        shippingCompany1.setId(shippingCompany.getId());
        shippingCompany1.setName(shippingCompany.getName());
        shippingCompany1.setPhone(shippingCompany.getPhone());
        shippingCompany1.setEmail(shippingCompany.getEmail());
        shippingCompany1.setAddress(shippingCompany.getAddress());
        return shippingCompany1;
    }
}
