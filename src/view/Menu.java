package view;

import java.util.Scanner;
import controller.Controller;
import model.*;

public class Menu {
    // attributes
    
    private Controller controlador;

    // constructor

    public Menu(Controller controladorEntrada){
        this.controlador = controladorEntrada;

    }

    public Controller getControlador() {
        return controlador;
    }

    public void setControlador(Controller controlador) {
        this.controlador = controlador;
    }
    
    // methods

    public void ejecutarMenu(){
        Scanner input = new Scanner(System.in);
        boolean salirMenu = false;
        int eleccion;
        String username;
        String password;
        Controller controlador = getControlador();
        while(!salirMenu){
            if(!controlador.)
        }

    }
    
    

}
