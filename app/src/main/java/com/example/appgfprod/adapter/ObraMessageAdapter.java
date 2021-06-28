package com.example.appgfprod.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appgfprod.R;
import com.example.appgfprod.dto.MensajeDto;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.repository.MensajeService;
import com.example.appgfprod.util.FormatDate;
import com.example.appgfprod.view.model.Injection;

import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ObraMessageAdapter extends ArrayAdapter<ObraDto> {
    private Activity activity;
    private MensajeService mensajeService;
    private List<MensajeDto> messageList;
    FormatDate fmDate;

    public ObraMessageAdapter(@NonNull Context context, List<ObraDto> obraList, final WeakReference<Activity> mainReference) {
        super(context, R.layout.custom_obra_row, obraList);
        this.activity = mainReference.get();
        fmDate = new FormatDate(context, mainReference);
        mensajeService = Injection.provideMensajeService(context);
        messageList = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_obra_row, parent, false);

        ObraDto obra = getItem(position);
        messageList = mensajeService.getAllMensajeByObra(obra.getNombre());

        TextView tv_Name = (TextView) customView.findViewById(R.id.tv_obra_FullName);
        TextView tv_MessageDate = (TextView) customView.findViewById(R.id.tv_obra_MessageDate);
        tv_Name.setText(obra.getNombre());

        LocalDateTime t = messageList.get(messageList.size() - 1).getFecha();
        Date date = DateTimeUtils.toDate(t.atZone(ZoneId.systemDefault()).toInstant());
        String properDate = fmDate.messageSentDateProper(fmDate.dateToString(date));

        tv_MessageDate.setText(properDate);
        if (obra.getNombre().length() > 20){
            obra.setNombre(obra.getNombre().substring(0,20));
        }
        tv_Name.setText(obra.getNombre());
        return customView;
    }

}
