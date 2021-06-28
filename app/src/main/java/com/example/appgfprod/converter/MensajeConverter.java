package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Mensaje;
import com.example.appgfprod.dto.MensajeDto;

public class MensajeConverter extends AbstractEntityConverter<Mensaje, MensajeDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
