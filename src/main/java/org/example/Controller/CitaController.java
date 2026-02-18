package org.example.Controller;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.View.CitaView;

public class CitaController {

    private final CitaService service;
    private final CitaView view;

    // Constructor
    public CitaController(CitaService service, CitaView view) {
        this.service = service;
        this.view = view;
    }

    public Cita crearCita(String paciente, String fecha) {
        Cita cita = service.crearCita(paciente, fecha);
        // Le pedimos a la vista que confirme
        view.mostrarMensaje("¡Cita creada! Se le asignó el ID: " + cita.getId());
        return cita;
    }

    public void cambiarEstado(Cita cita, EstadoCita nuevoEstado) {
        // Intentamos cambiar el estado en el servicio
        boolean exito = service.cambiarEstado(cita, nuevoEstado);

        if (exito) {
            view.mostrarMensaje("Estado actualizado correctamente a: " + nuevoEstado);
        } else {
            view.mostrarMensaje("ERROR: Regla violada. No se puede atender una cita cancelada.");
        }
    }

    public void mostrarCita(Cita cita){
        view.mostrarCita(cita);
    }
}