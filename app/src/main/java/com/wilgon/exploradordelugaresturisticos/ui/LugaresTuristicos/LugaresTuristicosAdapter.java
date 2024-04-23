package com.wilgon.exploradordelugaresturisticos.ui.LugaresTuristicos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wilgon.exploradordelugaresturisticos.R;

import java.util.List;

public class LugaresTuristicosAdapter extends RecyclerView.Adapter<LugaresTuristicosAdapter.LugarTuristicoViewHolder> {
    private OnLugarTuristicoClickListener clickListener;
    private Context context;
    private List<LugaresTuristicos> lugaresTuristicos;


    public LugaresTuristicosAdapter(Context context, List<LugaresTuristicos> lugaresTuristicos) {
        this.context = context;
        this.lugaresTuristicos = lugaresTuristicos;
    }


    public void setLugaresTuristicos(List<LugaresTuristicos> lugaresTuristicos) {
        this.lugaresTuristicos = lugaresTuristicos;
    }

    @NonNull
    @Override
    public LugarTuristicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lugar_turistico, parent, false);
        return new LugarTuristicoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LugarTuristicoViewHolder holder, int position) {
        LugaresTuristicos lt = lugaresTuristicos.get(position);
        holder.nombreTextView.setText(lt.getNombre());
        //holder.descripcionTextView.setText(lt.getDescripcion());
        holder.imagenPrincipal.setImageResource(lt.getImagen());

        // Agregar OnClickListener para la imagen
        holder.imagenPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetalleActivity.class);

                // Pasar datos adicionales al Intent
                intent.putExtra("nombre", lt.getNombre());
                intent.putExtra("descripcion", lt.getDescripcion());
                intent.putExtra("imagen", lt.getImagen());
                intent.putExtra("horarioApertura", lt.getHorarioApertura());
                intent.putExtra("imagen2", lt.getImagen2());
                // Iniciar la actividad de detalle
                context.startActivity(intent);
            }
        });

        holder.nombreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, DetalleActivity.class);

                // Pasar datos adicionales al Intent
                intent.putExtra("nombre", lt.getNombre());
                intent.putExtra("descripcion", lt.getDescripcion());
                intent.putExtra("imagen", lt.getImagen());
                intent.putExtra("horarioApertura", lt.getHorarioApertura());

                // Iniciar la actividad de detalle
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onLugarTuristicoClick(lt);
            }
        });

    }


    @Override
    public int getItemCount() {
        return lugaresTuristicos.size();
    }


    public interface OnLugarTuristicoClickListener {
        void onLugarTuristicoClick(LugaresTuristicos lugarTuristico);
    }


    public void setOnLugarTuristicoClickListener(OnLugarTuristicoClickListener listener) {
        this.clickListener = listener;
    }

    static class LugarTuristicoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView descripcionTextView;
        ImageView imagenPrincipal;

        LugarTuristicoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.text_nombre);
            descripcionTextView = itemView.findViewById(R.id.text_descripcion);
            imagenPrincipal = itemView.findViewById(R.id.imageView);
        }
    }
}
