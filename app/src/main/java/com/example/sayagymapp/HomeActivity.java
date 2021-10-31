package com.example.sayagymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button BtnFragPersonal,BtnFragCouch,BtnFragNutri;
    FloatingActionButton btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("SAYA-GYM");
        btnSalir = findViewById(R.id.SalirBtn);
        BtnFragPersonal = findViewById(R.id.BtnFragPersonal);
        BtnFragCouch = findViewById(R.id.BtnFragCouch);
        BtnFragNutri = findViewById(R.id.BtnFragNutri);
        BtnFragCouch.setOnClickListener(this);
        BtnFragNutri.setOnClickListener(this);
        BtnFragPersonal.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorActivity2,new CouchFragment()).commit();
        btnSalir.setOnClickListener(view->{
            FirebaseAuth.getInstance().signOut();
            finish();
        });
    }

    @Override
    public void onClick(View v) {
        Fragment poner = null;
        int id = v.getId();
        switch(id){
            case R.id.BtnFragCouch:
                poner = new CouchFragment();
                break;
            case R.id.BtnFragPersonal:
                poner = new PersonalFragment();
                break;
            case R.id.BtnFragNutri:
                poner = new NutricionFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorActivity2,poner).commit();
    }
}