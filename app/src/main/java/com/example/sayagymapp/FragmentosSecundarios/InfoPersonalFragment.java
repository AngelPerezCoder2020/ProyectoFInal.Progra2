package com.example.sayagymapp.FragmentosSecundarios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayagymapp.ActivitiesPrincipales.HomeActivity;
import com.example.sayagymapp.ClasesSecundarias.Avance;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoPersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoPersonalFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button Btn1, Btn2;
    private TextView nombre,edad,pesoinicial,pesometa,hombros,pecho,cintura,antebrazos,muslo,pantorrillas,biceps,gluteos;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoPersonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoPersonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoPersonalFragment newInstance(String param1, String param2) {
        InfoPersonalFragment fragment = new InfoPersonalFragment();
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
        View view = inflater.inflate(R.layout.fragment_info_personal, container, false);
        nombre = view.findViewById(R.id.nombretext);
        edad = view.findViewById(R.id.edadtext);
        pesoinicial = view.findViewById(R.id.pesoinicialtext);
        pesometa = view.findViewById(R.id.pesometatext);
        hombros = view.findViewById(R.id.hombrostext);
        pecho = view.findViewById(R.id.pechotext);
        cintura = view.findViewById(R.id.cinturatext);
        antebrazos = view.findViewById(R.id.antebrazostext);
        muslo = view.findViewById(R.id.muslotext);
        pantorrillas = view.findViewById(R.id.pantorrillatext);
        biceps = view.findViewById(R.id.bicepstext);
        gluteos = view.findViewById(R.id.gluteostext);
        Btn1 = view.findViewById(R.id.nuevoavancebutton);
        Btn2 = view.findViewById(R.id.registraravancebutton);
        ocultarTextView();
        Btn2.setOnClickListener(this);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarTextView();
            }
        });
        return view;
    }

    public void ocultarTextView(){
        nombre.setEnabled(false);
        edad.setEnabled(false);
        pesoinicial.setEnabled(false);
        pesometa.setEnabled(false);
        hombros.setEnabled(false);
        pecho.setEnabled(false);
        cintura.setEnabled(false);
        antebrazos.setEnabled(false);
        muslo.setEnabled(false);
        pantorrillas.setEnabled(false);
        biceps.setEnabled(false);
        gluteos.setEnabled(false);
        Btn2.setEnabled(false);
    }
    public void MostrarTextView(){
        Btn2.setEnabled(true);
        nombre.setEnabled(true);
        edad.setEnabled(true);
        pesoinicial.setEnabled(true);
        pesometa.setEnabled(true);
        hombros.setEnabled(true);
        pecho.setEnabled(true);
        cintura.setEnabled(true);
        antebrazos.setEnabled(true);
        muslo.setEnabled(true);
        pantorrillas.setEnabled(true);
        biceps.setEnabled(true);
        gluteos.setEnabled(true);
        Btn2.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if(nombre.getText().toString().equals("")
                || edad.getText().toString().equals("")
                || pesoinicial.getText().toString().equals("")
                || pesometa.getText().toString().equals("")
                || hombros.getText().toString().equals("")
                || pecho.getText().toString().equals("")
                || cintura.getText().toString().equals("")
                || antebrazos.getText().toString().equals("")
                || muslo.getText().toString().equals("")
                || pantorrillas.getText().toString().equals("")
                || biceps.getText().toString().equals("")
                || gluteos.getText().toString().equals("")){
            Toast.makeText(getActivity(),"LLENE TODOS LOS DATOS SOLICITADOS",Toast.LENGTH_LONG).show();

        }else{
            ArrayList<Avance> ListaActual = DataBaseConector.avancesTransformador();
            Avance avance = new Avance("Nombre:  "+nombre.getText().toString(),
                    "Edad:  "+edad.getText().toString(),
                    "Peso Inicial:  "+pesoinicial.getText().toString(),
                    "Peso Meta:  "+pesometa.getText().toString(),
                    "Hombros:  "+hombros.getText().toString(),
                    "Pecho:  "+pecho.getText().toString(),
                    "Cintura:  "+cintura.getText().toString(),
                    "AnteBrazo:  "+antebrazos.getText().toString(),
                    "Muslo:  "+muslo.getText().toString(),
                    "Pantorrilla:  "+pantorrillas.getText().toString(),
                    "Biceps:  "+biceps.getText().toString(),
                    "Gluteos:  "+gluteos.getText().toString());
            ListaActual.add(avance);
            Toast.makeText(getActivity(),"El avance fué registrado exitosamente",Toast.LENGTH_LONG).show();
            DataBaseConector.guardarUsuario(ListaActual,DataBaseConector.AsistencíasTransformador(),HomeActivity.EmailIngresado);
            DataBaseConector.ObtenerReferencia(getActivity(),HomeActivity.EmailIngresado);
            ocultarTextView();
            LimpiarTextView();
        }
    }
    public void LimpiarTextView(){
        nombre.setText("");
        edad.setText("");
        pesoinicial.setText("");
        pesometa.setText("");
        hombros.setText("");
        pecho.setText("");
        cintura.setText("");
        antebrazos.setText("");
        muslo.setText("");
        pantorrillas.setText("");
        biceps.setText("");
        gluteos.setText("");
    }
}