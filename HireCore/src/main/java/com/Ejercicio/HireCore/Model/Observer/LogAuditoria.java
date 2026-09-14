package com.Ejercicio.HireCore.Model.Observer;

import com.Ejercicio.HireCore.Model.Candidato;

// Implementación 2: Log de Auditoría
public class LogAuditoria implements CandidatoObserver {
    @Override
    public void actualizar(Candidato candidato, String nuevoEstado) {
        System.out.println("📝 [LOG] " + new java.util.Date() + " - Candidato " +
                candidato.getId() + " pasó a: " + nuevoEstado);
    }
}