package org.example.Model;

// Esto es una lista fija de opciones
public enum EstadoCita {
    PROGRAMADA, // Cuando recién se crea
    CANCELADA,  // Si el paciente no puede ir
    ATENDIDA    // Cuando ya pasó al médico
}