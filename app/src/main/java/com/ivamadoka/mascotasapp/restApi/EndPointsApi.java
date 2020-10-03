package com.ivamadoka.mascotasapp.restApi;

import com.ivamadoka.mascotasapp.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointsApi {

    //con el @get declaramos el url que vamos a consultar esta ne las constantes
    @GET(ConstantesRestApi.URL_GET_MEDIA_USER)
    //metodo que genera las peticiones para retrofit
    Call<MascotaResponse> getRecentMedia();
}
