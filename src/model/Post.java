package model;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Post {
    // attributes
    private static Integer idGlobal = 0;
    private Integer id;
    private String tipo;
    private String texto;
    private String fecha;
    private ArrayList<React> reactions; 
    private ArrayList<Post> comments;
    private ArrayList<Integer> Tags;
    private ArrayList<Integer> Shared;

    // constructor
    public Post(String tipo, String texto,ArrayList<Integer> Tags){
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.tipo = tipo;
        this.texto = texto;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipoFecha.format(tempDate);
        this.reactions = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.Tags = Tags;
        this.Shared = new ArrayList<>();



    }
    // getters y setters
    
    /**
     *
     * @return el id de la publicacion;
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return el tipo de publicacion
     */
    
    public String getTipo() {
        return tipo;
    }
    

    /**
     *
     * @param tipo el tipo de publicacion
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return el texto de la publicacion
     */
    public String getTexto() {
        return texto;
    }
    
    /**
     *
     * @param texto el texto de la publicacion
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
   
    /**
     *
     * @return la fecha de creacion de la publicacion
     */
    public String getFecha() {
        return fecha;
    }   
    
    /**
     *
     * @param fecha la fecha de la publciacion
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     *
     * @return las reacciones de la publicacion
     */

    public ArrayList<React> getReactions() {
        return reactions;
    }
    
    /**
     *
     * @param reactions cambia las reacciones de la publicacion
     */
    public void setReactions(ArrayList<React> reactions) {
        this.reactions = reactions;
    }
    
    /**
     *
     * @return los comentarios de la publicacion
     */
    public ArrayList<Post> getComments() {
        return comments;
    }
    
    /**
     *
     * @return los etiquetados de la publciacion
     */

    public ArrayList<Integer> getTags() {
        return Tags;
    }
    
    /**
     *
     * @return los usuarios que han compartido la publicacion
     */
    public ArrayList<Integer> getShared() {
        return Shared;
    }
    // methods


}
