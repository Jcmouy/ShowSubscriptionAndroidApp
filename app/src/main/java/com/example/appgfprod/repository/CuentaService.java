package com.example.appgfprod.repository;

import com.example.appgfprod.dto.CuentaDto;

import java.util.List;

public interface CuentaService {

    List<CuentaDto> getAll();

    CuentaDto getCuentaById(int id);

    int getLastInsertedIdCuenta();

    void insertOrUpdateCuenta(CuentaDto cuenta);

    void deleteAllCuenta();

}
