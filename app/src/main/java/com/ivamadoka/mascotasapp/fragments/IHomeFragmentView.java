package com.ivamadoka.mascotasapp.fragments;

import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;

import java.util.ArrayList;

public interface IHomeFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<MascotaApi> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adapter);

    public void generarGridLayout();
}
