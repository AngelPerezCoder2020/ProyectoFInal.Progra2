package com.example.sayagymapp.ClasesSecundarias;

import java.util.ArrayList;
import java.util.List;

public class Couch {
    private String nombre;
    private List<Rutina> Rutinas = new ArrayList<Rutina>();
    private List<Comida> Dietas = new ArrayList<Comida>();

    public Couch(String nombre, ArrayList<Rutina> Rutinas, ArrayList<Comida> Dietas){
        this.Rutinas = Rutinas;
        this.nombre = nombre;
        this.Dietas = Dietas;
    }
    public Couch(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rutina> getRutinas() {
        return Rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        Rutinas = rutinas;
    }

    public List<Comida> getDietas() {
        return Dietas;
    }

    public void setDietas(List<Comida> dietas) {
        Dietas = dietas;
    }
}