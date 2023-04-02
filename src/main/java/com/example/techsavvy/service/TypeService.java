package com.example.techsavvy.service;

import com.example.techsavvy.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();

    Type getTypeById(int id);

    void saveType(Type type);

    void deleteType(int id);

    Type getOneType(Type type);
}
