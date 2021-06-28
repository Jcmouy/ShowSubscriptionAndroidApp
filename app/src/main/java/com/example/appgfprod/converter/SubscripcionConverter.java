package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Subscripcion;
import com.example.appgfprod.dto.SubscripcionDto;

public class SubscripcionConverter extends AbstractEntityConverter<Subscripcion, SubscripcionDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
