package com.ivamadoka.mascotasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivamadoka.mascotasapp.R;
import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;
import com.ivamadoka.mascotasapp.presentador.HomeFragmentPresenterController;
import com.ivamadoka.mascotasapp.presentador.IHomeFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentViewController#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentViewController extends Fragment implements IHomeFragmentView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<MascotaApi> mascotas;
    private RecyclerView listaMascotas;
    private IHomeFragmentPresenter iHomeFragmentPresenter;


    public HomeFragmentViewController() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmentViewController newInstance(String param1, String param2) {
        HomeFragmentViewController fragment = new HomeFragmentViewController();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascota);
        iHomeFragmentPresenter = new HomeFragmentPresenterController(getContext(), this);
        // generarLinearLayoutVertical();
        //carga de datos
       // listMascotas();
        //adaptador
        //getAdaptador();
        return v ;
    }

    public void listMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ivana ",R.drawable.perro1,0));
        mascotas.add(new Mascota("Gary ",R.drawable.perro2,0));
        mascotas.add(new Mascota("Chester",R.drawable.perro3,0));
        mascotas.add(new Mascota("Poto",R.drawable.foto_perro,0));
        mascotas.add(new Mascota("Fifu ",R.drawable.perro4,0));
        mascotas.add(new Mascota("Chichi ",R.drawable.perro5,0));
        mascotas.add(new Mascota("Oppai ",R.drawable.perro6,0));
        mascotas.add(new Mascota("Indi ",R.drawable.perro7,0));
        mascotas.add(new Mascota("Peludito ",R.drawable.perro8,0));
    }

    public  void getAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    @Override
    public void generarLinearLayoutVertical() {
//definir como mostrar el recycler : como lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }


    @Override
    public MascotaAdapter crearAdaptador(ArrayList<MascotaApi> mascotas) {

        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        listaMascotas.setLayoutManager(gridLayoutManager);
    }
}