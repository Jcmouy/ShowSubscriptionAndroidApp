package com.example.appgfprod.view.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appgfprod.R;
import com.example.appgfprod.adapter.ObraMessageAdapter;
import com.example.appgfprod.dto.MensajeDto;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.repository.MensajeService;
import com.example.appgfprod.repository.ObraService;
import com.example.appgfprod.util.constants.ConstantMenuFrag;
import com.example.appgfprod.view.model.Injection;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class CommunicationFragment extends Fragment {
    private List<ObraDto> obraList;
    private List<String> nombresObras;
    private List<MensajeDto> mensajeList;
    private HandleFragment handleFrag;
    private MensajeService mensajeService;
    private ObraService obraService;

    public CommunicationFragment() {
    }

    public static CommunicationFragment newInstance(String param1, String param2) {
        CommunicationFragment fragment = new CommunicationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleFrag = new HandleFragment(requireActivity().getSupportFragmentManager());
        mensajeService = Injection.provideMensajeService(requireContext());
        obraService = Injection.provideObraService(requireContext());
        nombresObras = new ArrayList<>();
        obraList = new ArrayList<>();

        mensajeList = mensajeService.getAll();

        for (MensajeDto mensaje : mensajeList){
            if (!nombresObras.contains(mensaje.getObraNombre())){
                nombresObras.add(mensaje.getObraNombre());
            }
        }

        for (String nombreObra: nombresObras){
            obraList.add(obraService.getObraByNombre(nombreObra));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_communication, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListAdapter lastChatAdp = new ObraMessageAdapter(requireContext(), obraList, new WeakReference<Activity>(requireActivity()));
        final ListView lv_LastMessageList = (ListView) view.findViewById(R.id.lv_LastMessageList);
        if (lv_LastMessageList != null) {
            lv_LastMessageList.setAdapter(lastChatAdp);

            lv_LastMessageList.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            List<MensajeDto> mensajesObra = new ArrayList<MensajeDto>();
                            ObraDto obraSeleccionada = obraList.get(position);
                            for (MensajeDto m : mensajeList){
                                if (m.getObraNombre().equals(obraSeleccionada.getNombre())){
                                    mensajesObra.add(m);
                                }
                            }

                            ObraMessageFragment obraMessage = ObraMessageFragment.newInstance(obraList.get(position), mensajesObra);

                            handleFrag.addFragmentToList(ConstantMenuFrag.CHILD_OBRA_MESSAGE) ;

                            requireActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.main_frame_container, obraMessage, ConstantMenuFrag.CHILD_OBRA_MESSAGE)
                                    .addToBackStack(null)
                                    .commit();
                        }
                    }
            );

            lv_LastMessageList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    if (obraList.size() <= position) {
                        return false;
                    } else {
                        deleteObraMessage(position);
                        return true;
                    }
                }
            });
        }
    }

    private void deleteObraMessage(int position) {
        final ObraDto selectedObraItem = obraList.get(position);
        final CharSequence options[] = new CharSequence[]{"Delete Chat"};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(selectedObraItem.getNombre());
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // the user clicked on list[index]
                if (index == 0) {
                    // Delete Chat
                    new AlertDialog.Builder(requireContext())
                            .setTitle(selectedObraItem.getNombre())
                            .setMessage("Are you sure to delete this chat?")
                            .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(requireContext(), "Chat deleted successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}