package com.Ejercicio.HireCore.Model.Entity;

import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public class Candidato {

    private String id;
    private String nombre;
    private String candidatoEmail;
    private String reclutadorEmail;

    private IEstadoCandidato estadoActual;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCandidatoEmail() {
        return candidatoEmail;
    }

    public void setCandidatoEmail(String candidatoEmail) {
        this.candidatoEmail = candidatoEmail;
    }

    public String getReclutadorEmail() {
        return reclutadorEmail;
    }

    public void setReclutadorEmail(String reclutadorEmail) {
        this.reclutadorEmail = reclutadorEmail;
    }

    public IEstadoCandidato getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(IEstadoCandidato estadoActual) {
        this.estadoActual = estadoActual;
    }

}
