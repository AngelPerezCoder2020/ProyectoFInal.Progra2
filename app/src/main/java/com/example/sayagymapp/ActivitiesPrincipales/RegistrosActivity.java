package com.example.sayagymapp.ActivitiesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sayagymapp.R;

public class RegistrosActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Btn1, Btn2, Btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        setTitle("REGISTROS");
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
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Asies papu",Toast.LENGTH_SHORT).show();
    }
}