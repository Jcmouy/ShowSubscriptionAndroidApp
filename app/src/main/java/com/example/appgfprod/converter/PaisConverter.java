package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Pais;
import com.example.appgfprod.dto.PaisDto;

public class PaisConverter extends AbstractEntityConverter<Pais, PaisDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
