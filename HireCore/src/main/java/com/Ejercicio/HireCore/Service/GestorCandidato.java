package com.Ejercicio.HireCore.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.Memento.CandidatoMemento;
import com.Ejercicio.HireCore.Model.Observer.Observador;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

@Service
public class GestorCandidato {

    private final List<Observador> observadores = new ArrayList<>();
    private final Stack<CandidatoMemento> historial = new Stack<>();

    public void suscribir(Observador observador) {
        observadores.add(observador);
    }

    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    // Método notificar recibe IEstadoCandidato como en el diagrama
    public void notificar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        for (Observador obs : observadores) {
            obs.actualizar(candidato, nuevoEstado);
        }
    }

    public void cambiarEstado(Candidato candidato, IEstadoCandidato nuevoEstado) {
        guardarHistorial(candidato);
        candidato.getEstadoActual().avanzar(candidato, nuevoEstado);
        notificar(candidato, candidato.getEstadoActual());
    }

    // Método guardarHistorial debe recibir Candidato
    public void guardarHistorial(Candidato candidato) {
        historial.push((CandidatoMemento) candidato.crearMemento("sistema")); // usuario "sistema" por defecto
    }

    public void deshacerCambio(Candidato candidato) {
        if (!historial.isEmpty()) {
            CandidatoMemento memento = historial.pop();
            candidato.restaurarMemento(memento);
            System.out.println("Estado restaurado a: " + candidato.getEstadoActual().getNombre());
        } else {
            System.out.println("No hay historial para restaurar.");
        }
    }
}
