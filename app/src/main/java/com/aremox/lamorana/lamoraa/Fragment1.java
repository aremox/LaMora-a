package com.aremox.lamorana.lamoraa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ivan on 19/9/15.
 */
public class Fragment1 extends Fragment {

    private RecyclerView recView;

    private ArrayList<Pueblo> datos;
    private String[] colores = new String[]{"#FF0000", "#00FF33", "#00FFDA", "#DEFF00", "#FF00FF", "#0055FF", "#FF9100", "#838383", "#FF9AEF"};

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Random r = new Random();

        datos = new ArrayList<Pueblo>();
        for(int i=0; i<50; i++) {
            int valorAleatorio = r.nextInt(9);
            datos.add(new Pueblo("Título " + i, "Subtítulo item " + i, colores[valorAleatorio]));
        }
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        recView = (RecyclerView)getView().findViewById(R.id.RecView);

        recView.setHasFixedSize(true);

        final AdaptadorPueblos adaptador = new AdaptadorPueblos(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Alternativa 2:
                String opcionSeleccionada =
                      ((TextView)v.findViewById(R.id.LblTitulo))
                          .getText().toString();

                Log.i("DemoRecView", "Pulsado el elemento " + opcionSeleccionada);


                //Creamos el Intent
                Intent intent;
                intent = new Intent(getActivity(),PuebloActivity.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                Integer posicion = recView.getChildAdapterPosition(v);

                b.putString("NOMBRE", opcionSeleccionada);

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        recView.setAdapter(adaptador);

        //recView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        recView.setLayoutManager(new GridLayoutManager(this.getContext(),2));

    }
}