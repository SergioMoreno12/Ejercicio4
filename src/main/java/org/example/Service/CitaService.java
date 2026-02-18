package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;

public interface CitaService {

    // Metodo para crear una cita
    Cita crearCita(String paciente, String fecha);

    // Metodo para cambiar el estado de la cita
    boolean cambiarEstado(Cita cita, EstadoCita nuevoEstado);
}