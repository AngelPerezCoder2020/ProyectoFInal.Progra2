package com.example.sayagymapp.FragmentosSecundarios;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayagymapp.ClasesSecundarias.Comida;
import com.example.sayagymapp.R;

import java.util.ArrayList;

public class MyDietasRecyclerViewAdapter extends RecyclerView.Adapter<MyDietasRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Comida> mValues;

    public MyDietasRecyclerViewAdapter(ArrayList<Comida> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dietas_viewer, parent, false);
        return new MyDietasRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitulo.setText(holder.mItem.getNombre());
        holder.mComidaText.setText(holder.mItem.getDieta());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitulo;
        public final TextView mComidaText;
        public Comida mItem;

        public ViewHolder(View view) {
            super(view);
            mTitulo = view.findViewById(R.id.HoraDeComidaText);
            mComidaText = view.findViewById(R.id.dietaTextVIew);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitulo.getText() + "'";
        }
    }
}