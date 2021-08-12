package model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class User {
    // attributes
    private static Integer idGlobal = 0;
    private Integer id;
    private String username;
    private String password;
    private String fecha;
    private ArrayList<User> followers;
    private ArrayList<Post> publicaciones;

    // constructor
    public User(String username, String password){
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.username = username;
        this.password = password;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.followers = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
        
    }
    // setters y getters

    /**
     *
     * @return La id del usuario
     */
    public int getId() {
        return id;
    }
    /**
     *
     * @param id La id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *
     * @return El nombre de usuario
     */
    public String getUsername() {
        return username;
    }
    /**
     *
     * @param username el nombre del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     *
     * @return La contraseña del usuario
     */
    public String getPassword() {
        return password;
    }
    /**
     *
     * @param password La contraseña
     */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     *
     * @return La fecha de creacion del usuario
     */

    public String getFecha() {
        return fecha;
    }
    /**
     *
     * @return followers del usuario
     */
    
    public ArrayList<User> getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers nuevos followers del usuario
     */

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    /**
     *
     * @return publicaciones del usuario
     */

    public ArrayList<Post> getPublicaciones() {
        return publicaciones;
    }
    /**
     *
     * @param publicaciones publicaciones del usuario
     */

    public void setPublicaciones(ArrayList<Post> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    
    // --------------------methods-----------------------
    /**
     * agrega un seguidor a la lista de seguidores
     * @param follower
     */
    public void addFollowers(User follower){
        ArrayList<User> list = getFollowers();
        list.add(follower);
        setFollowers(list);
    }
    /**
     * Agrega una publicacion a la lista de publicaciones del usuario
     * @param publicacion
     */
    public void addUserPost(Post publicacion){
        ArrayList<Post> list = getPublicaciones();
        list.add(publicacion);
        setPublicaciones(list);

    }

}
