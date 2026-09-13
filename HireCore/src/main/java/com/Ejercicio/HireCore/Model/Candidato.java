package com.Ejercicio.HireCore.Model;

// ¡Estos son los imports que faltaban!
import com.Ejercicio.HireCore.Model.State.Aplicado;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public class Candidato {

    private String id;
    private String nombre;
    private String candidatoEmail;
    private String reclutadorEmail;
    private IEstadoCandidato estadoActual;

    // Constructor
    public Candidato(String id, String nombre, String candidatoEmail, String reclutadorEmail) {
        this.id = id;
        this.nombre = nombre;
        this.candidatoEmail = candidatoEmail;
        this.reclutadorEmail = reclutadorEmail;
        this.estadoActual = new Aplicado(); // Aquí ya encontrará la clase Aplicado
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCandidatoEmail() {
        return candidatoEmail;
    }

    public String getReclutadorEmail() {
        return reclutadorEmail;
    }

    public IEstadoCandidato getEstadoActual() {
        return estadoActual;
    }

    // Setters
    public void setEstadoActual(IEstadoCandidato nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCandidatoEmail(String email) {
        this.candidatoEmail = email;
    }

    public void setReclutadorEmail(String email) {
        this.reclutadorEmail = email;
    }

    // ==========================================
    // CÓDIGO PARA EL PATRÓN MEMENTO (Faltaba)
    // ==========================================
    public CandidatoMemento crearMemento() {
        return new CandidatoMemento(this.estadoActual, this.id, this.nombre, this.candidatoEmail, this.reclutadorEmail);
    }

    public void restaurarMemento(CandidatoMemento memento) {
        this.estadoActual = memento.getEstado();
        this.nombre = memento.getNombre();
        this.candidatoEmail = memento.getEmail();
        this.reclutadorEmail = memento.getReclutadorEmail();
    }

    // Clase interna para el Memento
    public static class CandidatoMemento {

        private IEstadoCandidato estado;
        private String usuarioId;
        private String nombre;
        private String email;
        private String reclutadorEmail;

        public CandidatoMemento(IEstadoCandidato estado, String usuarioId, String nombre, String email, String reclutadorEmail) {
            this.estado = estado;
            this.usuarioId = usuarioId;
            this.nombre = nombre;
            this.email = email;
            this.reclutadorEmail = reclutadorEmail;
        }

        public IEstadoCandidato getEstado() {
            return estado;
        }

        public String getUsuarioId() {
            return usuarioId;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEmail() {
            return email;
        }

        public String getReclutadorEmail() {
            return reclutadorEmail;
        }
    }
}
