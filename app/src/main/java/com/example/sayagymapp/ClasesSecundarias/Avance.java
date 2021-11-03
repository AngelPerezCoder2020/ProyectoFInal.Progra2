package com.example.sayagymapp.ClasesSecundarias;

public class Avance {
    private String nombre,edad, peso_inicial, peso_meta,hombros,pecho, cintura,antebrazos,muslo,pantorrilla,biceps,gluteos;

    public Avance(String nombre, String edad, String peso_inicial, String peso_meta, String hombros, String pecho, String cintura, String antebrazos, String muslo, String pantorrilla, String biceps, String gluteos) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso_inicial = peso_inicial;
        this.peso_meta = peso_meta;
        this.hombros = hombros;
        this.pecho = pecho;
        this.cintura = cintura;
        this.antebrazos = antebrazos;
        this.muslo = muslo;
        this.pantorrilla = pantorrilla;
        this.biceps = biceps;
        this.gluteos = gluteos;
    }
    public Avance(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(String peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public String getPeso_meta() {
        return peso_meta;
    }

    public void setPeso_meta(String peso_meta) {
        this.peso_meta = peso_meta;
    }

    public String getHombros() {
        return hombros;
    }

    public void setHombros(String hombros) {
        this.hombros = hombros;
    }

    public String getPecho() {
        return pecho;
    }

    public void setPecho(String pecho) {
        this.pecho = pecho;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getAntebrazos() {
        return antebrazos;
    }

    public void setAntebrazos(String antebrazos) {
        this.antebrazos = antebrazos;
    }

    public String getMuslo() {
        return muslo;
    }

    public void setMuslo(String muslo) {
        this.muslo = muslo;
    }

    public String getPantorrilla() {
        return pantorrilla;
    }

    public void setPantorrilla(String pantorrilla) {
        this.pantorrilla = pantorrilla;
    }

    public String getBiceps() {
        return biceps;
    }

    public void setBiceps(String biceps) {
        this.biceps = biceps;
    }

    public String getGluteos() {
        return gluteos;
    }

    public void setGluteos(String gluteos) {
        this.gluteos = gluteos;
    }
}
