package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Oferta implements IEstadoCandidato {
    @Override
    public String getNombre() { return "Oferta"; }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) {
        return "Contratado".equalsIgnoreCase(nuevoEstado);
    }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(new Contratado());
            System.out.println("✅ Candidato avanzó a Contratado.");
        }
    }
}