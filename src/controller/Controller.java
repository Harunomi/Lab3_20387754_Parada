package controller;
import java.util.ArrayList;

import model.*;

public class Controller {
    
    // attributes

    private Socialnetwork socialnetwork;

    // methods

    public Controller(Socialnetwork redSocial){
        this.socialnetwork = redSocial;
    }

    public Socialnetwork getSocialnetwork() {
        return socialnetwork;
    }

    public void setSocialnetwork(Socialnetwork socialnetwork) {
        this.socialnetwork = socialnetwork;
    }
    
    // methods

    public boolean estaConectado(){
        Socialnetwork actual = getSocialnetwork();
        return actual.isOnline();
    }
    
    // register

    public void register(String username, String password){
        Socialnetwork redSocial = getSocialnetwork();
        for (int i = 0; i < redSocial.getUsuarios().size(); i++) {
            // verificar si el usuario ya existe en la red social
            if(redSocial.getUsuarios().get(i).getUsername().equals(username)){
               System.out.println("El username ingresado ya existe en la red social");
               return;
            }
        }
        User nuevoUsuario = new User(username,password);
        redSocial.addUsuario(nuevoUsuario);
        System.out.println("Usuario registrado con exito");
    }

    public void login(String username, String password){
        Socialnetwork redSocial = getSocialnetwork();
        for (int i = 0; i < redSocial.getUsuarios().size(); i++) {
            // buscamos al usuario
            if (redSocial.getUsuarios().get(i).getUsername().equals(username) && redSocial.getUsuarios().get(i).getPassword().equals(password)){
                // Establecer al usuario como conectado
                redSocial.setUsuarioOnline(redSocial.getUsuarios().get(i));
                redSocial.setOnline(true);
                return;
            }
        }
        System.out.println("El usuario " + username + "no existe o la contrasena ingresada es incorrecta");
    }

    public void logOut(){
        Socialnetwork redSocial = getSocialnetwork();
        redSocial.setOnline(false);

    }

    public void post(String type, String content){
        Socialnetwork redSocial = getSocialnetwork();
        // creamos la publicacion
        Post newPost = new Post(type,content);
        newPost.setAutor(redSocial.getUsuarioOnline());
        // agregamos la pregunta a la red social
        redSocial.addPostRS(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        redSocial.getUsuarioOnline().getPublicaciones().add(newPost);
        System.out.println("Post protocol completed succesfully");

    }

    public void post(String type, String content,ArrayList<String> listaTags){
        Socialnetwork redSocial = getSocialnetwork();
        Integer counter = 0;
        // verificamos que los etiquetados existan en la red social
        for (int i = 0; i < listaTags.size(); i++) {
            for (int j = 0; j < redSocial.getUsuarios().size(); j++) {
                if (redSocial.getUsuarios().get(j).getUsername().equals(listaTags.get(i))) {
                    counter++;
                }
            }
        }
        // comprobamos que todos los usuarios etiquetados existan en la red social
        if (counter!=listaTags.size()) {
            System.out.println("Uno o mas de los usuarios etiquetados no existe, intentelo nuevamente");
            return;
        }
        // creamos la publicacion
        Post newPost = new Post(type,content,listaTags);
        newPost.setAutor(redSocial.getUsuarioOnline());
        // agregamos la pregunta a la red social
        redSocial.addPostRS(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        redSocial.getUsuarioOnline().getPublicaciones().add(newPost);
        System.out.println("Post protocol completed succesfully");

    }

    public void follow(String username){
        Socialnetwork redSocial = getSocialnetwork();
        // revisamos el caso en que el usuario se quiera seguir a si mismo
        if (redSocial.getUsuarioOnline().getUsername().equals(username)){
            System.out.println("Lo sentimos, pero el usuario no se puede seguir a si mismo!");
            return;
        }
        for (int i = 0; i < redSocial.getUsuarios().size(); i++) {
            if (redSocial.getUsuarios().get(i).getUsername().equals(username)) {
                redSocial.getUsuarios().get(i).addFollowers(redSocial.getUsuarioOnline());
                System.out.println("El usuario "+username+" ha sido seguido con exito!");
                return;
            }
        }
        System.out.println("El usuario ingresado no existe!");


    }
    // caso en que el usuario no quiera etiquetar a nadie
    public void share(Integer id){
        Socialnetwork redSocial = getSocialnetwork();
        // buscamos si la publicacion existe
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                // encontramos la publicacion, por lo que se copia
                Post sharedPost = new Post(redSocial.getPublicaciones().get(i).getTipo(),redSocial.getPublicaciones().get(i).getTexto());
                sharedPost.setAutor(redSocial.getUsuarioOnline());
                // a la publicacion original le agrego el usuario que la compartio
                redSocial.getPublicaciones().get(i).addShared(redSocial.getUsuarioOnline());
                // agrego la nueva publciacion a la red social y al usuario en cuestion
                redSocial.addPostRS(sharedPost);
                redSocial.getUsuarioOnline().addUserPost(sharedPost);
                System.out.println("Publicacion compartida con exito!");
                return;
            }
        }
        System.out.println("La publicacion con la ID "+id+" no fue encontrada en la red social :(");
    }

    

    // caso en que el usuario haya etiquetado a personas
    public void share(Integer id,ArrayList<String> listaTags){
        Socialnetwork redSocial = getSocialnetwork();
        Integer counter = 0;
        // verificamos que los etiquetados existan en la red social
        for (int i = 0; i < listaTags.size(); i++) {
            for (int j = 0; j < redSocial.getUsuarios().size(); j++) {
                if (redSocial.getUsuarios().get(j).getUsername().equals(listaTags.get(i))) {
                    counter++;
                }
            }
        }
        // comprobamos que todos los usuarios etiquetados existan en la red social
        if (counter!=listaTags.size()) {
            System.out.println("Uno o mas de los usuarios etiquetados no existe, intentelo nuevamente");
            return;
        }
        // buscamos si la publicacion existe
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                // encontramos la publicacion, por lo que se copia
                Post sharedPost = new Post(redSocial.getPublicaciones().get(i).getTipo(),redSocial.getPublicaciones().get(i).getTexto(),listaTags);
                sharedPost.setAutor(redSocial.getUsuarioOnline());
                // a la publicacion original le agrego el usuario que la compartio
                redSocial.getPublicaciones().get(i).addShared(redSocial.getUsuarioOnline());
                // agrego la nueva publciacion a la red social y al usuario en cuestion
                redSocial.addPostRS(sharedPost);
                redSocial.getUsuarioOnline().addUserPost(sharedPost);
                System.out.println("Publicacion compartida con exito!");
                return;
            }
        }
        System.out.println("La publicacion con la ID "+id+" no fue encontrada en la red social :(");
    }

    public void visualize(){
        Socialnetwork redSocial = getSocialnetwork();
        String salida = redSocial.SocialNetworkToString();
        System.out.println(salida);
    }

    

}
