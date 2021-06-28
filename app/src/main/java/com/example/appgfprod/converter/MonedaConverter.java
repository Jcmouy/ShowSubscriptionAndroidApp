package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Moneda;
import com.example.appgfprod.dto.MonedaDto;

public class MonedaConverter extends AbstractEntityConverter<Moneda, MonedaDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
