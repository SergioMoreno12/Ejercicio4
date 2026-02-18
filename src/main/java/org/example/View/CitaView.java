package org.example.View;

import org.example.Model.Cita;

public class CitaView {

    public void mostrarCita(Cita cita){
        System.out.println("----------------------------------------");
        System.out.println("ID Cita: " + cita.getId());
        System.out.println("Paciente: " + cita.getNombrePaciente());
        System.out.println("Fecha: " + cita.getFecha());
        System.out.println("Estado: " + cita.getEstado());
        System.out.println("----------------------------------------");
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(">> SISTEMA: " + mensaje);
    }
}