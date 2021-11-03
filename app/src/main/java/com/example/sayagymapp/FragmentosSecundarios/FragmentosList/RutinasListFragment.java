package com.example.sayagymapp.FragmentosSecundarios.FragmentosList;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sayagymapp.ClasesSecundarias.Rutina;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.FragmentosSecundarios.Adaptadores.MyRutinasListViewAdapter;
import com.example.sayagymapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A fragment representing a list of Items.
 */
public class RutinasListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ArrayList<Rutina> RutinasG;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RutinasListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RutinasListFragment newInstance(int columnCount) {
        RutinasListFragment fragment = new RutinasListFragment();
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
        View view = inflater.inflate(R.layout.fragment_rutinas_list_list, container, false);
        RutinasG = ConvertidorRutinas();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyRutinasListViewAdapter(RutinasG));
        }
        return view;
    }
    public ArrayList<Rutina> ConvertidorRutinas(){
        ArrayList<Rutina> ensamblado = new ArrayList<>();
        ArrayList<HashMap> aEnsamblar = DataBaseConector.ObtenerRutinas();
        for(HashMap m:aEnsamblar){
            Object[] valores = m.values().toArray();
            Rutina item = new Rutina(valores[5].toString(),valores[1].toString(),valores[2].toString(),valores[3].toString(),valores[4].toString(),valores[0].toString());
            ensamblado.add(item);
        }
        return ensamblado;
    }
}