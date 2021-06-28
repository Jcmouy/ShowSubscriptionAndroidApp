package com.example.appgfprod.converter;

import com.example.appgfprod.database.entity.Usuario;
import com.example.appgfprod.dto.UsuarioDto;

public class UsuarioConverter extends AbstractEntityConverter<Usuario, UsuarioDto> {

	@Override
	protected boolean isAmbiguousSupported() {
		return true;
	}

}
