package com.example.sayagymapp;

import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.AEADBadTagException;

public class DataBaseConector {
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static ArrayList<Rutina> Rutinas = new ArrayList<Rutina>();
    public static ArrayList<Comida> Dieta = new ArrayList<Comida>();
    public static void guardarUsuario(){
        Map<String, Object> map = new HashMap<>();
        map.put("Couch","");
        db.collection("Usuarios").document(LoginActivity.EmailTxt.getText().toString()).set(map);
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
        Rutinas.add(new Rutina("4x10 Press Plano","4x10 Press Inclinado","4x10 Press Plano Mancuernas","4x10 Press Inclinado Mancuernas","4X10 Despechadas"));
        Rutinas.add(new Rutina("4X10 Curl Biceps Mancuerna","4X10 Martillo","4X10 Curl Biceos Barra","4X10 Predicador","4X10 Curl Biceps con Maquina"));
        Rutinas.add(new Rutina("4x10 Maquina1","4x10 Maquina2","4x10 Maquina3","4x10 Remo","4x10 Serrucho"));
        Rutinas.add(new Rutina("4X10 Triceps Junto","4X10 Triceps Individual","4X10 Jalon con Cuerda","4X10 Jalon con UVE","4X10 Jalon con Barra"));
        Rutinas.add(new Rutina("4X10 Desplantes","4X10 Mounstruo","4X10 Sentadillas","4X10 Maquina Sentado","4X10 Maquina Acostado"));
        Rutinas.add(new Rutina("4X10 Hombros con Mancuerna","4X10 Levantamiento Vertical","4X10 Levantamiento Horizontal","4X10 Levantamiento Con Maquina","4X10 Levantamiento con Barra"));
        Dieta.add(new Comida("Pan integral con tomate y aguacate."));
        Dieta.add(new Comida("Un yogur con un puñado de nueces."));
        Dieta.add(new Comida("Ensalada completa de pimientos, tomate, cebolla, garbanzos y huevo duro."));
        Dieta.add(new Comida("Leche con avena. Una pera."));
        Dieta.add(new Comida("Plato de col con patata, Lenguado a la plancha."));
    }
    public static FirestoreRecyclerOptions ObtenerEntrenadores(){
        Query query = db.collection("Couches");
        FirestoreRecyclerOptions<Couch> estacosa = new FirestoreRecyclerOptions.Builder<Couch>().setQuery(query,Couch.class).build();
        return estacosa;
    }
    public static void EstablecerEntrenador(String couch){
        DocumentReference couchEscogido = db.collection("Couches").document(couch);
        Map<String, Object> map = new HashMap<>();
        map.put("Couch",couchEscogido);
        db.collection("Usuarios").document(HomeActivity.EmailIngresado).set(map);
    }
}