package com.example.appgfprod.view.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.appgfprod.R;
import com.example.appgfprod.dto.MensajeDto;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.helper.PrefManager;
import com.example.appgfprod.repository.MensajeService;
import com.example.appgfprod.util.FormatDate;
import com.example.appgfprod.util.constants.ConstantMessage;
import com.example.appgfprod.view.model.Injection;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class ObraMessageFragment extends Fragment {
    private ScrollView scrollView;
    private LinearLayout layout;
    private EditText messageArea;
    private PrefManager pref;
    private static ObraDto obraSeleccionada;

    private static List<MensajeDto> messageObtenidosDB;
    private List<MensajeDto> messageList = new ArrayList<>();
    private MensajeDto mensaje1, mensaje2;
    private MensajeService mensajeService;
    private FloatingActionButton submit_btn;
    private FormatDate fmDate;

    public ObraMessageFragment() {
    }

    public static ObraMessageFragment newInstance(ObraDto obra, List<MensajeDto> mensajesObra) {
        ObraMessageFragment fragment = new ObraMessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        obraSeleccionada = obra;
        messageObtenidosDB = mensajesObra;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new PrefManager(requireContext());
        fmDate = new FormatDate(requireContext(), new WeakReference<Activity>(requireActivity()));
        mensajeService = Injection.provideMensajeService(requireContext());

        messageList = new ArrayList<>();
        messageList.addAll(messageObtenidosDB);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_obra, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarMessageObra);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        layout = (LinearLayout) view.findViewById(R.id.layout1);
        messageArea = (EditText) view.findViewById(R.id.et_Message);
        submit_btn = (FloatingActionButton) view.findViewById(R.id.submit_btn);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(obraSeleccionada.getNombre());

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);

        View rootView = view.findViewById(R.id.rootLayout);
        EmojiconEditText emojiconEditText = (EmojiconEditText) view.findViewById(R.id.et_Message);
        ImageView emojiImageView = (ImageView) view.findViewById(R.id.emoji_btn);

        final EmojIconActions emojIcon = new EmojIconActions(requireContext(), rootView, emojiconEditText, emojiImageView, "#1c2764", "#e8e8e8", "#f4f4f4");
        emojIcon.ShowEmojIcon();

        emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
            @Override
            public void onKeyboardClose() {
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ingresar a los detalles de la obra
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_SendMessageClick(v);
            }
        });

        getMensajesDb();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // set last seen
        DateFormat dateFormat = new SimpleDateFormat("dd MM yy hh:mm a");
        Date date = new Date();
    }

    public void getMensajesDb(){

        for (MensajeDto mens : messageList){

            LocalDateTime t = mens.getFecha();
            Date date = DateTimeUtils.toDate(t.atZone(ZoneId.systemDefault()).toInstant());
            String properDate = fmDate.messageSentDateProper(fmDate.dateToString(date));

            if (mens.getRemitente().equals(pref.getEmail()) ){
                appendMessage(mens.getValor(), properDate, ConstantMessage.USER, false);
            } else {
                appendMessage(mens.getValor(), properDate, ConstantMessage.SERVER, false);
            }
        }
    }

    public void btn_SendMessageClick(View view) {

        String message = messageArea.getText().toString().trim();
        messageArea.setText("");
        if (!message.equals("")) {

            Date d = new Date();
            LocalDateTime date = LocalDateTime.from(Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()));

            int lastInsertedId = mensajeService.getLastInsertedIdMensaje();
            MensajeDto mensajeUsuario = new MensajeDto(lastInsertedId + 1, pref.getEmail(), "uyDevs@gmail.com", date, "Drama", message, "", "Obra 1");
            mensajeService.insertOrUpdateMensaje(mensajeUsuario);

            DateFormat dateFormat = new SimpleDateFormat("hh:mm");
            String sentDate = dateFormat.format(d);

            appendMessage(message, sentDate, ConstantMessage.USER, false);
        }
    }

    public void appendMessage(String mess, String sentDate, int messType, final boolean scrollUp) {

        EmojiconTextView textView = new EmojiconTextView(requireContext());
        textView.setEmojiconSize(30);

        SpannableString dateString = new SpannableString(sentDate);
        dateString.setSpan(new RelativeSizeSpan(0.7f), 0, sentDate.length(), 0);
        dateString.setSpan(new ForegroundColorSpan(Color.GRAY), 0, sentDate.length(), 0);

        textView.setText(mess + "\n");
        textView.setTextSize(13.5f);
        textView.append(dateString);
        textView.setTextColor(Color.parseColor("#000000"));


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                650,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                6f
        );
        lp.setMargins(0, 10, 0, 10);
        // 1 user
        if (messType == ConstantMessage.USER) {
            textView.setBackgroundResource(R.drawable.messagebg1);
            lp.gravity = Gravity.RIGHT;
        }
        //  2 friend
        else {
            textView.setBackgroundResource(R.drawable.messagebg2);
            lp.gravity = Gravity.LEFT;
        }

        textView.setPadding(40, 4, 40, 10);
        textView.setLineSpacing(textView.getLineHeight(),0.3f);

        textView.setLayoutParams(lp);
        layout.addView(textView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                if (scrollUp)
                    scrollView.fullScroll(View.FOCUS_UP);
                else
                    scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}