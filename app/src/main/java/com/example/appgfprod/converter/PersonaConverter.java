package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Persona;
import com.example.appgfprod.dto.PersonaDto;

public class PersonaConverter extends AbstractEntityConverter<Persona, PersonaDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
