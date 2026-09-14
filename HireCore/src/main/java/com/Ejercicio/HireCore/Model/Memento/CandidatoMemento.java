package com.Ejercicio.HireCore.Model.Memento;

import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;
import java.util.Date;

public class CandidatoMemento {
    private IEstadoCandidato estado;
    private String usuarioId;
    private String nombre;
    private String email;
    private String reclutadorEmail;
    private Date fechaHora;

    public CandidatoMemento(IEstadoCandidato estado, String usuarioId, String nombre, String email, String reclutadorEmail) {
        this.estado = estado;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.email = email;
        this.reclutadorEmail = reclutadorEmail;
        this.fechaHora = new Date();
    }

    public IEstadoCandidato getEstado() { return estado; }
    public String getUsuarioId() { return usuarioId; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getReclutadorEmail() { return reclutadorEmail; }
    public Date getFechaHora() { return fechaHora; }
}