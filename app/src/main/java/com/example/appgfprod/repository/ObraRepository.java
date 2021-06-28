package com.example.appgfprod.repository;

import com.example.appgfprod.database.entity.Obra;

import java.util.List;

public interface ObraRepository {

    List<Obra> getAll();

    Obra getObraById(int id);

    void insertOrUpdateObra(Obra obra);

    void deleteAllObra();
}
