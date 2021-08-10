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
        if(actual.getUsuarioOnline().getId() > 0){
            return true;
        }else{
            return false;
        }
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
            }
        }

    }
}
