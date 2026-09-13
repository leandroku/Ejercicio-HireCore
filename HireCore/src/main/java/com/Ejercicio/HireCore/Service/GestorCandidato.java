package com.Ejercicio.HireCore.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack; // <-- ESTE ES EL IMPORT CLAVE

import org.springframework.stereotype.Service;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.Candidato.CandidatoMemento;
import com.Ejercicio.HireCore.Model.Observer.CandidatoObserver;

@Service
public class GestorCandidato {

    private List<CandidatoObserver> observadores = new ArrayList<>();
    private Stack<CandidatoMemento> historial = new Stack<>();

    public void suscribir(CandidatoObserver observador) {
        observadores.add(observador);
    }

    public void desuscribir(CandidatoObserver observador) {
        observadores.remove(observador);
    }

    public void notificar(Candidato candidato, String nuevoEstado) {
        for (CandidatoObserver obs : observadores) {
            obs.actualizar(candidato, nuevoEstado);
        }
    }

    public void cambiarEstado(Candidato candidato, String nuevoEstado) {
        guardarHistorial(candidato);
        candidato.getEstadoActual().avanzar(candidato, nuevoEstado);
        notificar(candidato, candidato.getEstadoActual().getNombre());
    }

    public void guardarHistorial(Candidato candidato) {
        historial.push(candidato.crearMemento());
    }

    public void restaurarHistorial(Candidato candidato) {
        if (!historial.isEmpty()) {
            CandidatoMemento memento = historial.pop();
            candidato.restaurarMemento(memento);
            System.out.println("⏪ Estado restaurado a: " + candidato.getEstadoActual().getNombre());
        } else {
            System.out.println("⚠️ No hay historial para restaurar.");
        }
    }
}
