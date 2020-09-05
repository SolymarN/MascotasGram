package com.ivamadoka.mascotasapp.presentador;

import android.content.Context;

import com.ivamadoka.mascotasapp.db.ConstructorBaseDatosService;
import com.ivamadoka.mascotasapp.fragments.IHomeFragmentView;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresenterController implements IHomeFragmentPresenter {

    private ConstructorBaseDatosService constructorBaseDatosService;
    private ArrayList<Mascota> mascotas;
    private Context context;
    private IHomeFragmentView homeFragmentView;

    public HomeFragmentPresenterController(Context context, IHomeFragmentView homeFragmentView) {
        this.context = context;
        this.homeFragmentView = homeFragmentView;
        obtenerMascotasAll();
    }

    @Override
    public void obtenerMascotasAll() {
        //instanciamos para podes usar los metodos del servicio
        constructorBaseDatosService = new ConstructorBaseDatosService(context);
        //aqui separamos la fuente de los datos con la presenteacion de los datos
        //cargamos el arreglo de datos
        mascotas = constructorBaseDatosService.obtenerDatosMascotas();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        //adaptador

        homeFragmentView.inicializarAdaptadorRV(homeFragmentView.crearAdaptador(mascotas));
        //definir  como sera el recycler view
        homeFragmentView.generarLinearLayoutVertical();

    }


}
