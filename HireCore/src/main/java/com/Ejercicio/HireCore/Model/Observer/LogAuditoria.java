package com.Ejercicio.HireCore.Model.Observer;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public class LogAuditoria implements Observador {

    @Override
    public void actualizar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        System.out.println("[LOG] " + new java.util.Date() + " - Candidato "
                + candidato.getId() + " pasó a: " + nuevoEstado.getNombre());
    }
}
