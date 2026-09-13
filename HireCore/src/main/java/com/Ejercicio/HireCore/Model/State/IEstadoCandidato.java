package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public interface IEstadoCandidato {
    String getNombre();
    boolean puedeAvanzar(String nuevoEstado);
    void avanzar(Candidato candidato, String nuevoEstado);
}