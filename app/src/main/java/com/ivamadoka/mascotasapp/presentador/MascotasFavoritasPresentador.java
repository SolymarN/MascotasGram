package com.ivamadoka.mascotasapp.presentador;

import android.content.Context;

import com.ivamadoka.mascotasapp.IMascotasFavoritasActivityView;
import com.ivamadoka.mascotasapp.db.ConstructorBaseDatosService;
import com.ivamadoka.mascotasapp.fragments.IHomeFragmentView;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasPresentador implements  IMascotasFavoritasPresentador{

    private ConstructorBaseDatosService constructorBaseDatosService;
    private ArrayList<Mascota> mascotasFav;
    private Context context;
  //  private IHomeFragmentView homeFragmentView;
    private IMascotasFavoritasActivityView iMascotasFavoritasActivityView;

    public MascotasFavoritasPresentador(Context context, IMascotasFavoritasActivityView iMascotasFavoritasActivityView) {
        this.context = context;
        this.iMascotasFavoritasActivityView = iMascotasFavoritasActivityView;
        obtenerMascotasFavAll();
    }

    @Override
    public void mostrarMascotasFavRV() {
        //como sera el Recycler view
        //primero adaptador y desps como se muestran los datos
        iMascotasFavoritasActivityView.inicializarAdaptadorRV(iMascotasFavoritasActivityView.crearAdaptador(mascotasFav));
        iMascotasFavoritasActivityView.generarLinearLayoutVertical();

    }

    @Override
    public void obtenerMascotasFavAll() {
        //llamado a metodo de consulta del service
        constructorBaseDatosService = new ConstructorBaseDatosService(context);
        mascotasFav = constructorBaseDatosService.obtnerDatosMascotasFavoritas();
        mostrarMascotasFavRV();
    }
}
