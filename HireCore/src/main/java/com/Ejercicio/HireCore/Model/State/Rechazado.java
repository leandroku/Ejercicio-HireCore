package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Rechazado implements IEstadoCandidato {
    @Override
    public String getNombre() { return "Rechazado"; }

    @Override
    public boolean puedeAvanzar(String nuevoEstado) { return false; }

    @Override
    public void avanzar(Candidato candidato, String nuevoEstado) {
        System.out.println("⚠️ El candidato ha sido rechazado.");
    }
}