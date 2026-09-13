package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class VerificacionReferencias implements IEstadoCandidato {

    @Override
    public String getNombre() {
        return "VerificacionReferencias";
    }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) {
        return "Oferta".equalsIgnoreCase(nuevoEstado);
    }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(new Oferta());
            System.out.println("✅ Candidato avanzó a Oferta.");
        }
    }
}
