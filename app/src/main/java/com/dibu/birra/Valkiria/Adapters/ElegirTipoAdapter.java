package com.valkiria.cerveza.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.valkiria.cerveza.Model.Cerveza;
import com.valkiria.cerveza.R;

import java.util.List;

/**
 * Created by dibu on 30/09/2017.
 */

public class ElegirTipoAdapter extends RecyclerView.Adapter<ElegirTipoAdapter.ViewHolder>{

    private List<Cerveza> cervezas;
    private int layout;
    private OnItemClickListener itemClickListener;

    public ElegirTipoAdapter(List<Cerveza> cervezas, int layout, OnItemClickListener listener){
        this.cervezas = cervezas;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(cervezas.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {

        return this.cervezas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView id;
        public ImageView foto;

        public ViewHolder(View view){
            super(view);
            this.name = (TextView) view.findViewById(R.id.cerveza_name );
            this.id = (TextView) view.findViewById(R.id.cerveza_id);
            this.foto = (ImageView) view.findViewById(R.id.imageViewCerveza);
        }

        public void bind(final Cerveza birra, final OnItemClickListener listener ){
            this.name.setText( "** " + birra.getDescrip() + " **");
            this.id.setText( " - " + Integer.toString(birra.getId()) );
            this.foto.setImageResource( birra.getFoto() );

            //itemView heredada de   RecyclerView.ViewHolder
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(birra, getAdapterPosition());
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Cerveza birra, int position);
    }
}
