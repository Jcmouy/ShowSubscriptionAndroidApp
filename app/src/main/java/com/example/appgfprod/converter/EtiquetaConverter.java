package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Etiqueta;
import com.example.appgfprod.dto.EtiquetaDto;

public class EtiquetaConverter extends AbstractEntityConverter<Etiqueta, EtiquetaDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
