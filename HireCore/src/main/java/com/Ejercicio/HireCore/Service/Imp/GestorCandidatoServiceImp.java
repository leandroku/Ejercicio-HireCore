package com.Ejercicio.HireCore.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import com.Ejercicio.HireCore.Model.EstadoCandidato;
import com.Ejercicio.HireCore.Model.Entity.Candidato;
import com.Ejercicio.HireCore.Model.Memento.CandidatoMemento;
import com.Ejercicio.HireCore.Model.Observer.CandidatoObserver;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;
import com.Ejercicio.HireCore.Service.Itf.GestorCandidatoServiceItf;

public class GestorCandidatoServiceImp implements GestorCandidatoServiceItf {

    private final List<CandidatoObserver> observadores = new ArrayList<>();

    private final List<CandidatoMemento> historial = new ArrayList<>();

    @Override
    public void suscribir(CandidatoObserver observer) {
        observadores.add(observer);
    }


    @Override
    public void desuscribir(CandidatoObserver observer) {
        observadores.remove(observer);
    }


    @Override
    public void notificar(Candidato candidato, IEstadoCandidato nuevoEstado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificar'");
    }


    @Override
    public void cambiarEstado(Candidato candidato, EstadoCandidato nuevoEstado, String usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstado'");
    }

}
