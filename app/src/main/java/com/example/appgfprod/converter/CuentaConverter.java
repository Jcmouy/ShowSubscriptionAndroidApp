package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Cuenta;
import com.example.appgfprod.dto.CuentaDto;

public class CuentaConverter extends AbstractEntityConverter<Cuenta, CuentaDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
