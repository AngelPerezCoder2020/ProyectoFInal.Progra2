package com.example.sayagymapp.ClasesSecundarias;

public class RegistroComida {
    private String fecha;
    private Boolean Desayuno,MeriendaAM, Almuerzo, MeriendaPM,Cena;
    public RegistroComida(){

    }
    public RegistroComida(String fecha,Boolean Desayuno,Boolean MeriendaAM,Boolean Almuerzo,Boolean MeriendaPM,Boolean Cena){
        this.fecha = fecha;
        this.Desayuno = Desayuno;
        this.MeriendaAM = MeriendaAM;
        this.Almuerzo = Almuerzo;
        this.MeriendaPM = MeriendaPM;
        this.Cena = Cena;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getDesayuno() {
        return Desayuno;
    }

    public void setDesayuno(Boolean desayuno) {
        Desayuno = desayuno;
    }

    public Boolean getMeriendaAM() {
        return MeriendaAM;
    }

    public void setMeriendaAM(Boolean meriendaAM) {
        MeriendaAM = meriendaAM;
    }

    public Boolean getAlmuerzo() {
        return Almuerzo;
    }

    public void setAlmuerzo(Boolean almuerzo) {
        Almuerzo = almuerzo;
    }

    public Boolean getMeriendaPM() {
        return MeriendaPM;
    }

    public void setMeriendaPM(Boolean meriendaPM) {
        MeriendaPM = meriendaPM;
    }

    public Boolean getCena() {
        return Cena;
    }

    public void setCena(Boolean cena) {
        Cena = cena;
    }
}
