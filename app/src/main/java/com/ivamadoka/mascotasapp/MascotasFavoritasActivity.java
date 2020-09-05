package com.ivamadoka.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.fragments.IHomeFragmentView;
import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.presentador.IMascotasFavoritasPresentador;
import com.ivamadoka.mascotasapp.presentador.MascotasFavoritasPresentador;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity  implements IMascotasFavoritasActivityView{

    private RecyclerView listaMascotasFavoritas;
    private IMascotasFavoritasPresentador iMascotasFavoritasPresentador;
    private IHomeFragmentView homeFragmentView;
    private Activity activity;
    ArrayList<Mascota> mascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        activity = this;
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //recepcion de parametros con Bundle
        Bundle parametros = getIntent().getExtras();
        mascotasFavoritas = (ArrayList<Mascota>) parametros.getSerializable(getResources().getString(R.string.mascotasFavoritas));

        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvListaMascotaFavorita);
        //        iHomeFragmentPresenter = new HomeFragmentPresenterController(getContext(), this);
        iMascotasFavoritasPresentador = new MascotasFavoritasPresentador(getBaseContext(),this);

      /*  LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);
       // listMascotas();
        getAdaptador();
*/
    }
    public void listMascotas(){
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota("Ivana ",R.drawable.perro3,23));
        mascotasFavoritas.add(new Mascota("Poto ",R.drawable.perro2,11));
        mascotasFavoritas.add(new Mascota("Gary ",R.drawable.perro1,8));
        mascotasFavoritas.add(new Mascota("Chester ",R.drawable.foto_perro,2));
        mascotasFavoritas.add(new Mascota("Fifu ",R.drawable.perro4,1));
    }
    public  void getAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(mascotasFavoritas, this);
        listaMascotasFavoritas.setAdapter(adaptador);

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(activity);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, activity);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        listaMascotasFavoritas.setAdapter(adapter);
    }
}