package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Contenido;
import com.example.appgfprod.dto.ContenidoDto;

public class ContenidoConverter extends AbstractEntityConverter<Contenido, ContenidoDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
