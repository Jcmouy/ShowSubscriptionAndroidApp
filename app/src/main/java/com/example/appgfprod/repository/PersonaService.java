package com.example.appgfprod.repository;

import com.example.appgfprod.dto.PersonaDto;

import java.util.List;

public interface PersonaService {

    List<PersonaDto> getAll();

    PersonaDto getPersonaById(int id);

    int getLastInsertedIdPersona();

    void insertOrUpdatePersona(PersonaDto persona);

    void deleteAllPersona();
}
