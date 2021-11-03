package com.example.sayagymapp.FragmentosSecundarios.Adaptadores;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayagymapp.ClasesSecundarias.Avance;
import com.example.sayagymapp.R;

import java.util.ArrayList;
public class MyItemAvancesViewAdapter extends RecyclerView.Adapter<MyItemAvancesViewAdapter.ViewHolder> {

    private final ArrayList<Avance> mValues;

    public MyItemAvancesViewAdapter(ArrayList<Avance> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_avances_viewer, parent, false);
        return new MyItemAvancesViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombre.setText(holder.mItem.getNombre());
        holder.mEdad.setText(holder.mItem.getEdad());
        holder.mPesoInicial.setText(holder.mItem.getPeso_inicial());
        holder.mPesoMeta.setText(holder.mItem.getPeso_meta());
        holder.mhombros.setText(holder.mItem.getHombros());
        holder.mPecho.setText(holder.mItem.getPecho());
        holder.mCintura.setText(holder.mItem.getCintura());
        holder.mAntebrazo.setText(holder.mItem.getAntebrazos());
        holder.mMuslo.setText(holder.mItem.getMuslo());
        holder.mPantorrila.setText(holder.mItem.getPantorrilla());
        holder.mBiceps.setText(holder.mItem.getBiceps());
        holder.mGluteos.setText(holder.mItem.getGluteos());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitulo,mNombre,mEdad,mPesoInicial,mPesoMeta,
        mhombros,mPecho,mCintura,mAntebrazo,mMuslo,mPantorrila,mBiceps,
        mGluteos;
        public Avance mItem;

        public ViewHolder(View view) {
            super(view);
            mTitulo = view.findViewById(R.id.titulo);
            mNombre = view.findViewById(R.id.nombre);
            mEdad = view.findViewById(R.id.edad);
            mPesoInicial = view.findViewById(R.id.pesoinicial);
            mPesoMeta = view.findViewById(R.id.pesometa);
            mhombros = view.findViewById(R.id.hombros);
            mPecho = view.findViewById(R.id.pecho);
            mCintura = view.findViewById(R.id.cintura);
            mAntebrazo = view.findViewById(R.id.antebrazo);
            mMuslo = view.findViewById(R.id.muslo);
            mPantorrila = view.findViewById(R.id.pantorrilla);
            mBiceps = view.findViewById(R.id.biceps);
            mGluteos = view.findViewById(R.id.gluteo);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitulo.getText() + "'";
        }
    }
}