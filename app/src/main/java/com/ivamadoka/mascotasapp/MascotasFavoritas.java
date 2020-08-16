package com.ivamadoka.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private RecyclerView listaMascotasFavoritas;
    ArrayList<Mascota> mascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //recepcion de parametros con Bundle
        Bundle parametros = getIntent().getExtras();
        mascotasFavoritas = (ArrayList<Mascota>) parametros.getSerializable(getResources().getString(R.string.mascotasFavoritas));

        listaMascotasFavoritas = findViewById(R.id.rvListaMascotaFavorita);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);
       // listMascotas();
        getAdaptador();

    }
    public void listMascotas(){
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota("Gary ",R.drawable.perro3,23));
        mascotasFavoritas.add(new Mascota("Poto ",R.drawable.perro2,11));
        mascotasFavoritas.add(new Mascota("Ivana ",R.drawable.perro1,8));
        mascotasFavoritas.add(new Mascota("Chester ",R.drawable.foto_perro,2));
        mascotasFavoritas.add(new Mascota("Fifu ",R.drawable.perro4,1));
    }
    public  void getAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(mascotasFavoritas, this);
        listaMascotasFavoritas.setAdapter(adaptador);

    }
}