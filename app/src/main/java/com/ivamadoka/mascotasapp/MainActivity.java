package com.ivamadoka.mascotasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascotas = findViewById(R.id.rvListaMascota);
        //definir como mostrar el recycler : como lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //carga de datos
        listMascotas();
        //adaptador
        getAdaptador();

    }

    public void listMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ivana ",R.drawable.perro1,0));
        mascotas.add(new Mascota("Poto ",R.drawable.perro2,0));
        mascotas.add(new Mascota("Gary ",R.drawable.perro3,0));
        mascotas.add(new Mascota("Chester ",R.drawable.foto_perro,0));
        mascotas.add(new Mascota("Fifu ",R.drawable.perro4,0));
        mascotas.add(new Mascota("Chichi ",R.drawable.perro5,0));
        mascotas.add(new Mascota("Oppai ",R.drawable.perro6,0));
        mascotas.add(new Mascota("Indi ",R.drawable.perro7,0));
        mascotas.add(new Mascota("Peludito ",R.drawable.perro8,0));
    }

    public  void getAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mrankin:
                //Toast.makeText(this,"ir al rankin 5",Toast.LENGTH_SHORT).show();
                mascotas = new ArrayList<Mascota>();

                mascotas.add(new Mascota("Gary ",R.drawable.perro3,23));
                mascotas.add(new Mascota("Poto ",R.drawable.perro2,11));
                mascotas.add(new Mascota("Ivana ",R.drawable.perro1,8));
                mascotas.add(new Mascota("Chester ",R.drawable.foto_perro,2));
                mascotas.add(new Mascota("Fifu ",R.drawable.perro4,1));

                Bundle bundle = new Bundle();

                bundle.putSerializable(getResources().getString(R.string.mascotasFavoritas), (Serializable) mascotas);

                Intent intent = new Intent(this, MascotasFavoritas.class);
                //intent.putExtra("listMascota", mascotas);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}