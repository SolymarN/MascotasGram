package com.ivamadoka.mascotasapp.fragments;

import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public interface IHomeFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}
