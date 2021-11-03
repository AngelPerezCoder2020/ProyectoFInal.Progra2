package com.example.sayagymapp.FragmentosPrincipales;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sayagymapp.FragmentosSecundarios.FragmentosList.AvancesFragmentViewer;
import com.example.sayagymapp.FragmentosSecundarios.InfoPersonalFragment;
import com.example.sayagymapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public Button Btn1, Btn2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
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
        View view =  inflater.inflate(R.layout.fragment_personal, container, false);
        Btn1 = view.findViewById(R.id.BotonInfoPersonal);
        Btn2 = view.findViewById(R.id.BotonAvances);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentoPersonal,new InfoPersonalFragment()).commit();
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment poner = null;
        int id = v.getId();
        if(id == R.id.BotonInfoPersonal){
            poner = new InfoPersonalFragment();
        }else if(id == R.id.BotonAvances){
            poner = new AvancesFragmentViewer();
        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragmentoPersonal,poner).commit();
    }
}