package com.example.sayagymapp.ActivitiesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sayagymapp.ClasesSecundarias.Asistencia;
import com.example.sayagymapp.ClasesSecundarias.Avance;
import com.example.sayagymapp.ClasesSecundarias.RegistroComida;
import com.example.sayagymapp.DataBaseConectorPackage.DataBaseConector;
import com.example.sayagymapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button InicioSecionBtn, RegistrarseBtn;
    public static TextView EmailTxt, Passwordtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InicioSecionBtn = findViewById(R.id.InicioSecionButton);
        RegistrarseBtn = findViewById(R.id.RegistrarseButton);
        EmailTxt = findViewById(R.id.EmailTextView);
        Passwordtxt = findViewById(R.id.PasswordTextView);
        setTitle("INICIO DE SECIÓN");
        InicioSecionBtn.setOnClickListener(this);
        RegistrarseBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(!EmailTxt.getText().toString().isEmpty()&&!Passwordtxt.getText().toString().isEmpty()){
            ingresar(v);
        }else{
            Toast.makeText(this,"Debe Ingresar Todos los datos Solicitados",Toast.LENGTH_LONG).show();
        }

    }
    public void ingresar(View v){
        int id = v.getId();
        if(id == R.id.RegistrarseButton){
            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(EmailTxt.getText().toString(),Passwordtxt.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                ArrayList<RegistroComida> comidasStart = new ArrayList<>();
                                comidasStart.add(new RegistroComida("Fecha: ---",false,false,false,false,false));
                                ArrayList<Avance> Base = new ArrayList<Avance>();
                                Base.add(new Avance("Nombre:  ---","Edad:  ---","Peso Inicial:  ---","Peso Meta:  ---","Hombros:  ---","Pecho:  ---","Cintura:  ---","AnteBrazo:  ---","Muslo:  ---","Pantorrilla:  ---","Biceps:  ---","Gluteos:  ---"));
                                ArrayList<Asistencia> AsistenciasPredeterminada = new ArrayList<Asistencia>();
                                AsistenciasPredeterminada.add(new Asistencia("Hora Entrada:  ---","Hora Salida:  ---","Rutina Realizada:  ---","Fecha Asistida:  ---"));
                                DataBaseConector.guardarUsuario(Base,
                                        AsistenciasPredeterminada,
                                        comidasStart,
                                        LoginActivity.EmailTxt.getText().toString());
                                Home_ActivityStart();
                            }else{
                                Error();
                            }
                        }
                    });
        }else if(id == R.id.InicioSecionButton){
            FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(EmailTxt.getText().toString(),Passwordtxt.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Home_ActivityStart();
                            }else{
                                Error();
                            }
                        }
                    });
        }
    }
    public void Home_ActivityStart(){
        Intent abrir = new Intent(this,Splash_Bienvenida.class);
        abrir.putExtra("Email",EmailTxt.getText().toString());
        startActivity(abrir);
        EmailTxt.setText("");Passwordtxt.setText("");
    }
    public void Error(){
        new AlertDialog.Builder(this).setTitle("ERROR").setMessage("Ah Ocurrido un error al autenticar al Usuario").setPositiveButton("OK",null).show();
    }

}