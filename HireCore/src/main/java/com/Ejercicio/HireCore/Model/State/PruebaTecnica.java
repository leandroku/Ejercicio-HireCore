package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class PruebaTecnica implements IEstadoCandidato {
    @Override
    public String getNombre() { return "PruebaTecnica"; }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) {
        return "VerificacionReferencias".equalsIgnoreCase(nuevoEstado);
    }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(new VerificacionReferencias());
            System.out.println("✅ Candidato avanzó a Verificación de Referencias.");
        }
    }
}