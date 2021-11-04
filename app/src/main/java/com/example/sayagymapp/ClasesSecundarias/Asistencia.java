package com.example.sayagymapp.ClasesSecundarias;

import java.util.Date;

public class Asistencia {
    private String horaEntrada, horaSalida, RutinaRealizada;
    private String FechaAsistida;

    public Asistencia(String horaEntrada, String horaSalida, String rutinaRealizada, String fechaAsistida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        RutinaRealizada = rutinaRealizada;
        FechaAsistida = fechaAsistida;
    }
    public Asistencia(){

    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getRutinaRealizada() {
        return RutinaRealizada;
    }

    public void setRutinaRealizada(String rutinaRealizada) {
        RutinaRealizada = rutinaRealizada;
    }

    public String getFechaAsistida() {
        return FechaAsistida;
    }

    public void setFechaAsistida(String fechaAsistida) {
        FechaAsistida = fechaAsistida;
    }
}
