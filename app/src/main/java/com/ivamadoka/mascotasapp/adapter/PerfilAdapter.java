package com.ivamadoka.mascotasapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ivamadoka.mascotasapp.R;
import com.ivamadoka.mascotasapp.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdapter extends  RecyclerView.Adapter<PerfilAdapter.MascotaPerfilViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdapter(ArrayList<Mascota> mascotas, FragmentActivity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);

        return new PerfilAdapter.MascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaPerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position); //obtengo el objeto q esta iterando por la posicion
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvRaiting.setText(Integer.toString(mascota.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder {
        //declarar  elementos que tendra la lista
        private ImageView imgFoto;
        private TextView tvRaiting;


        public MascotaPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto =  itemView.findViewById(R.id.imgFotoPerfilcv);
            tvRaiting = itemView.findViewById(R.id.tvRaitingPerfilcv);

        }
    }
}
