package org.example.Model;

public class Cita {

    // Atributos privados
    private Long id;
    private String nombrePaciente;
    private String fecha;
    private EstadoCita estado; // Usamos el Enum aquí

    // Constructor vacío
    public Cita() {

    }

    // Constructor para crear la cita nueva
    // No pedimos el estado porque siempre inicia en "PROGRAMADA"
    public Cita(Long id, String nombrePaciente, String fecha) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.estado = EstadoCita.PROGRAMADA; // Valor por defecto
    }

    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    // El toString para imprimir bonito en la consola
    @Override
    public String toString() {
        return "Cita #" + id + " | Paciente: " + nombrePaciente + " | Estado: " + estado;
    }
}