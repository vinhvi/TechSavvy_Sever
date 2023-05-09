package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Discount;
import com.example.techsavvy.entity.Options;
import com.example.techsavvy.entity.Product;
import com.example.techsavvy.repository.OptionsRepository;
import com.example.techsavvy.service.OptionsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OptionsImpl implements OptionsService {

    private final OptionsRepository optionsRepository;

    @Override
    public Options save(Options options) {
        return optionsRepository.save(options);
    }

    @Override
    public Options getById(int id) {
        return optionsRepository.findOptionsById(id);
    }


    @Override
    public List<Options> getOptionsByProduct(String productId) {
        return optionsRepository.findOptionsByProductId(productId);
    }

    @Override
    public Options updateOptions(Options options1) {
        Options options = optionsRepository.findOptionsById(options1.getId());
        if (options != null) {
            options.setCount(options1.getCount());
            options.setColor(options1.getColor());
            options.setNameOptions(options1.getNameOptions());
            options.setPrice(options.getPrice());
            options.setPriceImport(options.getPriceImport());
            optionsRepository.save(options);
            return options;
        }
        return null;
    }

    @Override
    public List<Options> getListOptionsByDiscountId(String id) {
        List<Options> optionsList = optionsRepository.findAll();
        List<Options> newOptions = new ArrayList<>();
        int dem = 0;
        for (Options options : optionsList) {
            Set<Discount> discountSet = options.getDiscounts();
            for (Discount discount : discountSet) {
                if (discount.getId().equals(id)) {
                    newOptions.add(options);
                }
            }
        }
        return newOptions;
    }


}
