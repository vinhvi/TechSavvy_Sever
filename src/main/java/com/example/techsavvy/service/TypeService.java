package com.example.techsavvy.service;

import com.example.techsavvy.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();

    Type getTypeById(int id);

    Type getByName(String name);

    Type saveType(Type type);

    void deleteType(int id);

    Type getOneType(int id);

    Type formatType(Type type);
}
