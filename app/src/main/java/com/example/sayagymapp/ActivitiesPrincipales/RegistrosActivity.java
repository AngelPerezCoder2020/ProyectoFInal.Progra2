package com.example.sayagymapp.ActivitiesPrincipales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sayagymapp.FragmentosSecundarios.RegistroAsistenciaFragment;
import com.example.sayagymapp.FragmentosSecundarios.TiemposDeComidaFragment;
import com.example.sayagymapp.R;

public class RegistrosActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Btn1, Btn2, Btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        setTitle("ASISTENCIA");
        Btn1 = findViewById(R.id.AsistenciaButton);
        Btn2 = findViewById(R.id.TiemposDeComidaButton);
        Btn3 = findViewById(R.id.ExitButton);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorActivityTres, new RegistroAsistenciaFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        Fragment poner = null;
        int id = v.getId();
        if(id == R.id.AsistenciaButton){
            setTitle("ASISTENCIA");
            poner = new RegistroAsistenciaFragment();
        }else if(id == R.id.TiemposDeComidaButton){
            setTitle("TIEMPOS DE COMIDA");
            poner = new TiemposDeComidaFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorActivityTres,poner).commit();
    }
}