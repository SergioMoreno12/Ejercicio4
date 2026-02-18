package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;

public class CitaServiceImpl implements CitaService {

    // Esta variable vive en el servicio y recuerda el último número usado
    // Empieza en 1
    private Long contadorId = 1L;

    @Override
    public Cita crearCita(String paciente, String fecha) {
        // 1. Creamos la cita usando el contador actual
        Cita nuevaCita = new Cita(contadorId, paciente, fecha);

        // 2. Aumentamos el contador para la próxima vez (1 -> 2 -> 3...)
        contadorId++;

        return nuevaCita;
    }

    @Override
    public boolean cambiarEstado(Cita cita, EstadoCita nuevoEstado) {
        // REGLA DE NEGOCIO (RNF-02):
        // Si está CANCELADA y quieren pasarla a ATENDIDA -> Error.
        if (cita.getEstado() == EstadoCita.CANCELADA && nuevoEstado == EstadoCita.ATENDIDA) {
            return false; // Retornamos falso avisando que falló
        }

        // Si pasa la validación, cambiamos el estado
        cita.setEstado(nuevoEstado);
        return true;
    }
}