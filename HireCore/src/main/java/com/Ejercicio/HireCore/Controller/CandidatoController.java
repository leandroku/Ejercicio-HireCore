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
import com.Ejercicio.HireCore.Model.State.Aplicado;
import com.Ejercicio.HireCore.Model.State.Contratado;
import com.Ejercicio.HireCore.Model.State.Entrevista;
import com.Ejercicio.HireCore.Model.State.IEstadoCandidato;
import com.Ejercicio.HireCore.Model.State.Oferta;
import com.Ejercicio.HireCore.Model.State.PruebaTecnica;
import com.Ejercicio.HireCore.Model.State.Rechazado;
import com.Ejercicio.HireCore.Model.State.VerificacionReferencias;
import com.Ejercicio.HireCore.Service.GestorCandidato;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private GestorCandidato gestorCandidato;

    private final List<Candidato> baseDatos = new ArrayList<>();

    public CandidatoController() {
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

    // Ahora recibe el nombre del estado y lo convierte en objeto IEstadoCandidato
    @PutMapping("/{id}/avanzar")
    public String avanzarEstado(@PathVariable String id, @RequestParam String nuevoEstado) {
        Candidato candidato = buscarCandidato(id);
        if (candidato == null) {
            return "Candidato no encontrado";
        }

        IEstadoCandidato estadoObj = obtenerEstadoPorNombre(nuevoEstado);
        if (estadoObj == null) {
            return "Estado no válido: " + nuevoEstado;
        }

        gestorCandidato.cambiarEstado(candidato, estadoObj);
        return "Estado actual: " + candidato.getEstadoActual().getNombre();
    }

    @PutMapping("/{id}/retroceder")
    public String retrocederEstado(@PathVariable String id) {
        Candidato candidato = buscarCandidato(id);
        if (candidato == null) {
            return "Candidato no encontrado";
        }

        gestorCandidato.deshacerCambio(candidato);
        return "Estado restaurado a: " + candidato.getEstadoActual().getNombre();
    }

    private Candidato buscarCandidato(String id) {
        return baseDatos.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    // Método auxiliar para crear el objeto de estado a partir del nombre
    private IEstadoCandidato obtenerEstadoPorNombre(String nombre) {
        return switch (nombre) {
            case "Aplicado" ->
                new Aplicado();
            case "Entrevista" ->
                new Entrevista();
            case "PruebaTecnica" ->
                new PruebaTecnica();
            case "VerificacionReferencias" ->
                new VerificacionReferencias();
            case "Oferta" ->
                new Oferta();
            case "Contratado" ->
                new Contratado();
            case "Rechazado" ->
                new Rechazado();
            default ->
                null;
        };
    }
}
