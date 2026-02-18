package org.example;

import org.example.Controller.CitaController;
import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.Service.CitaServiceImpl;
import org.example.View.CitaView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instancias
        CitaService servicio = new CitaServiceImpl();
        CitaView vista = new CitaView();
        CitaController controlador = new CitaController(servicio, vista);

        // Variables auxiliares
        Scanner teclado = new Scanner(System.in);
        // Lista de citas
        ArrayList<Cita> listaDeCitas = new ArrayList<>();
        int opcion = 0;

        System.out.println("==========================================");
        System.out.println("      CONSULTORIO MÉDICO - SISTEMA V1.0   ");
        System.out.println("==========================================");

        // Ciclo del menu
        do {
            System.out.println("MENÚ PRINCIPAL:");
            System.out.println("1.Registrar nueva cita");
            System.out.println("2.Listar todas las citas");
            System.out.println("3.Cambiar estado (Prog/Canc/Aten)");
            System.out.println("4.Eliminar una cita");
            System.out.println("5.Salir");
            System.out.print("Elige una opción: ");

            // Leemos el numero
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiamos el 'Enter' del buffer

            switch (opcion) {
                case 1: // REGISTRAR
                    System.out.println("--- REGISTRAR CITA ---");
                    System.out.print("Nombre del Paciente: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Fecha de la cita (ej. 20/02/2026): ");
                    String fecha = teclado.nextLine();

                    // Llamamos al controller (él se encarga del ID automático)
                    Cita nuevaCita = controlador.crearCita(nombre, fecha);

                    // Guardamos la cita en la lista
                    listaDeCitas.add(nuevaCita);
                    break;

                case 2: // LISTAR
                    System.out.println("--- LISTADO ---");
                    if (listaDeCitas.isEmpty()) {
                        System.out.println("No hay citas registradas todavía.");
                    } else {
                        // Recorremos la lista una por una
                        for (Cita c : listaDeCitas) {
                            controlador.mostrarCita(c);
                        }
                    }
                    break;

                case 3: // CAMBIAR ESTADO
                    System.out.println("--- CAMBIAR ESTADO ---");
                    System.out.print("Ingresa el ID de la cita: ");
                    long idBusqueda = teclado.nextLong();
                    teclado.nextLine(); // Limpiar buffer

                    // Buscamos la cita manualmente en la lista
                    Cita citaEncontrada = null;
                    for (Cita c : listaDeCitas) {
                        if (c.getId() == idBusqueda) {
                            citaEncontrada = c;
                            break; // Encontrada, deja de buscar
                        }
                    }

                    if (citaEncontrada != null) {
                        System.out.println("Cita seleccionada de: " + citaEncontrada.getNombrePaciente());
                        System.out.println("1. PROGRAMADA | 2. CANCELADA | 3. ATENDIDA");
                        System.out.print("Elige el nuevo estado: ");
                        int opEstado = teclado.nextInt();

                        // Convertimos el número 1,2,3 al Enum correspondiente
                        if (opEstado == 1) controlador.cambiarEstado(citaEncontrada, EstadoCita.PROGRAMADA);
                        else if (opEstado == 2) controlador.cambiarEstado(citaEncontrada, EstadoCita.CANCELADA);
                        else if (opEstado == 3) controlador.cambiarEstado(citaEncontrada, EstadoCita.ATENDIDA);
                        else System.out.println("Opción inválida.");

                    } else {
                        System.out.println("Error: ID no encontrado.");
                    }
                    break;

                case 4: // ELIMINAR
                    System.out.println("--- ELIMINAR CITA ---");
                    System.out.print("Ingresa el ID de la cita a borrar: ");
                    long idBorrar = teclado.nextLong();
                    teclado.nextLine();

                    Cita citaBorrar = null;
                    // Mismo ciclo de búsqueda
                    for (Cita c : listaDeCitas) {
                        if (c.getId() == idBorrar) {
                            citaBorrar = c;
                            break;
                        }
                    }

                    if (citaBorrar != null) {
                        listaDeCitas.remove(citaBorrar); // Esto saca el objeto de la lista
                        System.out.println("Cita eliminada del sistema.");
                    } else {
                        System.out.println("Error: ID no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}