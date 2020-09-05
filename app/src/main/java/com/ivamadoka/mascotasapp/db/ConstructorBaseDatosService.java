package com.ivamadoka.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.ivamadoka.mascotasapp.R;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorBaseDatosService {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorBaseDatosService(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosMascotas(){
        //aqui ponemos que siempre sera un arreglo de tipo mascota
        //1. abrir conexion a la bd
        BaseDatosDao db = new BaseDatosDao(context);
        //antes tenemos q insertar datos
        insertarOchoMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public  ArrayList<Mascota> obtnerDatosMascotasFavoritas(){
        BaseDatosDao db = new BaseDatosDao(context);
        Log.i("obtenerMascotasFav","si");
        return db.obtenerMascotasFavoritas();
    }

    public void insertarOchoMascotas(BaseDatosDao db) {
        //objeto contentenedor de valores
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Ivana");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro1);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Poto");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro2);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Gary");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro3);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Chester");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.foto_perro);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Fifu");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro4);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Chichi");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro5);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Oppai");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro6);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_NOMBRE, "Peludito");
        contentValues.put(ConstanteBaseDatos.TABLE_PET_FOTO, R.drawable.perro7);
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES, 0);
        db.insertarMascota(contentValues);

    }


    public void darLike(Mascota mascota){
        //abrimos la base de datos
        BaseDatosDao db = new BaseDatosDao(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_PET_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public  int obtenerLike (Mascota mascota){
        BaseDatosDao db = new BaseDatosDao(context);
        return db.obtenerLikesMascota(mascota);

    }
    public void actualizarMascota(Mascota mascota, Integer likes){
        //abrimos la base de datos
        BaseDatosDao db = new BaseDatosDao(context);
        Log.i("likes", likes.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_PET_LIKES,likes);
        db.actualizarLikesMascotas(contentValues, mascota);

    }

}
