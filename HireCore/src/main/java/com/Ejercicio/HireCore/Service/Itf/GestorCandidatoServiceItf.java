package com.Ejercicio.HireCore.Service.Itf;

import com.Ejercicio.HireCore.Model.EstadoCandidato;
import com.Ejercicio.HireCore.Model.Entity.Candidato;
import com.Ejercicio.HireCore.Model.Observer.CandidatoObserver;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;

public interface GestorCandidatoServiceItf {

    void suscribir(CandidatoObserver observer);

    void desuscribir(CandidatoObserver observer);

    void notificar(Candidato candidato,IEstadoCandidato nuevoEstado);

    void cambiarEstado(Candidato candidato,EstadoCandidato nuevoEstado,String usuario);

}
