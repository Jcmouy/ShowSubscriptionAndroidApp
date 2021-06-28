package com.example.appgfprod.view.model;

import android.content.Context;

import com.example.appgfprod.database.AppDatabase;
import com.example.appgfprod.repository.CuentaService;
import com.example.appgfprod.repository.CuentaServiceImpl;
import com.example.appgfprod.repository.MensajeService;
import com.example.appgfprod.repository.MensajeServiceImpl;
import com.example.appgfprod.repository.ObraService;
import com.example.appgfprod.repository.ObraServiceImpl;
import com.example.appgfprod.repository.PaisService;
import com.example.appgfprod.repository.PaisServiceImpl;
import com.example.appgfprod.repository.PersonaService;
import com.example.appgfprod.repository.PersonaServiceImpl;
import com.example.appgfprod.repository.TipoDeObraService;
import com.example.appgfprod.repository.TipoDeObraServiceImpl;
import com.example.appgfprod.repository.UsuarioService;
import com.example.appgfprod.repository.UsuarioServiceImpl;

public class Injection {
    public static ObraService provideObraService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new ObraServiceImpl(database.obraDao());
    }

    public static MensajeService provideMensajeService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new MensajeServiceImpl(database.mensajeDao());
    }

    public static PersonaService providePersonaService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new PersonaServiceImpl(database.personaDao());
    }

    public static UsuarioService provideUsuarioService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new UsuarioServiceImpl(database.usuarioDao());
    }

    public static TipoDeObraService provideTipoDeObraService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new TipoDeObraServiceImpl(database.tipoDeObraDao());
    }

    public static PaisService providePaisService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new PaisServiceImpl(database.paisDao());
    }

    public static CuentaService provideCuentaService(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new CuentaServiceImpl(database.cuentaDao());
    }
}
