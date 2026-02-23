package org.example;

import org.example.Controller.CitaController;
import org.example.Service.CitaService;
import org.example.Service.CitaServiceImpl;
import org.example.View.CitaView;

public class Main {
    public static void main(String[] args) {

        // 1.Crear las piezas
        CitaService service = new CitaServiceImpl();
        CitaView view = new CitaView();

        // 2.Unir las piezas en el controlador
        CitaController controller = new CitaController(service, view);

        // 3.Arranca
        controller.iniciar();
    }
}