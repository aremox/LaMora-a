package com.aremox.lamorana.lamoraa;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ivan on 23/9/15.
 */
public class AdaptadorPueblos extends RecyclerView.Adapter<AdaptadorPueblos.PuebloViewHolder>  implements View.OnClickListener{

    private View.OnClickListener listener;
    private ArrayList<Pueblo> datos;

    public static class PuebloViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtPueblo;
        private TextView txtSubtitulo;
        private CardView colorCardView;

        public PuebloViewHolder(View itemView) {
            super(itemView);

            txtPueblo = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            colorCardView = (CardView)itemView.findViewById(R.id.card2);
        }

        public void bindPueblo(Pueblo t) {
            txtPueblo.setText(t.getNombre());
            txtSubtitulo.setText(t.getSubtitulo());
            Log.d("Color", t.getColor());
            //colorCardView.setCardBackgroundColor(Integer.parseInt(t.getColor()));
            colorCardView.setCardBackgroundColor(Color.parseColor(t.getColor()));
        }
    }

    public AdaptadorPueblos(ArrayList<Pueblo> datos) {
        this.datos = datos;
    }

    @Override
    public PuebloViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_titular, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        PuebloViewHolder tvh = new PuebloViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(PuebloViewHolder viewHolder, int pos) {
        Pueblo item = datos.get(pos);

        viewHolder.bindPueblo(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
