package com.example.appgfprod.repository;

import com.example.appgfprod.dto.TipoDeObraDto;

import java.util.List;

public interface TipoDeObraService {

    List<TipoDeObraDto> getAll();

    TipoDeObraDto getTipoDeObraById(int id);

    void insertOrUpdateTipoDeObra(TipoDeObraDto tipoDeObra);

    void deleteAllTipoDeObra();
}
