package com.example.sayagymapp;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayagymapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.sayagymapp.databinding.FragmentRutinasListBinding;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRutinasListViewAdapter extends RecyclerView.Adapter<MyRutinasListViewAdapter.ViewHolder> {

    private final ArrayList<Rutina> mValues;

    public MyRutinasListViewAdapter(ArrayList<Rutina> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_rutinas_list, parent, false);
        return new MyRutinasListViewAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.getNombre());
        holder.Ejercicio1.setText(holder.mItem.getEjercicio1());
        holder.Ejercicio2.setText(holder.mItem.getEjercicio2());
        holder.Ejercicio3.setText(holder.mItem.getEjercicio3());
        holder.Ejercicio4.setText(holder.mItem.getEjercicio4());
        holder.Ejercicio5.setText(holder.mItem.getEjercicio5());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView Ejercicio1, Ejercicio2, Ejercicio3, Ejercicio4, Ejercicio5;
        public Rutina mItem;

        public ViewHolder(View view) {
            super(view);
            mIdView = view.findViewById(R.id.TipoRutinaView);
            Ejercicio1 = view.findViewById(R.id.Ejercicio1view);
            Ejercicio2 = view.findViewById(R.id.Ejercicio2view);
            Ejercicio3 = view.findViewById(R.id.Ejercicio3view);
            Ejercicio4 = view.findViewById(R.id.Ejercicio4view);
            Ejercicio5 = view.findViewById(R.id.Ejercicio5view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }
}