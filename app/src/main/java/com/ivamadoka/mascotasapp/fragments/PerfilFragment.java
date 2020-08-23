package com.ivamadoka.mascotasapp.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivamadoka.mascotasapp.R;
import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.adapter.PerfilAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CardView cardView;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascotaPerfil);
        cardView = (CardView) v.findViewById(R.id.cvMascotaPerfil);
        //definir como mostrar el recycler : como lista
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
       // llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
        //carga de datos
        listMascotas();
        //adaptador
        getAdaptador();
        return v ;
    }

    public void listMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Ivana ",R.drawable.perro3,0));
        mascotas.add(new Mascota("Poto ",R.drawable.perro3,4));
        mascotas.add(new Mascota("Gary ",R.drawable.perro3,7));
        mascotas.add(new Mascota("Chester ",R.drawable.perro3,1));
        mascotas.add(new Mascota("Fifu ",R.drawable.perro3,7));
        mascotas.add(new Mascota("Chichi ",R.drawable.perro3,4));
        mascotas.add(new Mascota("Oppai ",R.drawable.perro3,2));
        mascotas.add(new Mascota("Indi ",R.drawable.perro3,1));
        mascotas.add(new Mascota("Peludito ",R.drawable.perro3,0));
    }

    public  void getAdaptador(){
        PerfilAdapter adaptador = new PerfilAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }
}