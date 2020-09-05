package com.ivamadoka.mascotasapp.db;

public final class ConstanteBaseDatos {
    //declaracon de base de datos, tablas y campos
    // final singnifica q nadie podra alterar los datos son constantes
    public static final String DATABASE_NAME = "mascotasdb";
    public static final int DATABASE_VERSION = 1;

    //TABLA MASCOTAS
    public static final String TABLE_PET = "mascota";
    public static final String TABLE_PET_ID = "id";
    public static final String TABLE_PET_NOMBRE = "nombre";
    public static final String TABLE_PET_FOTO = "foto";
    public static final String TABLE_PET_LIKES = "likes";

    //TABLA RAITING
    public static final String TABLE_LIKES_PET = "mascota_like";
    public static final String TABLE_LIKES_PET_ID = "id";
    public static final String TABLE_LIKES_PET_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_like";


}
