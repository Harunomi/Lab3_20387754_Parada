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

    public void actualizarPublicaciones(Post entrada){
        for (int i = 0; i < getPublicaciones().size(); i++) {
            if (getPublicaciones().get(i).getId() == entrada.getId()) {
                this.publicaciones.set(i,entrada);
            }
        }
    }

    public String SocialNetworkToString(){
        String retorno = new String();
        retorno = "Nombre de la red social: " + getNombre() + "\n";
        retorno = retorno + "Fecha de creacion de la red social: " + getFecha() +"\n";
        if (isOnline() == true) {
            // informacion del usuario online
            retorno = retorno + "Usuario online actualmente: " + getUsuarioOnline().getUsername() + "\n";
            retorno = retorno + "Cuenta creada con la fecha de: " + getUsuarioOnline().getFecha() + "\n";
            retorno = retorno + "El usuario " + getUsuarioOnline().getUsername() + " cuenta con " + getUsuarioOnline().getFollowers().size() + " followers, los cuales son:";
            for (int i = 0; i < getUsuarioOnline().getFollowers().size(); i++) {
                retorno = retorno + "\n   " + getUsuarioOnline().getFollowers().get(i);
            }
            retorno = retorno + "\n";
            retorno = retorno + "El usuario cuenta con " + getUsuarioOnline().getPublicaciones().size() + " publicaciones, las cuales son:";
            // publicaciones del usuario
            for (int i = 0; i < getUsuarioOnline().getPublicaciones().size(); i++) {
                retorno = retorno + "\n\n##### Publicacion numero" + (i+1) + " #####\n";
                retorno = retorno + "Publicacion creada con fecha: " + getUsuarioOnline().getPublicaciones().get(i).getFecha() + "\n";
                retorno = retorno + "Tipo de publicacion: " + getUsuarioOnline().getPublicaciones().get(i).getTipo() + "\n";
                retorno = retorno + "Contenido de la publicacion: " + getUsuarioOnline().getPublicaciones().get(i).getTexto() + "\n";
                retorno = retorno + "La publicacion cuenta con " + getUsuarioOnline().getPublicaciones().get(i).getReactions().size() + "\n";
                // reacciones de la publicacion
                for (int j = 0; j < getUsuarioOnline().getPublicaciones().get(i).getReactions().size(); j++) {
                    retorno = retorno + "$$$$ Reaccion numero " + (j+1) + " $$$$\n";
                    retorno = retorno + "Fecha de la reaccion: " + getUsuarioOnline().getPublicaciones().get(i).getReactions().get(j).getFecha() + "\n";
                    retorno = retorno + "Autor de la reaccion: " + getUsuarioOnline().getPublicaciones().get(i).getReactions().get(j).getAutor() + "\n";
                    retorno = retorno + "Tipo de reaccion: " + getUsuarioOnline().getPublicaciones().get(i).getReactions().get(j).getTipo() + "\n";
                    retorno = retorno + "Contenido de la reaccion: " + getUsuarioOnline().getPublicaciones().get(i).getReactions().get(j).getContenido() + "\n";            
                }
                retorno = retorno + "La publicacion actual tiene " + getUsuarioOnline().getPublicaciones().get(i).getComments().size() + " comentarios\n";
                // comentarios de la publicacion
                for (int j = 0; j < getUsuarioOnline().getPublicaciones().get(i).getComments().size(); j++) {
                    retorno = retorno + "     ^^^Comentario numero " + (j+1)+ " ^^^\n";
                    retorno = retorno + "Fecha de creacion del comentario: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getFecha() + "\n";
                    retorno = retorno + "Autor del comentario: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getAutor() + "\n";
                    retorno = retorno + "Tipo de comentario: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getTipo() + "\n";
                    retorno = retorno + "Contenido del comentario: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getTexto() + "\n";
                    retorno = retorno + "El comentario cuenta con otros: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getComments().size() + "comentarios\n";
                    retorno = retorno + "El comentario tiene: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getReactions().size() + "reacciones\n";
                    retorno = retorno + "El comentario tiene: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getTags().size() + " etiquetados\n";
                    retorno = retorno + "Ha sido compartido: " + getUsuarioOnline().getPublicaciones().get(i).getComments().get(j).getShared().size() + " veces\n";
                }
                // Etiquetados de la publicacion
                retorno = retorno + "\nLa publicacion tiene como etiquetados a: ";
                for (int j = 0; j < getUsuarioOnline().getPublicaciones().get(i).getTags().size(); j++) {
                    retorno = retorno + getUsuarioOnline().getPublicaciones().get(i).getTags().get(i) + " ";
                }
                retorno = retorno + "La publicacion ha sido compartida " + getUsuarioOnline().getPublicaciones().get(i).getShared().size() + "veces, por: ";
                for (int j = 0; j < getUsuarioOnline().getPublicaciones().get(i).getShared().size(); j++) {
                    retorno = retorno + getUsuarioOnline().getPublicaciones().get(i).getShared().get(j).getUsername() + " ";
                }
                retorno = retorno + "\n\n";
            }
            
        }else{
            // informacion de toda la red social.
            // comenzando con los usuarios
            retorno = retorno + "*---------Usuarios de la red social----------*\n\n";
            for (int k = 0; k < getUsuarios().size(); k++) {
                retorno = retorno + "Usuario online actualmente: " + getUsuarios().get(k).getUsername() + "\n";
                retorno = retorno + "Cuenta creada con la fecha de: " + getUsuarios().get(k).getFecha() + "\n";
                retorno = retorno + "El usuario " + getUsuarios().get(k).getUsername() + " cuenta con " + getUsuarios().get(k).getFollowers().size() + " followers, los cuales son:";
                for (int i = 0; i < getUsuarios().get(k).getFollowers().size(); i++) {
                    retorno = retorno + "\n   " + getUsuarios().get(k).getFollowers().get(i);
                }
                retorno = retorno + "\n";
                retorno = retorno + "El usuario cuenta con " + getUsuarios().get(k).getPublicaciones().size() + " publicaciones, las cuales son:";
                // publicaciones del usuario
                for (int i = 0; i < getUsuarios().get(k).getPublicaciones().size(); i++) {
                    retorno = retorno + "\n##### Publicacion numero" + (i+1) + " #####\n";
                    retorno = retorno + "Publicacion creada con fecha: " + getUsuarios().get(k).getPublicaciones().get(i).getFecha() + "\n";
                    retorno = retorno + "Tipo de publicacion: " + getUsuarios().get(k).getPublicaciones().get(i).getTipo() + "\n";
                    retorno = retorno + "Contenido de la publicacion: " + getUsuarios().get(k).getPublicaciones().get(i).getTexto() + "\n";
                    retorno = retorno + "La publicacion cuenta con " + getUsuarios().get(k).getPublicaciones().get(i).getReactions().size() + "\n";
                    // reacciones de la publicacion
                    for (int j = 0; j < getUsuarios().get(k).getPublicaciones().get(i).getReactions().size(); j++) {
                        retorno = retorno + "$$$$ Reaccion numero " + (j+1) + " $$$$\n";
                        retorno = retorno + "Fecha de la reaccion: " + getUsuarios().get(k).getPublicaciones().get(i).getReactions().get(j).getFecha() + "\n";
                        retorno = retorno + "Autor de la reaccion: " + getUsuarios().get(k).getPublicaciones().get(i).getReactions().get(j).getAutor() + "\n";
                        retorno = retorno + "Tipo de reaccion: " + getUsuarios().get(k).getPublicaciones().get(i).getReactions().get(j).getTipo() + "\n";
                        retorno = retorno + "Contenido de la reaccion: " + getUsuarios().get(k).getPublicaciones().get(i).getReactions().get(j).getContenido() + "\n";            
                    }
                    retorno = retorno + "La publicacion actual tiene " + getUsuarios().get(k).getPublicaciones().get(i).getComments().size() + " comentarios\n";
                    // comentarios de la publicacion
                    for (int j = 0; j < getUsuarios().get(k).getPublicaciones().get(i).getComments().size(); j++) {
                        retorno = retorno + "     ^^^Comentario numero " + (j+1)+ " ^^^\n";
                        retorno = retorno + "Fecha de creacion del comentario: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getFecha() + "\n";
                        retorno = retorno + "Autor del comentario: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getAutor() + "\n";
                        retorno = retorno + "Tipo de comentario: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getTipo() + "\n";
                        retorno = retorno + "Contenido del comentario: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getTexto() + "\n";
                        retorno = retorno + "El comentario cuenta con otros: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getComments().size() + "comentarios\n";
                        retorno = retorno + "El comentario tiene: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getReactions().size() + "reacciones\n";
                        retorno = retorno + "El comentario tiene: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getTags().size() + " etiquetados\n";
                        retorno = retorno + "Ha sido compartido: " + getUsuarios().get(k).getPublicaciones().get(i).getComments().get(j).getShared().size() + " veces\n";
                    }
                    // Etiquetados de la publicacion
                    retorno = retorno + "\nLa publicacion tiene como etiquetados a: ";
                    for (int j = 0; j < getUsuarios().get(k).getPublicaciones().get(i).getTags().size(); j++) {
                        retorno = retorno + getUsuarios().get(k).getPublicaciones().get(i).getTags().get(i) + " ";
                    }
                    retorno = retorno + "La publicacion ha sido compartida " + getUsuarios().get(k).getPublicaciones().get(i).getShared().size() + "veces, por: ";
                    for (int j = 0; j < getUsuarios().get(k).getPublicaciones().get(i).getShared().size(); j++) {
                        retorno = retorno + getUsuarios().get(k).getPublicaciones().get(i).getShared().get(j).getUsername() + " ";
                    }
                    retorno = retorno + "\n\n";
                }
                    
            }
            retorno = retorno + "*\n\n---------Publicaciones de la red social----------*\n\n";
            // Publicaciones de la red social
            for (int k = 0; k < getPublicaciones().size(); k++) {
                retorno = retorno + "\n##### Publicacion numero" + (k+1) + " #####\n";
                retorno = retorno + "Publicacion creada con fecha: " + getPublicaciones().get(k).getFecha() + "\n";
                retorno = retorno + "Tipo de publicacion: " + getPublicaciones().get(k).getTipo() + "\n";
                retorno = retorno + "Contenido de la publicacion: " + getPublicaciones().get(k).getTexto() + "\n";
                retorno = retorno + "La publicacion cuenta con " + getPublicaciones().get(k).getReactions().size() + "\n";
                // reacciones de la publicacion
                for (int j = 0; j < getPublicaciones().get(k).getReactions().size(); j++) {
                    retorno = retorno + "$$$$ Reaccion numero " + (j+1) + " $$$$\n";
                    retorno = retorno + "Fecha de la reaccion: " + getPublicaciones().get(k).getReactions().get(j).getFecha() + "\n";
                    retorno = retorno + "Autor de la reaccion: " + getPublicaciones().get(k).getReactions().get(j).getAutor() + "\n";
                    retorno = retorno + "Tipo de reaccion: " + getPublicaciones().get(k).getReactions().get(j).getTipo() + "\n";
                    retorno = retorno + "Contenido de la reaccion: " + getPublicaciones().get(k).getReactions().get(j).getContenido() + "\n";            
                }
                retorno = retorno + "La publicacion actual tiene " + getPublicaciones().get(k).getComments().size() + " comentarios\n";
                // comentarios de la publicacion
                for (int j = 0; j < getPublicaciones().get(k).getComments().size(); j++) {
                    retorno = retorno + "     ^^^Comentario numero " + (j+1)+ " ^^^\n";
                    retorno = retorno + "Fecha de creacion del comentario: " + getPublicaciones().get(k).getComments().get(j).getFecha() + "\n";
                    retorno = retorno + "Autor del comentario: " + getPublicaciones().get(k).getComments().get(j).getAutor() + "\n";
                    retorno = retorno + "Tipo de comentario: " + getPublicaciones().get(k).getComments().get(j).getTipo() + "\n";
                    retorno = retorno + "Contenido del comentario: " + getPublicaciones().get(k).getComments().get(j).getTexto() + "\n";
                    retorno = retorno + "El comentario cuenta con otros: " + getPublicaciones().get(k).getComments().get(j).getComments().size() + " comentarios\n";
                    retorno = retorno + "El comentario tiene: " + getPublicaciones().get(k).getComments().get(j).getReactions().size() + " reacciones\n";
                    retorno = retorno + "El comentario tiene: " + getPublicaciones().get(k).getComments().get(j).getTags().size() + " etiquetados\n";
                    retorno = retorno + "Ha sido compartido: " + getPublicaciones().get(k).getComments().get(j).getShared().size() + " veces\n";
                }
                // Etiquetados de la publicacion
                retorno = retorno + "\nLa publicacion tiene como etiquetados a: ";
                for (int j = 0; j < getPublicaciones().get(k).getTags().size(); j++) {
                    retorno = retorno + getPublicaciones().get(k).getTags().get(j) + " ";
                }
                retorno = retorno + "La publicacion ha sido compartida " + getPublicaciones().get(k).getShared().size() + " veces, por: ";
                for (int j = 0; j < getPublicaciones().get(k).getShared().size(); j++) {
                    retorno = retorno + getPublicaciones().get(k).getShared().get(j).getUsername() + " ";
                }
                retorno = retorno + "\n\n";
            }
            retorno = retorno + "*\n\n---------Reacciones de la red social----------*\n\n";
            // reacciones de la red social
            for (int k = 0; k < getReacts().size(); k++) {
                retorno = retorno + "$$$$ Reaccion numero " + (k+1) + " $$$$\n";
                retorno = retorno + "Fecha de la reaccion: " + getReacts().get(k).getFecha() + "\n";
                retorno = retorno + "Autor de la reaccion: " + getReacts().get(k).getAutor() + "\n";
                retorno = retorno + "Tipo de reaccion: " + getReacts().get(k).getTipo() + "\n";
                retorno = retorno + "Contenido de la reaccion: " + getReacts().get(k).getContenido() + "\n";
            }    
        }
        return retorno;
    }

    

}
