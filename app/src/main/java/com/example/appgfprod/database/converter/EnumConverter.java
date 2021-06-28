package com.example.appgfprod.database.converter;

import com.example.appgfprod.dto.EnumMetodoPago;
import com.example.appgfprod.dto.EnumState;
import com.example.appgfprod.dto.EnumTipoDeObra;

import androidx.room.TypeConverter;

public class EnumConverter {
    @TypeConverter
    public static EnumState toEnumState(String enumValue) {
        return enumValue == null ? null : EnumState.valueOf(enumValue);
    }

    @TypeConverter
    public static String toString(EnumState state) {
        return state == null ? null : state.name();
    }

    @TypeConverter
    public static EnumMetodoPago toEnumMetodoPago(String enumValue) {
        return enumValue == null ? null : EnumMetodoPago.valueOf(enumValue);
    }

    @TypeConverter
    public static String toString(EnumMetodoPago metodoPago) {
        return metodoPago == null ? null : metodoPago.name();
    }

    @TypeConverter
    public static EnumTipoDeObra toEnumTipoDeObra(String enumValue) {
        return enumValue == null ? null : EnumTipoDeObra.valueOf(enumValue);
    }

    @TypeConverter
    public static String toString(EnumTipoDeObra tipoObra) {
        return tipoObra == null ? null : tipoObra.name();
    }
}
