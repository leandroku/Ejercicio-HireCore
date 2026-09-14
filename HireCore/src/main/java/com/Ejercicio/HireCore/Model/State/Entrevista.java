package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Entrevista implements IEstadoCandidato {
    @Override
    public String getNombre() { return "Entrevista"; }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) {
        return "PruebaTecnica".equalsIgnoreCase(nuevoEstado);
    }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(new PruebaTecnica());
            System.out.println("✅ Candidato avanzó a Prueba Técnica.");
        }
    }
}