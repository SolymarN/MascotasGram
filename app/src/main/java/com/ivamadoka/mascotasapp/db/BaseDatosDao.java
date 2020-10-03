package com.ivamadoka.mascotasapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.pojo.MascotaApi;

import java.util.ArrayList;

public class BaseDatosDao extends SQLiteOpenHelper {

    private Context context;

    public BaseDatosDao(@Nullable Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creacion de estructuras de tablas
        String queryCrearTablaMascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_PET + "(" +
                ConstanteBaseDatos.TABLE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_PET_NOMBRE + " TEXT," +
                ConstanteBaseDatos.TABLE_PET_FOTO + " INTEGER," +
                ConstanteBaseDatos.TABLE_PET_LIKES + " INTEGER" +
                ")";

        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_PET + "(" +
                ConstanteBaseDatos.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + " INTEGER," +
                ConstanteBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER" +
                ")";


        sqLiteDatabase.execSQL(queryCrearTablaMascota);
        sqLiteDatabase.execSQL(queryCrearTablaMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstanteBaseDatos.TABLE_PET);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ ConstanteBaseDatos.TABLE_LIKES_PET);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<MascotaApi> obtenerTodasMascotas() {

        ArrayList<MascotaApi> mascotas = new ArrayList<MascotaApi>();
        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_PET;
        //ABRIR BD EN FORMA DE LECTURA O ESCRITURA
        SQLiteDatabase db = this.getWritableDatabase();
        //objeto cursor para que devuelva una coleccion de datos
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {

            MascotaApi mascotaActual = new MascotaApi();
            //requerimos setear los campos del arreglo dentro de los set del VO
        /*    mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setRaiting(registros.getInt(3));

            String queryLikes = "SELECT COUNT (" + ConstanteBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ") as likes" +
                    " FROM " + ConstanteBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstanteBaseDatos.TABLE_LIKES_PET_ID_MASCOTA +
                    " = " + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                //dudando un poco del indice
                mascotaActual.setRaiting(registrosLikes.getInt(0));
            } else {
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);
*/
        }
        //CERRAR BD
        db.close();
        Log.i("obtenerAll", String.valueOf(mascotas.size()));
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        //abrir bd en modo escritura
        SQLiteDatabase db = this.getWritableDatabase();
        //para insertar
        db.insert(ConstanteBaseDatos.TABLE_PET,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKES_PET,null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes=0;
        String query = "SELECT COUNT ("+ConstanteBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+")"+
                " FROM "+ ConstanteBaseDatos.TABLE_LIKES_PET+
                " WHERE "+ConstanteBaseDatos.TABLE_LIKES_PET_ID_MASCOTA +
                " = "+ mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        //no se pone argumento porq ya esta implicito en el query
        Cursor registro = db.rawQuery(query,null);
        //se puso if porq es un registro unico seguro
        if (registro.moveToNext()){
            likes = registro.getInt(0);
        }
        db.close();
        return likes;
    }

    public ArrayList<MascotaApi>  obtenerMascotasFavoritas(){
        ArrayList<MascotaApi> mascotas = new ArrayList<MascotaApi>();
        Log.i("obtenerMascotasDao","antes query");
        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_PET + " ORDER BY " + ConstanteBaseDatos.TABLE_PET_LIKES +" DESC LIMIT 5";
        Log.i("obtenerDaoquery",query);
        //ABRIR BD EN FORMA DE LECTURA O ESCRITURA
        SQLiteDatabase db = this.getWritableDatabase();
        //objeto cursor para que devuelva una coleccion de datos
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            MascotaApi mascotaActual = new MascotaApi();
            //requerimos setear los campos del arreglo dentro de los set del VO
            /*mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setRaiting(registros.getInt(3));
            mascotas.add(mascotaActual);
            */

        }
        db.close();
        Log.i("obtenerDaoquery", String.valueOf(mascotas.size()));
        return  mascotas;
    }

    public void actualizarLikesMascotas(ContentValues contentValues, Mascota mascota) {

        Log.i("actualizar mascotas", contentValues.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        //db.insert(ConstanteBaseDatos.TABLE_LIKES_PET,null,contentValues);
        db.update(ConstanteBaseDatos.TABLE_PET, contentValues, "id = ?", new String[]{String.valueOf(mascota.getId())});
        db.close();
    }
}
