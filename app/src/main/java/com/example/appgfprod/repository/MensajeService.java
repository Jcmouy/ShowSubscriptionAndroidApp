package com.example.appgfprod.repository;

import com.example.appgfprod.dto.MensajeDto;

import java.util.List;

public interface MensajeService {

    List<MensajeDto> getAll();

    List<MensajeDto> getAllMensajeByObra(String nombre);

    MensajeDto getMensajeById(int id);

    int getLastInsertedIdMensaje();

    void insertOrUpdateMensaje(MensajeDto mensaje);

    void deleteAllMensaje();
}
