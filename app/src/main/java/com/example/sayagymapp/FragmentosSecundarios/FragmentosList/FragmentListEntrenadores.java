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

import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.FragmentosSecundarios.Adaptadores.MyItemEntrenadoresViewAdapter;
import com.example.sayagymapp.R;

/**
 * A fragment representing a list of Items.
 */
public class FragmentListEntrenadores extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    MyItemEntrenadoresViewAdapter entrenadores;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentListEntrenadores() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentListEntrenadores newInstance(int columnCount) {
        FragmentListEntrenadores fragment = new FragmentListEntrenadores();
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
        View view = inflater.inflate(R.layout.fragment_list_entrenadores_list, container, false);
        // Set the adapter
        entrenadores = new MyItemEntrenadoresViewAdapter(DataBaseConector.ObtenerEntrenadores(),this);
        entrenadores.notifyDataSetChanged();
        entrenadores.startListening();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(entrenadores);
        }
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        entrenadores.stopListening();
    }
}