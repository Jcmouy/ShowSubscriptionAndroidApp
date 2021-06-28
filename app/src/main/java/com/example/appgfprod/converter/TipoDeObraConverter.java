package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.TipoDeObra;
import com.example.appgfprod.dto.TipoDeObraDto;

public class TipoDeObraConverter extends AbstractEntityConverter<TipoDeObra, TipoDeObraDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
