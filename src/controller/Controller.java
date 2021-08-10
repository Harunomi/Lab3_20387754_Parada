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
}
