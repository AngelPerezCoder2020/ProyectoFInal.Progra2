package com.example.sayagymapp.ClasesSecundarias;

public class Comida {
    private String dieta;
    private String nombre;
    public Comida(String nombre,String dieta){
        this.dieta = dieta;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comida(){

    }
    public void setDieta(String dieta){
        this.dieta = dieta;
    }
    public String getDieta(){
        return dieta;
    }
}
