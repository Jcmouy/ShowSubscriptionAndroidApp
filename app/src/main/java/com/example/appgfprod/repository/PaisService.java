package com.example.appgfprod.repository;

import com.example.appgfprod.dto.PaisDto;

import java.util.List;

public interface PaisService {

    List<PaisDto> getAll();

    PaisDto getPaisById(int id);

    void insertOrUpdatePais(PaisDto pais);

    int getLastInsertedIdPais();

    void deleteAllPais();
}
