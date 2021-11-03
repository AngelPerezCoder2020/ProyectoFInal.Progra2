package com.example.sayagymapp.ActivitiesPrincipales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sayagymapp.FragmentosPrincipales.CouchFragment;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.FragmentosPrincipales.NutricionFragment;
import com.example.sayagymapp.FragmentosPrincipales.PersonalFragment;
import com.example.sayagymapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button BtnFragPersonal,BtnFragCouch,BtnFragNutri;
    FloatingActionButton btnSalir;
    public static String EmailIngresado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        EmailIngresado = getIntent().getExtras().getString("Email");
        setTitle("SAYA-GYM");
        btnSalir = findViewById(R.id.SalirBtn);
        BtnFragPersonal = findViewById(R.id.BtnFragPersonal);
        BtnFragCouch = findViewById(R.id.BtnFragCouch);
        BtnFragNutri = findViewById(R.id.BtnFragNutri);
        BtnFragCouch.setOnClickListener(this);
        BtnFragNutri.setOnClickListener(this);
        BtnFragPersonal.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorActivity2,new PersonalFragment()).commit();
        btnSalir.setOnClickListener(view->{
            FirebaseAuth.getInstance().signOut();
            finish();
        });
    }

    @Override
    public void onClick(View v) {
        String Titulo=null;
        Fragment poner = null;
        int id = v.getId();
        switch(id){
            case R.id.BtnFragCouch:
                Titulo = "COUCHING";
                poner = new CouchFragment();
                break;
            case R.id.BtnFragPersonal:
                Titulo = "INFO. PERSONAL";
                poner = new PersonalFragment();
                break;
            case R.id.BtnFragNutri:
                Titulo = "NUTRICION";
                poner = new NutricionFragment();
                break;
        }
        setTitle(Titulo);
        getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorActivity2,poner).commit();
    }
}