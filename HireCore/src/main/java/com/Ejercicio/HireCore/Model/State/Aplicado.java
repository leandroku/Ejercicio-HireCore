package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class Aplicado implements IEstadoCandidato {

    private final String nombre = "Aplicado";
    private final String siguienteEstadoNombre = "Entrevista";

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeAvanzar(IEstadoCandidato nuevoEstado) {
        return nuevoEstado != null && nuevoEstado.getNombre().equalsIgnoreCase(siguienteEstadoNombre);
    }

    @Override
    public void avanzar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        if (puedeAvanzar(nuevoEstado)) {
            candidato.setEstadoActual(nuevoEstado);
            System.out.println("Candidato avanzó a " + nuevoEstado.getNombre());
        } else {
            System.out.println("No puede avanzar de " + nombre + " a " + (nuevoEstado != null ? nuevoEstado.getNombre() : "null"));
        }
    }
}
