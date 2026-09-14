package com.Ejercicio.HireCore;

import org.junit.jupiter.api.Test;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.Observer.LogAuditoria;
import com.Ejercicio.HireCore.Model.Observer.NotificadorCorreo;
import com.Ejercicio.HireCore.Model.State.Entrevista;
import com.Ejercicio.HireCore.Model.State.PruebaTecnica;
import com.Ejercicio.HireCore.Service.GestorCandidato;

class HireCoreApplicationTests {

    @Test
    void probarTodo() {
        System.out.println("\n--- INICIANDO PRUEBA ---");

        GestorCandidato gestor = new GestorCandidato();
        gestor.suscribir(new NotificadorCorreo());
        gestor.suscribir(new LogAuditoria());

        Candidato candidato = new Candidato("C001", "Ana Gomez", "ana@test.com", "rrhh@test.com");
        System.out.println("Estado inicial: " + candidato.getEstadoActual().getNombre());

        // Avanzar usando OBJETOS de estado, como pide el diagrama
        gestor.cambiarEstado(candidato, new Entrevista());
        gestor.cambiarEstado(candidato, new PruebaTecnica());

        // Retroceder
        System.out.println("\n--- Retrocediendo (deshacerCambio) ---");
        gestor.deshacerCambio(candidato);

        System.out.println("\n--- FIN DE LA PRUEBA ---\n");
    }
}
