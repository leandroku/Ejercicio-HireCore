package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Aplicado implements IEstadoCandidato {
    @Override
    public String getNombre() { return "Aplicado"; }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) {
        return "Entrevista".equalsIgnoreCase(nuevoEstado);
    }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(new Entrevista());
            System.out.println("✅ Candidato avanzó a Entrevista.");
        } else {
            System.out.println("❌ Transición no permitida desde Aplicado.");
        }
    }
}