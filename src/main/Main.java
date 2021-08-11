package main;

import controller.Controller;
import model.Socialnetwork;
import view.Menu;



public class Main {
    public static void main(String[] args){
        Socialnetwork redSocial = new Socialnetwork("LMAOBOOK");

        Controller controlador = new Controller(redSocial);

        Menu menu = new Menu(controlador);

        menu.ejecutarMenu();

    }
    
}
