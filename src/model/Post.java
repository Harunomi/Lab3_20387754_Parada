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
     * @return comments cambia los etiquetados
     */
    public ArrayList<Post> getComments() {
        return comments;
    }

    /**
     *
     * @param comments cambia los etiquetados
     */
    public void setComments(ArrayList<Post> comments) {
        this.comments = comments;
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
     * @param tags cambia los etiquetados
     */
    public void setTags(ArrayList<Integer> tags) {
        Tags = tags;
    }

    /**
     *
     * @return los usuarios que han compartido la publicacion
     */
    public ArrayList<Integer> getShared() {
        return Shared;
    }

    /**
     *
     * @param shared cambia la lista de los usuarios que han compartido
     */
    public void setShared(ArrayList<Integer> shared) {
        Shared = shared;
    }

    // methods
    public void addReact(React reaccion){
        ArrayList<React> list = getReactions();
        list.add(reaccion);
        setReactions(list);
    }

    public void addComment(Post comentario){
        ArrayList<Post> list = getComments();
        list.add(comentario);
        setComments(list);
    }

    public void addTag(Integer etiquetado){
        ArrayList<Integer> list = getTags();
        list.add(etiquetado);
        setTags(list);
        
    }

    public void addShared(Integer compartido){
        ArrayList<Integer> list = getShared();
        list.add(compartido);
        setShared(list);
    }

}
