package com.example.appgfprod.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appgfprod.R;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.util.FormatDate;
import com.google.android.material.transition.MaterialContainerTransform;

import java.lang.ref.WeakReference;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

public class ObraDetailFragment extends Fragment {
    private FormatDate formatDate;
    private View rootView;

    public ObraDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TypedValue typedValue = new TypedValue();
        formatDate = new FormatDate(requireContext(), new WeakReference<Activity>(requireActivity()));

        requireContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int color = typedValue.data;

        MaterialContainerTransform setSharedElementEnterTransition = new MaterialContainerTransform();
        setSharedElementEnterTransition.setDuration(300L);
        setSharedElementEnterTransition.setElevationShadowEnabled(true);
        setSharedElementEnterTransition.setAllContainerColors(color);

    }


    public static ObraDetailFragment newInstance(ObraDto obra) {
        ObraDetailFragment fragment = new ObraDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("SELECTED_OBRA", obra);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_obra_detail, null);
        } else {
            ((ViewGroup) container.getParent()).removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatImageView image_obra = (AppCompatImageView) view.findViewById(R.id.image_obra_detail);
        AppCompatTextView obra_name = (AppCompatTextView) view.findViewById(R.id.textview_obra_name);
        AppCompatTextView obra_description = (AppCompatTextView) view.findViewById(R.id.textview_obra_description);
        AppCompatTextView obra_starring = (AppCompatTextView) view.findViewById(R.id.textview_obra_starring);
        AppCompatTextView obra_address = (AppCompatTextView) view.findViewById(R.id.textview_obra_address);
        AppCompatTextView obra_authors = (AppCompatTextView) view.findViewById(R.id.textview_obra_authors);
        AppCompatTextView obra_date = (AppCompatTextView) view.findViewById(R.id.textview_obra_date);
        AppCompatTextView obra_length = (AppCompatTextView) view.findViewById(R.id.textview_obra_length);
        AppCompatTextView obra_type = (AppCompatTextView) view.findViewById(R.id.textview_obra_type);

        Bundle args = getArguments();
        ObraDto obra = args.containsKey("SELECTED_OBRA") ? (ObraDto) args.getSerializable("SELECTED_OBRA") : null;

        image_obra.setImageResource(obra.getImagen());
        obra_name.setText(obra.getNombre());
        obra_description.setText(obra.getDescripcion());
        obra_starring.setText(obra.getProtagonistas());
        obra_address.setText(obra.getDireccion());
        obra_authors.setText(obra.getAutores());
        obra_date.setText(formatDate.formatLocalDateTimeToString(obra.getFecha()));
        obra_length.setText(obra.getNombre());
        obra_type.setText(obra.getNombre());

    }

}