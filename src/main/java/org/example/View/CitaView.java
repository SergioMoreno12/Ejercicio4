package org.example.View;

import org.example.Model.Cita;
import java.util.Scanner;

public class CitaView {

    private Scanner teclado;

    public CitaView() {
        this.teclado = new Scanner(System.in);
    }

    // Metodo para mostrar el menu
    public int mostrarMenuYPedirOpcion() {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1.Registrar nueva cita");
        System.out.println("2.Listar todas las citas");
        System.out.println("3.Cambiar estado");
        System.out.println("4.Eliminar una cita");
        System.out.println("5.Salir");
        System.out.print(">> Elige una opción: ");

        int opcion = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer
        return opcion;
    }

    // Métodos para pedir datos específicos
    public String pedirDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return teclado.nextLine();
    }

    public Long pedirId(String mensaje) {
        System.out.print(mensaje + ": ");
        Long id = teclado.nextLong();
        teclado.nextLine(); // Limpiar buffer
        return id;
    }

    public int pedirOpcionEstado() {
        System.out.println("1. PROGRAMADA | 2. CANCELADA | 3. ATENDIDA");
        System.out.print("Elige el nuevo estado: ");
        int op = teclado.nextInt();
        teclado.nextLine();
        return op;
    }

    // Métodos para mostrar resultados
    public void mostrarMensaje(String mensaje) {
        System.out.println(">> SISTEMA: " + mensaje);
    }

    public void mostrarCita(Cita cita) {
        System.out.println("ID: " + cita.getId() + " | " + cita.getNombrePaciente() + " | " + cita.getEstado());
    }
}