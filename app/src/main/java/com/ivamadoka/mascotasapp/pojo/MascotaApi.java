package com.ivamadoka.mascotasapp.pojo;

public class MascotaApi {

    private String user_id;
    private String nombreCompleto;
    private String urlFoto;
    private int likesFoto = 0;


    public MascotaApi() {

    }

    public MascotaApi(String user_id, String nombreCompleto, String urlFoto, int likesFoto) {
        this.user_id = user_id;
        this.nombreCompleto = nombreCompleto;
        this.urlFoto = urlFoto;
        this.likesFoto = likesFoto;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikesFoto() {
        return likesFoto;
    }

    public void setLikesFoto(int likesFoto) {
        this.likesFoto = likesFoto;
    }
}
