package com.example.appgfprod.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appgfprod.R;
import com.example.appgfprod.dto.ObraDto;
import com.example.appgfprod.util.ImageLoader;

import java.util.List;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogoRecyclerAdapter extends RecyclerView.Adapter<CatalogoRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<ObraDto> obraList;
    private ItemClickListener mOnClickListener;
    private ImageLoader imgLoder = new ImageLoader();
    // private RecyclerItemClickListener clickListener;

    public interface ItemClickListener{
        void onItemClick(int position , MyViewHolder holder);
    }

    public CatalogoRecyclerAdapter(Context context, List<ObraDto> obraList, ItemClickListener onClickListener ) {
        this.context = context;
        this.obraList = obraList;
        this.mOnClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_catalogo, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ObraDto item = obraList.get(position);
        holder.name_obra.setText(item.getNombre());
        ViewCompat.setTransitionName(holder.image_obra,  item.getNombre());
        imgLoder.loadImage(context, item.getImagen(), holder.image_obra);

        holder.image_obra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onItemClick(position, holder);
            }
        });    }

    @Override
    public int getItemCount() {
        return obraList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name_obra;
        public ImageView image_obra;

        public MyViewHolder(View view) {
            super(view);
            name_obra = view.findViewById(R.id.obra_name);
            image_obra = view.findViewById(R.id.image_obra_thumbnail);
        }

    }



}
