package model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


public class Socialnetwork {

    // attributes
    private String nombre;
    private String fecha;
    private ArrayList<User> usuarios;
    private ArrayList<Post> publicaciones;
    private ArrayList<React> reacts;
    private User UsuarioOnline;
    private boolean online;

    public Socialnetwork(String nombre){
        this.nombre = nombre;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.usuarios = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
        this.reacts = new ArrayList<>();
        this.online = false;

        // Se crea nuevos usuarios
        User user1 = new User("Katsugo","uwu123");
        User user2 = new User("Harunomi","password1");
        User user3 = new User("Spica","Cybele");

        // creo las publicaciones
        Post post1 = new Post("text","Explorando la nueva red social");
        Post post2 = new Post("photo","publicacion.jpeg");
        Post post3 = new Post("audio","cover.mp3");

        // agrego las publicaciones a los usuarios
        user2.addUserPost(post1);
        user2.addUserPost(post2);
        user1.addUserPost(post3);

        // agrego los usuarios y publicacion a la red social
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        publicaciones.add(post1);
        publicaciones.add(post2);
        publicaciones.add(post3);


    }
    // getters y setters

    /**
     *
     * @return El nombre de la red social
     */    
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre cambie el nombre de la red social
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return la fecha de creacion de la red social
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha cambia la fecha de la red social
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return los usuarios de la red social
     */
    public ArrayList<User> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios la lista de usuarios
     */
    public void setUsuarios(ArrayList<User> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     *
     * @return la lista de publicaciones
     */
    public ArrayList<Post> getPublicaciones() {
        return publicaciones;
    }

    /**
     *
     * @param publicaciones cambia las publicaciones de la red social
     */
    public void setPublicaciones(ArrayList<Post> publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     *
     * @return las reacciones dentro de la red social
     */
    public ArrayList<React> getReacts() {
        return reacts;
    }

    /**
     *
     * @param reacts cambia las reacciones de la red social
     */
    public void setReacts(ArrayList<React> reacts) {
        this.reacts = reacts;
    }

    /**
     *
     * @return el usuario online
     */
    public User getUsuarioOnline() {
        return UsuarioOnline;
    }

    /**
     *
     * @param usuarioOnline cambia el usuario online en la red social
     */
    public void setUsuarioOnline(User usuarioOnline) {
        UsuarioOnline = usuarioOnline;
    }
    
    
    /**
     *
     * @return true or false
     */
    public boolean isOnline() {
        return online;
    }

    /**
     *
     * @param online true or false si esta online
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    // methods
    public void addUsuario(User usuario){
        ArrayList<User> list = getUsuarios();
        list.add(usuario);
        setUsuarios(list);
        
    }
    
    public void addPostRS(Post publicacion){
        ArrayList<Post> list = getPublicaciones();
        list.add(publicacion);
        setPublicaciones(list);
    }

    public void addReactRS(React reaccion){
        ArrayList<React> list = getReacts();
        list.add(reaccion);
        setReacts(list);
    }

    

}
