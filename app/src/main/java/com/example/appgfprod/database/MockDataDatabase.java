package com.example.appgfprod.database;

import android.app.Activity;
import android.content.Context;

import com.example.appgfprod.R;
import com.example.appgfprod.dto.EnumTipoDeObra;
import com.example.appgfprod.dto.MensajeDto;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.dto.PaisDto;
import com.example.appgfprod.dto.TipoDeObraDto;
import com.example.appgfprod.helper.PrefManager;
import com.example.appgfprod.repository.MensajeService;
import com.example.appgfprod.repository.ObraService;
import com.example.appgfprod.repository.PaisService;
import com.example.appgfprod.repository.TipoDeObraService;
import com.example.appgfprod.view.model.Injection;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockDataDatabase {
    private MensajeDto mensaje1, mensaje2, mensaje3, mensaje4;
    private List<MensajeDto> messageList;
    private List<ObraDto> obraList;
    private Activity activity;
    private PrefManager pref;
    private Context context;
    private MensajeService mensajeService;
    private ObraService obraService;
    private TipoDeObraService tipoDeObraService;
    private PaisService paisService;


    public MockDataDatabase(Context context, final WeakReference<Activity> mainReference) {
        this.activity = mainReference.get();
        this.context = context;
        pref = new PrefManager(this.context);
    }

    public void initMock(){
        obraService = Injection.provideObraService(context);
        mensajeService = Injection.provideMensajeService(context);
        tipoDeObraService = Injection.provideTipoDeObraService(context);
        paisService = Injection.providePaisService(context);

        insertObra();
        insertMessage();
    }

    private void insertObra() {
        obraList = new ArrayList<>();
        Date d = new Date();
        LocalDateTime date = LocalDateTime.from(Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()));

        TipoDeObraDto tipo_obra = new TipoDeObraDto(1, EnumTipoDeObra.DRAMA, "Emocionante");
        tipoDeObraService.insertOrUpdateTipoDeObra(tipo_obra);

        PaisDto pais = new PaisDto("1", "Uruguay");
        paisService.insertOrUpdatePais(pais);

        ObraDto obra1 = new ObraDto(1, "Obra 1", "Primera Obra", R.drawable.obra1, R.drawable.filled, "Juan", "Calle1", "Magia", date, "50m", tipo_obra, pais);
        ObraDto obra2 = new ObraDto(2, "Obra 2", "Segunda Obra", R.drawable.obra2, R.drawable.filled, "Maria", "Calle2", "Calle", date, "50m", tipo_obra, pais);
        ObraDto obra3 = new ObraDto(3, "Obra 3", "Tercera Obra", R.drawable.obra3, R.drawable.filled, "Barto", "Calle3", "Sol", date, "50m", tipo_obra, pais);
        ObraDto obra4 = new ObraDto(4, "Obra 4", "Cuarta Obra", R.drawable.obra4, R.drawable.filled, "Diego", "Calle4", "Luna", date, "50m", tipo_obra, pais);

        /*
        ModelMapper modelMapper = new ModelMapper();
        Obra obraEntity = modelMapper.map(obra1, Obra.class);
        */

        obraList.add(obra1);
        obraList.add(obra2);
        obraList.add(obra3);
        obraList.add(obra4);

        for (ObraDto obra: obraList){
            obraService.insertOrUpdateObra(obra);
        }
    }

    private void insertMessage() {
        messageList = new ArrayList<>();
        Date d = new Date();
        LocalDateTime date = LocalDateTime.from(Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()));

        mensaje1 = new MensajeDto(1, "uyDevs@gmail.com" , pref.getEmail() , date, "Drama", "La familia Robinson descendio del auto, y se acerco lentamente a la puerta de la casa", "Capitulo 1 - La casa", "Obra 1");
        mensaje2 = new MensajeDto(2, "uyDevs@gmail.com" , pref.getEmail() , date, "Drama", "John se detuvo, y simplmente contemplo la inmensidad de la casa, parecia irreal que alguien le hubiera reglado los papeles de la propiedad ", "Capitulo 1 - La casa", "Obra 1");
        mensaje3 = new MensajeDto(3, "uyDevs@gmail.com" , pref.getEmail() , date, "Terror", "A medida que caminaba por el bosque, sus pasos se perdian entre los sonidos de la naturaleza que lo rodeaba", "Capitulo 3 - Oraculo", "Obra 2");
        mensaje4 = new MensajeDto(4, "uyDevs@gmail.com" , pref.getEmail() , date, "Terror", "¿Qué fue eso? - penso al escuchar el sonido de un rama que se rompia detrás de él, ¿que hacer? Seguir buscano el oraculo o regresar a su casa ", "Capitulo 3 - Oraculo", "Obra 2");

        messageList.add(mensaje1);
        messageList.add(mensaje2);
        messageList.add(mensaje3);
        messageList.add(mensaje4);

        for (MensajeDto mensaje: messageList){
            mensajeService.insertOrUpdateMensaje(mensaje);
        }
    }
}
