package com.ivamadoka.mascotasapp;

import com.ivamadoka.mascotasapp.adapter.MascotaAdapter;
import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;

import java.util.ArrayList;

public interface IMascotasFavoritasActivityView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<MascotaApi> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}
