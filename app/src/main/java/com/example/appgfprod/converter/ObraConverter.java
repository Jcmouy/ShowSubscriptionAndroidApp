package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Obra;
import com.example.appgfprod.dto.ObraDto;

public class ObraConverter extends AbstractEntityConverter<Obra, ObraDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
