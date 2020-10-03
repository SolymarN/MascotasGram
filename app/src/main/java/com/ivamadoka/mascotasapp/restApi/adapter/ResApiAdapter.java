package com.ivamadoka.mascotasapp.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ivamadoka.mascotasapp.restApi.ConstantesRestApi;
import com.ivamadoka.mascotasapp.restApi.EndPointsApi;
import com.ivamadoka.mascotasapp.restApi.deserializador.MascotaDesereializador;
import com.ivamadoka.mascotasapp.restApi.model.MascotaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResApiAdapter {

//establecer conexion con el api utilizando los Endpoint que son las
//A las URL's que reciben o retornan información de un Web API se les llama endpoints
    public EndPointsApi establecerConexionResApiIg(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointsApi.class);

    }

    public Gson construyeGsonDeserializadorDataApi(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDesereializador());

        return  gsonBuilder.create();
    }


}
