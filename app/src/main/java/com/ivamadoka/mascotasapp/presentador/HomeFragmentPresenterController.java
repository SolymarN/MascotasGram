package com.ivamadoka.mascotasapp.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ivamadoka.mascotasapp.db.ConstructorBaseDatosService;
import com.ivamadoka.mascotasapp.fragments.IHomeFragmentView;
import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;
import com.ivamadoka.mascotasapp.restApi.EndPointsApi;
import com.ivamadoka.mascotasapp.restApi.adapter.ResApiAdapter;
import com.ivamadoka.mascotasapp.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenterController implements IHomeFragmentPresenter {

    private ConstructorBaseDatosService constructorBaseDatosService;
    private ArrayList<Mascota> mascotas;
    private ArrayList<MascotaApi> mascotasApi;
    private Context context;
    private IHomeFragmentView homeFragmentView;

    public HomeFragmentPresenterController(Context context, IHomeFragmentView homeFragmentView) {
        this.context = context;
        this.homeFragmentView = homeFragmentView;
       // obtenerMascotasAll();
        obtenerDatosRecientesApi();
    }

    @Override
    public void obtenerMascotasAll() {
        //instanciamos para podes usar los metodos del servicio
        constructorBaseDatosService = new ConstructorBaseDatosService(context);
        //aqui separamos la fuente de los datos con la presenteacion de los datos
        //cargamos el arreglo de datos
        mascotasApi = constructorBaseDatosService.obtenerDatosMascotas();
        mostrarMascotasRV();

    }

    @Override
    public void obtenerDatosRecientesApi() {

        // Se define como se van a presentar los datos
        //establecer conexion con el api de ig ResApiAdapter genera la consulta
        ResApiAdapter resApiAdapter = new ResApiAdapter();
        //cuando el api responde en json el retrofit localiza una clase que tenga la misma forma de la respuesta
        //este deserializador se puso primero para poder enviarlo como parametro
        Gson gsonMediaREcent = resApiAdapter.construyeGsonDeserializadorDataApi();
        //conexion al servidor y le pasamos la manera enq queremos deserializar con el gsonmediarecen

        EndPointsApi endPointsApi = resApiAdapter.establecerConexionResApiIg(gsonMediaREcent);
        //ejecutar la llamada a get recent media
        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getRecentMedia();
        // enqueue para controlar el resultado de la respuesta
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotasApi = mascotaResponse.getMascota();
                Log.i("Exitosa la conexion!!", "bien" );
                mostrarMascotasRV();

            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexion, Intenta de Nuevo", Toast.LENGTH_LONG).show();
                Log.i("Fallo la conexion!!", t.toString() );
            }
        });

    }

    @Override
    public void mostrarMascotasRV() {
        //adaptador

        homeFragmentView.inicializarAdaptadorRV(homeFragmentView.crearAdaptador(mascotasApi));
        //definir  como sera el recycler view
        homeFragmentView.generarLinearLayoutVertical();
      //  homeFragmentView.generarGridLayout();

    }


}
