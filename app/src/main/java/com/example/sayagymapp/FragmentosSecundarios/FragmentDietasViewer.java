package com.example.sayagymapp.FragmentosSecundarios;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sayagymapp.ClasesSecundarias.Comida;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A fragment representing a list of Items.
 */
public class FragmentDietasViewer extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ArrayList<Comida> comidas;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentDietasViewer() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentDietasViewer newInstance(int columnCount) {
        FragmentDietasViewer fragment = new FragmentDietasViewer();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dietas_viewer_list, container, false);
        comidas = EnsambladorDietas();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyDietasRecyclerViewAdapter(comidas));
        }
        return view;
    }
    public ArrayList<Comida> EnsambladorDietas(){
        ArrayList<Comida> regresar = new ArrayList<Comida>();
        ArrayList<HashMap> comidasCodificadas = DataBaseConector.ObtenerDietas();
        for(HashMap m:comidasCodificadas){
            Object[] valores = m.values().toArray();
            Comida item = new Comida(valores[0].toString(),valores[1].toString());
            regresar.add(item);
        }
        return regresar;
    }
}