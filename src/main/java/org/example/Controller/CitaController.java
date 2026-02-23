package org.example.Controller;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.View.CitaView;
import java.util.ArrayList;

public class CitaController {

    private final CitaService service;
    private final CitaView view;
    private ArrayList<Cita> listaDeCitas;

    public CitaController(CitaService service, CitaView view) {
        this.service = service;
        this.view = view;
        this.listaDeCitas = new ArrayList<>();
    }

    // ESTE ES EL METODO PRINCIPAL
    public void iniciar() {
        int opcion = 0;
        view.mostrarMensaje("BIENVENIDO AL SISTEMA DE CITAS");

        do {
            // Le pedimos a la vista que muestre el menú y nos devuelva qué eligió el usuario
            opcion = view.mostrarMenuYPedirOpcion();

            switch (opcion) {
                case 1: registrarCita(); break;
                case 2: listarCitas(); break;
                case 3: cambiarEstado(); break;
                case 4: eliminarCita(); break;
                case 5: view.mostrarMensaje("¡Hasta luego!"); break;
                default: view.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 5);
    }

    //Métodos privados para organizar el código

    private void registrarCita() {
        String nombre = view.pedirDato("Nombre del Paciente");
        String fecha = view.pedirDato("Fecha de la cita");
        Cita nuevaCita = service.crearCita(nombre, fecha);
        listaDeCitas.add(nuevaCita);
        view.mostrarMensaje("Cita creada con ID " + nuevaCita.getId());
    }

    private void listarCitas() {
        if (listaDeCitas.isEmpty()) {
            view.mostrarMensaje("No hay citas.");
        } else {
            for (Cita c : listaDeCitas) {
                view.mostrarCita(c);
            }
        }
    }

    private void cambiarEstado() {
        Long id = view.pedirId("Ingresa el ID de la cita");
        Cita cita = buscarCita(id);

        if (cita != null) {
            int op = view.pedirOpcionEstado();
            EstadoCita nuevoEstado = null;
            if (op == 1) nuevoEstado = EstadoCita.PROGRAMADA;
            else if (op == 2) nuevoEstado = EstadoCita.CANCELADA;
            else if (op == 3) nuevoEstado = EstadoCita.ATENDIDA;

            if (nuevoEstado != null) {
                boolean exito = service.cambiarEstado(cita, nuevoEstado);
                if (exito) view.mostrarMensaje("Estado actualizado.");
                else view.mostrarMensaje("ERROR: No se puede atender una cita cancelada.");
            }
        } else {
            view.mostrarMensaje("Cita no encontrada.");
        }
    }

    private void eliminarCita() {
        Long id = view.pedirId("Ingresa el ID a borrar");
        Cita cita = buscarCita(id);
        if (cita != null) {
            listaDeCitas.remove(cita);
            view.mostrarMensaje("Cita eliminada.");
        } else {
            view.mostrarMensaje("Cita no encontrada.");
        }
    }

    private Cita buscarCita(Long id) {
        for (Cita c : listaDeCitas) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }
}