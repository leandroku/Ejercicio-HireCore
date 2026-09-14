package com.Ejercicio.HireCore.Model.State;

import com.Ejercicio.HireCore.Model.Candidato;

public class VerificacionReferencias implements IEstadoCandidato {

    private final String nombre = "VerificacionReferencias";
    private final String siguienteEstadoNombre = "Oferta";

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
        }
    }
}
