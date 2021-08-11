package controller;
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
        // agregamos la pregunta a la red social
        redSocial.addPostRS(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        redSocial.getUsuarioOnline().getPublicaciones().add(newPost);
        System.out.println("Post protocol completed succesfully");

    }

}
