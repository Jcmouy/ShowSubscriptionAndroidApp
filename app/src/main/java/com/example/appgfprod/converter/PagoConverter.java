package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Pago;
import com.example.appgfprod.dto.PagoDto;

public class PagoConverter extends AbstractEntityConverter<Pago, PagoDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
