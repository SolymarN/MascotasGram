package com.ivamadoka.mascotasapp.restApi.model;

import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;

import java.util.ArrayList;

public class MascotaResponse {
    //definicion de la respuestas ya que viene de un Json y no queremos todo

    ArrayList<MascotaApi> mascota;

    public ArrayList<MascotaApi> getMascota() {
        return mascota;
    }

    public void setMascota(ArrayList<MascotaApi> mascota) {
        this.mascota = mascota;
    }
}
