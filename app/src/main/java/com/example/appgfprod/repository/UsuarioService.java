package com.example.appgfprod.repository;

import com.example.appgfprod.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> getAll();

    UsuarioDto getUsuarioById(int id);

    int getLastInsertedIdUsuario();

    void insertOrUpdateUsuario(UsuarioDto usuario);

    void deleteAllUsuario();
}
