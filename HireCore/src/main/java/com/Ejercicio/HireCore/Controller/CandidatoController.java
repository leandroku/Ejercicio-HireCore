package com.Ejercicio.HireCore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ejercicio.HireCore.Model.Candidato;
import com.Ejercicio.HireCore.Model.Observer.LogAuditoria;
import com.Ejercicio.HireCore.Model.Observer.NotificadorCorreo;
import com.Ejercicio.HireCore.Service.GestorCandidato;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController { // <-- Ojo: "Controller" con C mayúscula

    @Autowired
    private GestorCandidato gestorCandidato;

    private final List<Candidato> baseDatos = new ArrayList<>();

    public CandidatoController() {
        // Ahora Java sabrá que NotificadorCorreo y LogAuditoria SÍ son CandidatoObserver
        gestorCandidato.suscribir(new NotificadorCorreo());
        gestorCandidato.suscribir(new LogAuditoria());
    }

    @PostMapping("/crear")
    public Candidato crearCandidato(@RequestParam String id, @RequestParam String nombre,
            @RequestParam String email, @RequestParam String reclutadorEmail) {
        Candidato nuevo = new Candidato(id, nombre, email, reclutadorEmail);
        baseDatos.add(nuevo);
        return nuevo;
    }

    @PutMapping("/{id}/avanzar")
    public String avanzarEstado(@PathVariable String id, @RequestParam String nuevoEstado) {
        Candidato candidato = buscarCandidato(id);
        if (candidato == null) {
            return "Candidato no encontrado";
        }

        gestorCandidato.cambiarEstado(candidato, nuevoEstado);
        return "Estado actual: " + candidato.getEstadoActual().getNombre();
    }

    @PutMapping("/{id}/retroceder")
    public String retrocederEstado(@PathVariable String id) {
        Candidato candidato = buscarCandidato(id);
        if (candidato == null) {
            return "Candidato no encontrado";
        }

        gestorCandidato.restaurarHistorial(candidato);
        return "Estado restaurado a: " + candidato.getEstadoActual().getNombre();
    }

    private Candidato buscarCandidato(String id) {
        return baseDatos.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
