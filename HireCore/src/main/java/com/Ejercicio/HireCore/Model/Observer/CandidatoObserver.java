package com.Ejercicio.HireCore.Model.Observer;

import com.Ejercicio.HireCore.Model.Candidato;

// Interfaz Observer
public interface CandidatoObserver {
    void actualizar(Candidato candidato, String nuevoEstado);
}