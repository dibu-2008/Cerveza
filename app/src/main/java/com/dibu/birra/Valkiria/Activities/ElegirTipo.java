package com.valkiria.cerveza.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.valkiria.cerveza.Adapters.ElegirTipoAdapter;
import com.valkiria.cerveza.Model.Cerveza;
import com.valkiria.cerveza.Model.Recetario;
import com.valkiria.cerveza.R;

import java.util.List;

public class ElegirTipo extends AppCompatActivity {

    private List<Cerveza> cervezas;
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegir_tipo);

        cervezas = getCervezas();

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewcelegirtipo);
        myLayoutManager = new LinearLayoutManager(this);

        myAdapter = new ElegirTipoAdapter(cervezas, R.layout.elegir_tipo_item, new ElegirTipoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Cerveza birra, int position) {
                Toast.makeText(ElegirTipo.this, birra.getDescrip() + " - posicion: " + position, Toast.LENGTH_LONG).show();
            }
        });

        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }

    private List<Cerveza> getCervezas(){

        Recetario  recetario = new Recetario();
        recetario.init();

        return recetario.getCervezas();
    }
}
