package com.example.sayagymapp.FragmentosSecundarios;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sayagymapp.ActivitiesPrincipales.RegistrosActivity;
import com.example.sayagymapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRegistroDietas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistroDietas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button Btn1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRegistroDietas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegistroDietas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistroDietas newInstance(String param1, String param2) {
        FragmentRegistroDietas fragment = new FragmentRegistroDietas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_dietas, container, false);
        Btn1 = view.findViewById(R.id.abrirRegistrosButtton);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegistrosActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}