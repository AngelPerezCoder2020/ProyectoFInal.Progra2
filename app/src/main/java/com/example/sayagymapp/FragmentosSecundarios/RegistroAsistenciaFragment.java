package com.example.sayagymapp.FragmentosSecundarios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayagymapp.ActivitiesPrincipales.HomeActivity;
import com.example.sayagymapp.ActivitiesPrincipales.RegistrosActivity;
import com.example.sayagymapp.ClasesSecundarias.Asistencia;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.FragmentosSecundarios.Adaptadores.AsistenciaListViewAdapter;
import com.example.sayagymapp.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistroAsistenciaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroAsistenciaFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView Fecha, horainicio,horasalida,rutinahecha;
    private Button Btn1, Btn2;
    private RecyclerView AsistenciaReciclerView;
    private ArrayList<Asistencia> ListaDeAsistencias = new ArrayList<Asistencia>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistroAsistenciaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroAsistenciaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroAsistenciaFragment newInstance(String param1, String param2) {
        RegistroAsistenciaFragment fragment = new RegistroAsistenciaFragment();
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
        ListaDeAsistencias = DataBaseConector.AsistencíasTransformador();
        View view = inflater.inflate(R.layout.fragment_registro_asistencia, container, false);
        Fecha = view.findViewById(R.id.FechaText);
        horainicio = view.findViewById(R.id.horainiciotext);
        horasalida = view.findViewById(R.id.horasalidatext);
        rutinahecha = view.findViewById(R.id.rutinahechatext);
        Btn1 = view.findViewById(R.id.registrarbutton);
        Btn2 = view.findViewById(R.id.actualizarbutton);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorActivityTres, new RegistroAsistenciaFragment()).commit();
            }
        });
        Btn2.setEnabled(false);
        AsistenciaReciclerView = view.findViewById(R.id.AsistenciaReciclerView);
        AsistenciaReciclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AsistenciaReciclerView.setAdapter(new AsistenciaListViewAdapter(ListaDeAsistencias));
        return view;
    }

    @Override
    public void onClick(View v) {
        if(horainicio.getText().toString().equals("")
            ||horainicio.getText().toString().equals("")
            ||horasalida.getText().toString().equals("")
            ||rutinahecha.getText().toString().equals("")){
            Toast.makeText(getActivity(),"LLENE TODOS LOS DATOS SOLICITADOS",Toast.LENGTH_LONG).show();
        }else{
            ArrayList<Asistencia> ListaActual = DataBaseConector.AsistencíasTransformador();
            Asistencia nuevaAsitencia = new Asistencia("Hora Entrada:  "+horainicio.getText().toString(),"Hora Salida:  "+horasalida.getText().toString(),"Rutina Realizada:  "+rutinahecha.getText().toString(),"Fecha Asistida:  "+Fecha.getText().toString());
            ListaActual.add(nuevaAsitencia);
            Toast.makeText(getActivity(),"La Asistencia fué registrada exitosamente",Toast.LENGTH_LONG).show();
            DataBaseConector.guardarUsuario(DataBaseConector.avancesTransformador(),ListaActual, HomeActivity.EmailIngresado);
            DataBaseConector.ObtenerReferencia(getActivity(),HomeActivity.EmailIngresado);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Btn2.setEnabled(true);
        }
    }
}