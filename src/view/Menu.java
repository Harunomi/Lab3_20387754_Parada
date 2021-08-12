package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.Controller;

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
            if(controlador.estaConectado() == false){
                System.out.println("### Bienvenido a Tik Tok ###");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. LOGEARSE");
                System.out.println("2. REGISTRARSE");
                System.out.println("3. VER RED SOCIAL");
                System.out.println("4. SALIR");

                try {
                    System.out.println("Introduzca su eleccion: ");
                    eleccion = input.nextInt();
                    switch (eleccion){
                        case 1:
                            System.out.println("Su opcion fue la numero 1: logearse en la red social");
                            System.out.println("Ingrese el nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese la contrasena para el usuario " + username);
                            password = input.nextLine();
                            controlador.login(username,password);
                            break;
                        case 2:
                            System.out.println("Su opcion fue la numero 2: registrarse en la red social");
                            System.out.println("Ingrese el nombre de usuario: ");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese una contrasena para crear sesion: ");
                            password = input.nextLine();
                            controlador.register(username,password);
                            break;
                        case 3:
                            System.out.println("Su opcion fue la numero 3: Ver el contenido de la red social");
                            controlador.visualize();
                            break;
                        case 4:
                            System.out.println("Gracias por utilizar esta red social");
                            salirMenu = true;
                            input.close();
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
                System.out.println("7. Cerrar sesion en la red social");

                try{
                    System.out.println("Ingrese una de las opciones anteriores: ");
                    eleccion = input.nextInt();
                    switch(eleccion){
                        case 1: // post
                            System.out.println("Ingrese el tipo de publicacion que desea realizar: ");
                            input.nextLine();
                            String tipoPost = input.nextLine();
                            System.out.println("Ingrese el contenido de la publicacion: ");
                            String contenidoPost = input.nextLine();
                            controlador.post(tipoPost, contenidoPost);
                            break;
                        case 2: // follow
                            System.out.println("Ingrese el nombre del usuario el cual desea seguir");
                            input.nextLine();
                            username = input.nextLine();
                            controlador.follow(username);
                            break;
                        case 3: // share
                            System.out.println("Ingrese la ID de la publicacion que desea compartir");
                            Integer idACompartir = input.nextInt();
                            ArrayList<String> listaTags = new ArrayList<>();                            
                            System.out.println("Ingrese la cantidad de etiquetados que desea que tenga la pubblicacion compartida:");
                            int cantTags = input.nextInt();
                            String tag;
                            System.out.println("Cantidad de etiquetados seleccionada: "+cantTags);
                            for (int i = 0; i < cantTags; i++) {
                                System.out.println("Ingrese el etiquetado numero "+ (i+1));
                                input.nextLine();
                                tag = input.nextLine();
                                listaTags.add(tag);
                                
                            }
                            // discriminamos el caso en que haya etiquetados o no
                            if (cantTags == 0) {
                                controlador.share(idACompartir);
                            }else{
                                controlador.share(idACompartir,listaTags);
                            }
                            
                            break;
                        case 4: // visualize / ver perfil
                            controlador.visualize();
                            break;
                        case 5: // comment
                            System.out.println("Ingrese la ID de la publicacion o comentario la cual desea comentar:");
                            input.nextLine();
                            Integer idComentario = input.nextInt();
                            System.out.println("Ingrese el contenido del comentario:");
                            input.nextLine();
                            String contenidoComentario = input.nextLine();
                            controlador.comment(idComentario, contenidoComentario);
                            break;
                        case 6: // react (multiples reacciones, no solo un like)
                            System.out.println("Ingrese la ID de la publicacion o comentario la cual desea agregar una reaccion");
                            input.nextLine();
                            Integer idReaccion = input.nextInt();
                            System.out.println("Ingrese el tipo de reaccion (puede ser del tipo: like, haha, angry, sad, love)");
                            input.nextLine();
                            String tipoReaccion = input.nextLine();
                            System.out.println("Ingrese el texto que desea que lleve la reaccion: ");
                            String textoReaccion = input.nextLine();
                            controlador.react(idReaccion,tipoReaccion,textoReaccion);
                            break;
                        case 7: // logout
                            controlador.logOut();
                            break;

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
