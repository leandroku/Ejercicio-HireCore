package com.Ejercicio.HireCore.Model;

import com.Ejercicio.HireCore.Model.Memento.CandidatoMemento; // <-- IMPORTANTE
import com.Ejercicio.HireCore.Model.State.Aplicado;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public class Candidato {

    private String id;
    private String nombre;
    private String candidatoEmail;
    private String reclutadorEmail;
    private IEstadoCandidato estadoActual;

    public Candidato(String id, String nombre, String candidatoEmail, String reclutadorEmail) {
        this.id = id;
        this.nombre = nombre;
        this.candidatoEmail = candidatoEmail;
        this.reclutadorEmail = reclutadorEmail;
        this.estadoActual = new Aplicado();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return candidatoEmail;
    }

    public String getReclutadorEmail() {
        return reclutadorEmail;
    }

    public IEstadoCandidato getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(IEstadoCandidato nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.candidatoEmail = email;
    }

    public void setReclutadorEmail(String email) {
        this.reclutadorEmail = email;
    }

    public CandidatoMemento crearMemento(String usuario) {
        return new CandidatoMemento(this.estadoActual, usuario, new java.util.Date());
    }

    public void restaurarMemento(CandidatoMemento memento) {
        this.estadoActual = memento.getEstado();
    }
}
