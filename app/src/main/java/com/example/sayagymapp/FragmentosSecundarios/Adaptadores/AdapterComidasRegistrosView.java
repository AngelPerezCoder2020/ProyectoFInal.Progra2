package com.example.sayagymapp.FragmentosSecundarios.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sayagymapp.ClasesSecundarias.RegistroComida;
import com.example.sayagymapp.R;

import java.util.ArrayList;

public class AdapterComidasRegistrosView extends RecyclerView.Adapter<AdapterComidasRegistrosView.ViewHolder> {
    String desayuno, merienda1, almuerzo, merienda2, cena;

    private final ArrayList<RegistroComida> mValues;

    public AdapterComidasRegistrosView(ArrayList<RegistroComida> items) {
        mValues = items;
    }

    @Override
    public AdapterComidasRegistrosView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comidas_shape, parent, false);
        return new AdapterComidasRegistrosView.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterComidasRegistrosView.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Convertidor(holder.mItem);
        holder.FechaTxt.setText(holder.mItem.getFecha());
        holder.Desayuno.setText(desayuno);
        holder.MeriendaAm.setText(merienda1);
        holder.Almuerzo.setText(almuerzo);
        holder.MeriendaPm.setText(merienda2);
        holder.Cena.setText(cena);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView FechaTxt,Desayuno,MeriendaAm,Almuerzo,MeriendaPm,Cena;
        public RegistroComida mItem;

        public ViewHolder(View view) {
            super(view);
            FechaTxt = view.findViewById(R.id.FechaTexto);
            Desayuno = view.findViewById(R.id.desayunoText);
            MeriendaAm = view.findViewById(R.id.meriendaAm);
            Almuerzo = view.findViewById(R.id.almuerzotext);
            MeriendaPm = view.findViewById(R.id.meriendatarde);
            Cena = view.findViewById(R.id.cenatext);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + FechaTxt.getText() + "'";
        }
    }
    public void Convertidor(RegistroComida item){
        if(item.getDesayuno()){ desayuno = "Desayuno: COMPLETADO"; }else{ desayuno = "Desayuno: NO COMPLETADO"; }
        if(item.getMeriendaAM()){ merienda1 = "Merinda Matutina: COMPLETADO"; }else{ merienda1 = "Merinda Matutina: NO COMPLETADO"; }
        if(item.getAlmuerzo()){ almuerzo = "Almuerzo: COMPLETADO"; }else{ almuerzo = "Almuerzo: NO COMPLETADO"; }
        if(item.getMeriendaPM()){ merienda2 = "Merienda Vespertina: COMPLETADO"; }else{ merienda2 = "Merienda Vespertina: NO COMPLETADO"; }
        if(item.getCena()){ cena = "Cena: COMPLETADO"; }else{ cena = "Cena: NO COMPLETADO"; }

    }
}

