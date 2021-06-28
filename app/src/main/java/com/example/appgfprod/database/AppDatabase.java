package com.example.appgfprod.database;

import android.content.Context;
import android.util.Log;

import com.example.appgfprod.database.converter.DateConverter;
import com.example.appgfprod.database.converter.EnumConverter;
import com.example.appgfprod.database.dao.CuentaDao;
import com.example.appgfprod.database.dao.MensajeDao;
import com.example.appgfprod.database.dao.ObraDao;
import com.example.appgfprod.database.dao.PaisDao;
import com.example.appgfprod.database.dao.PersonaDao;
import com.example.appgfprod.database.dao.TipoDeObraDao;
import com.example.appgfprod.database.dao.UsuarioDao;
import com.example.appgfprod.database.entity.Cuenta;
import com.example.appgfprod.database.entity.Mensaje;
import com.example.appgfprod.database.entity.Obra;
import com.example.appgfprod.database.entity.Pais;
import com.example.appgfprod.database.entity.Persona;
import com.example.appgfprod.database.entity.TipoDeObra;
import com.example.appgfprod.database.entity.Usuario;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Persona.class, Obra.class, TipoDeObra.class,
        Pais.class, Mensaje.class, Usuario.class, Cuenta.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class, EnumConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "appPlataformaDB";
    private static AppDatabase sInstance;

    public abstract PersonaDao personaDao();
    public abstract ObraDao obraDao();
    public abstract MensajeDao mensajeDao();
    public abstract TipoDeObraDao tipoDeObraDao();
    public abstract PaisDao paisDao();
    public abstract UsuarioDao usuarioDao();
    public abstract CuentaDao cuentaDao();

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }
}
