package com.Ejercicio.HireCore.Model.Observer;

import com.Ejercicio.HireCore.Model.Candidato;

// Implementación 1: Notificador de Correo
public class NotificadorCorreo implements CandidatoObserver {
    @Override
    public void actualizar(Candidato candidato, String nuevoEstado) {
        System.out.println("📧 [CORREO] Enviando a " + candidato.getCandidatoEmail() +
                ": Su estado cambió a " + nuevoEstado);
    }
}