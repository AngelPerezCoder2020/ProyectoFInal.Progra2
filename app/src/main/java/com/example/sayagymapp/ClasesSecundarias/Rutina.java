package com.example.sayagymapp.ClasesSecundarias;

public class Rutina{
    private String nombre, Ejercicio1, Ejercicio2, Ejercicio3,Ejercicio4,Ejercicio5;

    public Rutina(String nombre, String ejercicio1, String ejercicio2, String ejercicio3, String ejercicio4, String ejercicio5) {
        this.nombre = nombre;
        Ejercicio1 = ejercicio1;
        Ejercicio2 = ejercicio2;
        Ejercicio3 = ejercicio3;
        Ejercicio4 = ejercicio4;
        Ejercicio5 = ejercicio5;
    }
    public Rutina(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEjercicio1() {
        return Ejercicio1;
    }

    public void setEjercicio1(String ejercicio1) {
        Ejercicio1 = ejercicio1;
    }

    public String getEjercicio2() {
        return Ejercicio2;
    }

    public void setEjercicio2(String ejercicio2) {
        Ejercicio2 = ejercicio2;
    }

    public String getEjercicio3() {
        return Ejercicio3;
    }

    public void setEjercicio3(String ejercicio3) {
        Ejercicio3 = ejercicio3;
    }

    public String getEjercicio4() {
        return Ejercicio4;
    }

    public void setEjercicio4(String ejercicio4) {
        Ejercicio4 = ejercicio4;
    }

    public String getEjercicio5() {
        return Ejercicio5;
    }

    public void setEjercicio5(String ejercicio5) {
        Ejercicio5 = ejercicio5;
    }
}