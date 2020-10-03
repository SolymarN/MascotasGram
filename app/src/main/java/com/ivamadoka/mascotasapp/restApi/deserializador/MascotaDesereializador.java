package com.ivamadoka.mascotasapp.restApi.deserializador;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;
import com.ivamadoka.mascotasapp.restApi.JsonKeys;
import com.ivamadoka.mascotasapp.restApi.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDesereializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONDE_ARRAY);
        mascotaResponse.setMascota(deserializarMascotaDeJson(mascotaResponseData));

        return mascotaResponse;
    }

    private ArrayList<MascotaApi> deserializarMascotaDeJson(JsonArray mascotaResponseData) {
        ArrayList<MascotaApi> mascotaApis = new ArrayList<>();
        Log.i("deserializador size", String.valueOf(mascotaResponseData.size()));

        for (int i = 0; i <  mascotaResponseData.size(); i++) {
            JsonObject contactoResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            String id           = contactoResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String username     = contactoResponseDataObject.get(JsonKeys.USER_FULLNAME).getAsString();
            String urlFoto      = contactoResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            //int likes           = contactoResponseDataObject.get(JsonKeys.USER_ID).getAsInt();

            MascotaApi mascotaActual = new MascotaApi();
            mascotaActual.setUser_id(id);
            mascotaActual.setNombreCompleto(username);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikesFoto(0);

            mascotaApis.add(mascotaActual);

        }

        return mascotaApis;
    }

}
