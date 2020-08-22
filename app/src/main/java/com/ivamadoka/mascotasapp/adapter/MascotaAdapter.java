package com.ivamadoka.mascotasapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivamadoka.mascotasapp.pojo.Mascota;
import com.ivamadoka.mascotasapp.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //aquie se hace una simulacion como si fuera una actividad con en inflador  ya q se coloca el layout que se mostrara en recycler view
        //en este caso es un card view pero puede ser cualquier view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        //paso de valores de la lista de datos que estara cargada
        //asociando cada elemento de la clase view holder con cada elemento de la clase principal
        //por posicion para setear el recurso que viene de la clase principal
        final Mascota mascota = mascotas.get(position); //obtengo el objeto q esta iterando por la posicion
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaiting.setText(Integer.toString(mascota.getRaiting()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity,"Diste like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                int meGusta = mascota.getRaiting();
                mascota.setRaiting(++meGusta);
                mascotaViewHolder.tvRaiting.setText(Integer.toString(mascota.getRaiting()));

            }
        });


    }

    @Override
    public int getItemCount() {
        //retorna tamano de la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        //declarar  elementos que tendra la lista
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaiting;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto =  itemView.findViewById(R.id.imgFotocv);
            tvNombre = itemView.findViewById(R.id.tvNombrecv);
            tvRaiting = itemView.findViewById(R.id.tvRaitingcv);
            btnLike = itemView.findViewById(R.id.btnhuesoBlancocv);

        }
    }
}
