package com.Ejercicio.HireCore;

import org.junit.jupiter.api.Test;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Service.GestorCandidato;

// ¡OJO! Quitamos @SpringBootTest
class HireCoreApplicationTests {

    @Test
    void probarTodo() {
        System.out.println("\n--- INICIANDO PRUEBA ---");

        // 1. Crear el gestor
        GestorCandidato gestor = new GestorCandidato();

        // 2. Activar notificaciones (Observer)
        gestor.suscribir(new com.Ejercicio.HireCore.Model.Observer.NotificadorCorreo());
        gestor.suscribir(new com.Ejercicio.HireCore.Model.Observer.LogAuditoria());

        // 3. Crear un candidato
        Candidato candidato = new Candidato("C001", "Ana Gomez", "ana@test.com", "rrhh@test.com");
        System.out.println("Estado inicial: " + candidato.getEstadoActual().getNombre());

        // 4. Avanzar estados (State)
        gestor.cambiarEstado(candidato, "Entrevista");
        gestor.cambiarEstado(candidato, "PruebaTecnica");

        // 5. Retroceder (Memento)
        System.out.println("\n--- Retrocediendo ---");
        gestor.restaurarHistorial(candidato);

        System.out.println("\n--- FIN DE LA PRUEBA ---\n");
    }
}
