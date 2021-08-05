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
    private int[] followers;
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
        this.followers = new int[1];
        this.publicaciones = new ArrayList<>();
        
    }
    /**
     *
     * @return La id del usuario
     */
    
    public static Integer getIdGlobal() {
        return idGlobal;
    }


    public static void setIdGlobal(Integer idGlobal) {
        User.idGlobal = idGlobal;
    }


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
     * @param fecha la fecha de creacion del usuario
     */

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     *
     * @return los followers del usuario
     */

    public int[] getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers lista de followers del usuario
     */
    public void setFollowers(int[] followers) {
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
    
    
    // methods


}
