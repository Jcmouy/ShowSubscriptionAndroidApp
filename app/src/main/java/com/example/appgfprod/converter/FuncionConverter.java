package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Funcion;
import com.example.appgfprod.dto.FuncionDto;

public class FuncionConverter extends AbstractEntityConverter<Funcion, FuncionDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
