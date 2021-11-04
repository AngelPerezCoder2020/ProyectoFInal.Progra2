package com.example.sayagymapp.DataBaseConectorPackage;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.sayagymapp.ActivitiesPrincipales.HomeActivity;
import com.example.sayagymapp.ActivitiesPrincipales.LoginActivity;
import com.example.sayagymapp.ClasesSecundarias.Asistencia;
import com.example.sayagymapp.ClasesSecundarias.Avance;
import com.example.sayagymapp.ClasesSecundarias.Comida;
import com.example.sayagymapp.ClasesSecundarias.Couch;
import com.example.sayagymapp.ClasesSecundarias.Rutina;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseConector {
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static ArrayList<Rutina> Rutinas = new ArrayList<Rutina>();
    public static ArrayList<Comida> Dieta = new ArrayList<Comida>();
    public static ArrayList<Avance> Avances = new ArrayList<Avance>();
    public static ArrayList<HashMap> RutinasObtenidas, DietasObtenidas, AvancesObtenidos, AsistenciasObtenidas;
    public static DocumentReference couchPersonalRef = null;
    public static String couchPersonal = "Nadie :(";
    public static void guardarUsuario(ArrayList<Avance> Avances,ArrayList<Asistencia> Asistencias, String docu){
        Map<String, Object> map = new HashMap<>();
        map.put("Couch",couchPersonalRef);
        map.put("Avances",Avances);
        map.put("Asistencias",Asistencias);
        db.collection("Usuarios").document(docu).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d("BASEDEDATOS","SE ENVIÓ EL USUARIO");
                }else{
                    Log.d("BASEDEDATOS",task.getException().toString());
                }
            }
        });
    }
    public static void RegistrarCouch(){
       llenarListas();
       List<Couch> entrenadores = new ArrayList<Couch>();
       entrenadores.add(new Couch("Dario",Rutinas,Dieta));
       entrenadores.add(new Couch("Angel",Rutinas,Dieta));
       entrenadores.add(new Couch("Luis",Rutinas,Dieta));
       entrenadores.add(new Couch("Victor",Rutinas,Dieta));
       entrenadores.add(new Couch("Roberto",Rutinas,Dieta));
       entrenadores.add(new Couch("Carlos",Rutinas,Dieta));
       entrenadores.add(new Couch("Messi",Rutinas,Dieta));
       entrenadores.add(new Couch("Ronaldo",Rutinas,Dieta));
       for(int x = 0;x<entrenadores.size();x++){
           Map<String, Object> map = new HashMap<>();
           map.put("Dietas",entrenadores.get(x).getDietas());
           map.put("Rutinas",entrenadores.get(x).getRutinas());
           map.put("nombre",entrenadores.get(x).getNombre());
           db.collection("Couches").document(entrenadores.get(x).getNombre()).set(map);
       }
    }
    public static void llenarListas(){
        Rutinas.add(new Rutina("Rutina Pecho","4x10 Press Plano","4x10 Press Inclinado","4x10 Press Plano Mancuernas","4x10 Press Inclinado Mancuernas","4X10 Despechadas"));
        Rutinas.add(new Rutina("Rutina Biceps","4X10 Curl Biceps Mancuerna","4X10 Martillo","4X10 Curl Biceos Barra","4X10 Predicador","4X10 Curl Biceps con Maquina"));
        Rutinas.add(new Rutina("Rutina Espalda","4x10 Maquina1","4x10 Maquina2","4x10 Maquina3","4x10 Remo","4x10 Serrucho"));
        Rutinas.add(new Rutina("Rutina Triceps","4X10 Triceps Junto","4X10 Triceps Individual","4X10 Jalon con Cuerda","4X10 Jalon con UVE","4X10 Jalon con Barra"));
        Rutinas.add(new Rutina("Rutina Pierna","4X10 Desplantes","4X10 Mounstruo","4X10 Sentadillas","4X10 Maquina Sentado","4X10 Maquina Acostado"));
        Rutinas.add(new Rutina("Rutina Hombros","4X10 Hombros con Mancuerna","4X10 Levantamiento Vertical","4X10 Levantamiento Horizontal","4X10 Levantamiento Con Maquina","4X10 Levantamiento con Barra"));
        Dieta.add(new Comida("Desayuno","Pan integral con tomate y aguacate."));
        Dieta.add(new Comida("Media Mañana","Un yogur con un puñado de nueces."));
        Dieta.add(new Comida("Almuerzo","Ensalada completa de pimientos, tomate, cebolla, garbanzos y huevo duro."));
        Dieta.add(new Comida("Refacción","Leche con avena. Una pera."));
        Dieta.add(new Comida("Cena","Plato de col con patata, Lenguado a la plancha."));
    }
    public static FirestoreRecyclerOptions ObtenerEntrenadores(){
        Query query = db.collection("Couches");
        FirestoreRecyclerOptions<Couch> estacosa = new FirestoreRecyclerOptions.Builder<Couch>().setQuery(query,Couch.class).build();
        return estacosa;
    }
    public static void EstablecerEntrenador(String couch){
        couchPersonal = couch;
        DocumentReference couchEscogido = db.collection("Couches").document(couch);
        Map<String, Object> map = new HashMap<>();
        map.put("Couch",couchEscogido);
        map.put("Avances",AvancesObtenidos);
        map.put("Asistencias",AsistenciasObtenidas);
        db.collection("Usuarios").document(HomeActivity.EmailIngresado).set(map);
    }

    public static ArrayList<Rutina> getCouchRutinas(){
        llenarListas();
        return Rutinas;
    }
    public static void ObtenerReferencia(Context cnt, String docu){
        DocumentReference docRef = db.collection("Usuarios").document(docu);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        if(document.getData().get("Couch")==null){
                            RutinasObtenidas = null;
                            DietasObtenidas = null;
                        }else{
                            couchPersonalRef = (DocumentReference)document.getData().get("Couch");
                            GuargarRutinasyDietas(couchPersonalRef);
                        }
                        AvancesObtenidos = (ArrayList<HashMap>) document.getData().get("Avances");
                        AsistenciasObtenidas = (ArrayList<HashMap>) document.getData().get("Asistencias");
                    } else {
                        Toast.makeText(cnt,"El Usuario: "+HomeActivity.EmailIngresado+" no Existe en la base de datos",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(cnt,task.getException().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public static void GuargarRutinasyDietas(DocumentReference ref){
        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        couchPersonal = document.getData().get("nombre").toString();
                        RutinasObtenidas = (ArrayList<HashMap>) document.getData().get("Rutinas");
                        DietasObtenidas = (ArrayList<HashMap>) document.getData().get("Dietas");
                    } else {
                        Log.d("APPLICACION", "No such document");
                    }
                } else {
                    Log.d("APPLICACION", "get failed with ", task.getException());
                }
            }
        });
    }
    public static ArrayList<HashMap> ObtenerRutinas(){
        return RutinasObtenidas;
    }
    public static ArrayList<HashMap> ObtenerDietas(){
        return DietasObtenidas;
    }

    public static ArrayList<Avance> avancesTransformador(){
        ArrayList<Avance> decodificado = new ArrayList<>();
        ArrayList<HashMap> codificados = AvancesObtenidos;
        for(HashMap m:codificados){
            Object[] valores = m.values().toArray();
            Avance item = new Avance(valores[0].toString(),valores[1].toString(),valores[2].toString(),
                    valores[3].toString(),valores[4].toString(),valores[5].toString(),valores[6].toString(),
                    valores[7].toString(),valores[8].toString(),valores[9].toString(),valores[10].toString(),
                    valores[11].toString());
            decodificado.add(item);
        }
        return decodificado;
    }
    public static ArrayList<Asistencia> AsistencíasTransformador(){
        ArrayList<Asistencia> decodificado = new ArrayList<Asistencia>();
        ArrayList<HashMap> codificados = AsistenciasObtenidas;
        for(HashMap m:codificados){
            Object[] valores = m.values().toArray();
            Asistencia item = new Asistencia(valores[0].toString(),valores[1].toString(),valores[2].toString(),
                    valores[3].toString());
            decodificado.add(item);
        }
        return decodificado;
    }
}