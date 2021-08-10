package view;

import java.util.InputMismatchException;
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
            if(controlador.estaConectado() != false){
                System.out.println("### Bienvenido a Tik Tok ###");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. LOGEARSE");
                System.out.println("2. REGISTRARSE");
                System.out.println("3. SALIR");

                try {
                    System.out.println("Introduzca su eleccion: ");
                    eleccion = input.nextInt();
                    switch (eleccion){
                        case 1:
                            System.out.println("Su opcion fue la numero 1: logearse en la red social");
                            System.out.println("Ingrese el nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese la contrasena para el usuario" + username);
                            input.nextLine();
                            password = input.nextLine();
                            controlador.login(username,password);
                            break;
                        case 2:
                            System.out.println("Su opcion fue la numero 2   : registrarse en la red social");
                            System.out.println("Ingrese el nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            input.nextLine();
                            password = input.nextLine();
                            controlador.register(username,password);
                            break;
                        case 3:
                            System.out.println("Gracias por utilizar esta red social");
                            salirMenu = true;
                            break;
                        default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores")    ;
                            break;
                    }

                } catch (InputMismatchException e){
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    input.next();
                }
            }else{
                System.out.println("****Bienvenido a Tik Tok******");
                // agregar el nombre de usuario con el cual te registraste
                System.out.println("Escoje una accion a realizar");
                System.out.println("1. Realizar una publicacion");
                System.out.println("2. Seguir a un usuario");
                System.out.println("3. Compartir una publicacion");
                System.out.println("4. Ver su perfil");
                System.out.println("5. Comentar una publicacion");
                System.out.println("6. Agregar una reaccion a una publicacion");
                System.out.println("7. Ver publicaciones virales");

                try{
                    System.out.println("Ingrese una de las opciones anteriores: ");
                    eleccion = input.nextInt();
                    switch(eleccion){
                        case 1: // post
                            break;
                        case 2: // follow
                            break;
                        case 3: // share
                            break;
                        case 4: // visualize
                            break;
                        case 5: // comment
                            break;
                        case 6: // react (multiples reacciones, no solo un like)
                            break;
                        case 7: // isViral

                        default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    input.next();
                }
            }
        }
    }
}
