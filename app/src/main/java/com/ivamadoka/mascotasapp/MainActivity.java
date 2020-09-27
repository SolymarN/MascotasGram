package com.ivamadoka.mascotasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.adapter.PageAdapter;
import com.ivamadoka.mascotasapp.fragments.HomeFragmentViewController;
import com.ivamadoka.mascotasapp.fragments.PerfilFragment;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fabCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miActionBar = findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutt);
        viewPager =(ViewPager) findViewById(R.id.viewPager);
        fabCamera = (FloatingActionButton) findViewById(R.id.fabPhoto);
        setUpViewPager();
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tomando foto...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();            }
        });
/*
        listaMascotas = findViewById(R.id.rvListaMascota);
        //definir como mostrar el recycler : como lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //carga de datos
        listMascotas();
        //adaptador
        getAdaptador();
*/
    }

    public void listMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Gary ",R.drawable.perro1,0));
        mascotas.add(new Mascota("Poto ",R.drawable.perro2,0));
        mascotas.add(new Mascota("Ivana ",R.drawable.perro3,0));
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

                Intent intent = new Intent(this, MascotasFavoritasActivity.class);
                //intent.putExtra("listMascota", mascotas);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:

                Intent intentAcercaDe = new Intent(this, AcercaDeActivity.class);
                startActivity(intentAcercaDe);

                break;

            case R.id.mContacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;

            case R.id.mConfigCuenta:
                Intent intentCuenta= new Intent(this, ConfigCuentaActivity.class);
                startActivity(intentCuenta);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragmets(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragmentViewController());
        fragments.add(new PerfilFragment());
        return  fragments;
    }
    public  void setUpViewPager(){
        //poner en orbita los fragment
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),0,agregarFragmets()));
        tabLayout.setupWithViewPager(viewPager);
        //colocar icono al tab con posicion 0
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil);


    }
}