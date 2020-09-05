package com.ivamadoka.mascotasapp;

import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFavoritasActivityView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}
