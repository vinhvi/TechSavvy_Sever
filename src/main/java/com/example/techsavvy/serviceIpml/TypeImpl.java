package com.example.techsavvy.serviceIpml;

import com.example.techsavvy.entity.Product;
import com.example.techsavvy.entity.Type;
import com.example.techsavvy.repository.TypeRepository;
import com.example.techsavvy.service.ProductService;
import com.example.techsavvy.service.TypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TypeImpl implements TypeService {


    private final TypeRepository typeRepository;


    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(int id) {
        return typeRepository.findTypeById(id);
    }

    @Override
    public Type getByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(int id) {
        Type type = getTypeById(id);
        type.setStatus(false);
        typeRepository.save(type);
    }

    @Override
    public Type getOneType(int id) {
        return typeRepository.findTypeById(id);
    }


    @Override
    public Type formatType(Type type) {
        Type type1 = new Type();
        type1.setId(type.getId());
        type1.setName(type.getName());
        type1.setStatus(type.isStatus());
        return type1;
    }
}
