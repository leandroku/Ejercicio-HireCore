package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Contratado implements IEstadoCandidato {

    private final String nombre = "Contratado";
    private final String siguienteEstadoNombre = null;

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeAvanzar(IEstadoCandidato nuevoEstado) {
        return false;
    }

    @Override
    public void avanzar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        System.out.println("El candidato ya está contratado.");
    }
}
