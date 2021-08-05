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
    private Integer UsuarioOnline;

    Socialnetwork(String nombre){
        this.nombre = nombre;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.usuarios = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
        this.reacts = new ArrayList<>();
        this.UsuarioOnline = 0;

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
    public Integer getUsuarioOnline() {
        return UsuarioOnline;
    }

    /**
     *
     * @param usuarioOnline cambia el usuario online en la red social
     */
    public void setUsuarioOnline(Integer usuarioOnline) {
        UsuarioOnline = usuarioOnline;
    }
    


}
