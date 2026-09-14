package com.Ejercicio.HireCore.Model.Observer;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public class NotificadorCorreo implements Observador {

    @Override
    public void actualizar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        System.out.println("[CORREO] Enviando a " + candidato.getEmail()
                + ": Su estado cambió a " + nuevoEstado.getNombre());
    }
}
