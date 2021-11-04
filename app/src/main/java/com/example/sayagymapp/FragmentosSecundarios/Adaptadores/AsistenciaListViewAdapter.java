package com.example.sayagymapp.FragmentosSecundarios.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sayagymapp.ClasesSecundarias.Asistencia;
import com.example.sayagymapp.ClasesSecundarias.Comida;
import com.example.sayagymapp.R;

import java.util.ArrayList;

public class AsistenciaListViewAdapter extends RecyclerView.Adapter<AsistenciaListViewAdapter.ViewHolder> {

    private final ArrayList<Asistencia> mValues;

    public AsistenciaListViewAdapter(ArrayList<Asistencia> items) {
        mValues = items;
    }

    @Override
    public AsistenciaListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asistencia_item_shape, parent, false);
        return new AsistenciaListViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AsistenciaListViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.FechaTxt.setText(holder.mItem.getFechaAsistida().toString());
        holder.HoraInicioTxt.setText(holder.mItem.getHoraEntrada());
        holder.HoraSalidaTxt.setText(holder.mItem.getHoraSalida());
        holder.RutinaRealizada.setText(holder.mItem.getRutinaRealizada());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView FechaTxt, HoraInicioTxt, HoraSalidaTxt, RutinaRealizada;
        public Asistencia mItem;

        public ViewHolder(View view) {
            super(view);
            FechaTxt = view.findViewById(R.id.FechaTextView);
            HoraInicioTxt = view.findViewById(R.id.HoraEntradaTextView);
            HoraSalidaTxt = view.findViewById(R.id.HoraSalidaTextView);
            RutinaRealizada = view.findViewById(R.id.rutinaRealizadaTextView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + FechaTxt.getText() + "'";
        }
    }
}