package com.example.sayagymapp;

public class Comida {
    public String dieta;
    public Comida(String dieta){
        this.dieta = dieta;
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
