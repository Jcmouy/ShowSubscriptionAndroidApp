package com.example.appgfprod.repository;

import com.example.appgfprod.dto.ObraDto;

import java.util.List;

public interface ObraService {

    List<ObraDto> getAll();

    ObraDto getObraById(int id);

    ObraDto getObraByNombre(String nombre);

    void insertOrUpdateObra(ObraDto obra);

    void deleteAllObra();
}
