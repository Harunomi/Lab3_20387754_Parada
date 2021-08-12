package controller;
import java.util.ArrayList;
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
        return actual.isOnline();
    }
    
    // register

    /** 
     * Registra un usuario en la red social
     * @param username el nombre de usuario
     * @param password la contrasena del usuario
     */
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
    /** 
     * Permite autenticar un usuario dentro de la red social
     * @param username el nombre de usuario
     * @param password la contrasena del usuario
     */
    public void login(String username, String password){
        Socialnetwork redSocial = getSocialnetwork();
        for (int i = 0; i < redSocial.getUsuarios().size(); i++) {
            // buscamos al usuario
            if (redSocial.getUsuarios().get(i).getUsername().equals(username) && redSocial.getUsuarios().get(i).getPassword().equals(password)){
                // Establecer al usuario como conectado
                redSocial.setUsuarioOnline(redSocial.getUsuarios().get(i));
                redSocial.setOnline(true);
                return;
            }
        }
        System.out.println("El usuario " + username + "no existe o la contrasena ingresada es incorrecta");
    }
    /** 
     * Desconecta a un usuario de la red social
     */
    public void logOut(){
        Socialnetwork redSocial = getSocialnetwork();
        redSocial.setOnline(false);

    }
    /** 
     * Permite crear una publicacion dentro de la red social
     * @param type el tipo de publicacion
     * @param content el contenido como texto de la publicacion
     */
    public void post(String type, String content){
        Socialnetwork redSocial = getSocialnetwork();
        // creamos la publicacion
        Post newPost = new Post(type,content);
        newPost.setAutor(redSocial.getUsuarioOnline());
        // agregamos la pregunta a la red social
        redSocial.addPostRS(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        redSocial.getUsuarioOnline().getPublicaciones().add(newPost);
        System.out.println("Post protocol completed succesfully");

    }

    /** 
     * Permite crear una publicacion dentro de la red social, pero con etiquetados
     * @param type el tipo de publicacion
     * @param content el contenido como texto de la publicacion
     * @param listaTags lista de etiquetados como string
     */
    public void post(String type, String content,ArrayList<String> listaTags){
        Socialnetwork redSocial = getSocialnetwork();
        Integer counter = 0;
        // verificamos que los etiquetados existan en la red social
        for (int i = 0; i < listaTags.size(); i++) {
            for (int j = 0; j < redSocial.getUsuarios().size(); j++) {
                if (redSocial.getUsuarios().get(j).getUsername().equals(listaTags.get(i))) {
                    counter++;
                }
            }
        }
        // comprobamos que todos los usuarios etiquetados existan en la red social
        if (counter!=listaTags.size()) {
            System.out.println("Uno o mas de los usuarios etiquetados no existe, intentelo nuevamente");
            return;
        }
        // creamos la publicacion
        Post newPost = new Post(type,content,listaTags);
        newPost.setAutor(redSocial.getUsuarioOnline());
        // agregamos la pregunta a la red social
        redSocial.addPostRS(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        redSocial.getUsuarioOnline().getPublicaciones().add(newPost);
        System.out.println("Post protocol completed succesfully");

    }
    /** 
     * Permite crear una publicacion dentro de la red social, pero con etiquetados
     * @param username nombre de la persona a la cual deseo seguir
     */
    public void follow(String username){
        Socialnetwork redSocial = getSocialnetwork();
        // revisamos el caso en que el usuario se quiera seguir a si mismo
        if (redSocial.getUsuarioOnline().getUsername().equals(username)){
            System.out.println("Lo sentimos, pero el usuario no se puede seguir a si mismo!");
            return;
        }
        for (int i = 0; i < redSocial.getUsuarios().size(); i++) {
            if (redSocial.getUsuarios().get(i).getUsername().equals(username)) {
                redSocial.getUsuarios().get(i).addFollowers(redSocial.getUsuarioOnline());
                System.out.println("El usuario "+username+" ha sido seguido con exito!");
                return;
            }
        }
        System.out.println("El usuario ingresado no existe!");


    }
    /** 
     * permite seguir a una persona dada su id
     * @param id id del usuario al cual deseo seguir
     */
    public void share(Integer id){
        Socialnetwork redSocial = getSocialnetwork();
        // buscamos si la publicacion existe
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                // encontramos la publicacion, por lo que se copia
                Post sharedPost = new Post(redSocial.getPublicaciones().get(i).getTipo(),redSocial.getPublicaciones().get(i).getTexto());
                sharedPost.setAutor(redSocial.getUsuarioOnline());
                // a la publicacion original le agrego el usuario que la compartio
                redSocial.getPublicaciones().get(i).addShared(redSocial.getUsuarioOnline());
                // agrego la nueva publciacion a la red social y al usuario en cuestion
                redSocial.addPostRS(sharedPost);
                redSocial.getUsuarioOnline().addUserPost(sharedPost);
                System.out.println("Publicacion compartida con exito!");
                return;
            }
        }
        System.out.println("La publicacion con la ID "+id+" no fue encontrada en la red social :(");
    }
    /** 
     * permite seguir a una persona dada su id
     * @param id de la publicacion a compartir
     * @param listaTags lista de los etiquetados
     */
    public void share(Integer id,ArrayList<String> listaTags){
        Socialnetwork redSocial = getSocialnetwork();
        Integer counter = 0;
        // verificamos que los etiquetados existan en la red social
        for (int i = 0; i < listaTags.size(); i++) {
            for (int j = 0; j < redSocial.getUsuarios().size(); j++) {
                if (redSocial.getUsuarios().get(j).getUsername().equals(listaTags.get(i))) {
                    counter++;
                }
            }
        }
        // comprobamos que todos los usuarios etiquetados existan en la red social
        if (counter!=listaTags.size()) {
            System.out.println("Uno o mas de los usuarios etiquetados no existe, intentelo nuevamente");
            return;
        }
        // buscamos si la publicacion existe
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                // encontramos la publicacion, por lo que se copia
                Post sharedPost = new Post(redSocial.getPublicaciones().get(i).getTipo(),redSocial.getPublicaciones().get(i).getTexto(),listaTags);
                sharedPost.setAutor(redSocial.getUsuarioOnline());
                // a la publicacion original le agrego el usuario que la compartio
                redSocial.getPublicaciones().get(i).addShared(redSocial.getUsuarioOnline());
                // agrego la nueva publciacion a la red social y al usuario en cuestion
                redSocial.addPostRS(sharedPost);
                redSocial.getUsuarioOnline().addUserPost(sharedPost);
                System.out.println("Publicacion compartida con exito!");
                return;
            }
        }
        System.out.println("La publicacion con la ID "+id+" no fue encontrada en la red social :(");
    }

    /** 
     * muestra el contenido de la red social
     */
    public void visualize(){
        Socialnetwork redSocial = getSocialnetwork();
        String salida = redSocial.SocialNetworkToString();
        System.out.println(salida);
    }
    /** 
     * permite realizar un comentario a una publicacion o comentario
     * @param id de la publicacion o comentario
     * @param texto contenido del comentario
     */
    public void comment(Integer id, String texto){
        Socialnetwork redSocial = getSocialnetwork();
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                // los comentarios son siempre del tipo text
                Post comentario = new Post("text", texto);
                // modifico el autor
                comentario.setAutor(redSocial.getUsuarioOnline());
                // agrego el comentario a la publicacion
                redSocial.getPublicaciones().get(i).addComment(comentario);
                // agrego el comentario a la lista de publciaciones del usuario
                redSocial.getUsuarioOnline().addUserPost(comentario);
                System.out.println("\nComentario realizado con exito!");
                return;
            }
        }
        System.out.println("La id de la publicacion o comentario ingresada no existen en la red social :(\n");

    }

    /** 
     * permite agregar una reaccion a una publicacion o comentario
     * @param id id del usuario al cual deseo seguir
     * @param tipo tipo de reaccion que se desea realizar
     * @param el texto adicional a la reaccion
     */
    public void react(Integer id,String tipo, String texto){
        Socialnetwork redSocial = getSocialnetwork();
        for (int i = 0; i < redSocial.getPublicaciones().size(); i++) {
            if (redSocial.getPublicaciones().get(i).getId() == id) {
                React reaccion = new React(redSocial.getUsuarioOnline().getUsername(),texto, tipo);
                redSocial.getPublicaciones().get(i).addReact(reaccion);
                redSocial.addReactRS(reaccion);
                System.out.println("Reaccion realizada con exito!");
            }
        }
    }

    /**
     * de la lista de IDs dada, busca aquellas que tengan como minimio cierta cantidad de compartidas
     * @param lista
     * @param variableK
     */
    public void isViral(ArrayList<Integer> lista,Integer variableK){
        if (lista.size() == 0) { // caso en que no se haya agregado ninguna ID
            System.out.println("Debe ingresar al menos una ID para hacer esta funcion");
            return;
        }
        Socialnetwork redSocial = getSocialnetwork();
        ArrayList<Post> cumplen = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < redSocial.getPublicaciones().size(); j++) {
                // buscamos que la ID ingresada sea una publicacion
                if (lista.get(i) == redSocial.getPublicaciones().get(j).getId()) {
                    // comprobamos que cumplan con la cantidad de compartidas
                    if (redSocial.getPublicaciones().get(j).getShared().size() >= variableK) {
                        cumplen.add(redSocial.getPublicaciones().get(j));
                    }
                }
            }
        }
        if (cumplen.size() == 0) {
            System.out.println("De la lista dada, ninguna publicacion cumple con el minimo de " + variableK + " compartidas.");
            return;
        }else{
            printearPost(cumplen);
        }

    }
    /**
     * printea en especifico una lista de publicaciones dada
     * @param lista
     */
    public void printearPost(ArrayList<Post> lista){
        for (int k = 0; k < lista.size(); k++) {
            System.out.println("\n##### Publicacion numero" + (k+1) + " #####\n");
            System.out.println("Publicacion creada con fecha: " + lista.get(k).getFecha() + "\n");
            System.out.println("Tipo de publicacion: " + lista.get(k).getTipo() + "\n");
            System.out.println("Contenido de la publicacion: " + lista.get(k).getTexto() + "\n");
            System.out.println("La publicacion cuenta con " + lista.get(k).getReactions().size() + "\n");
            // reacciones de la publicacion
            for (int j = 0; j < lista.get(k).getReactions().size(); j++) {
                System.out.println("$$$$ Reaccion numero " + (j+1) + " $$$$\n");
                System.out.println("Fecha de la reaccion: " + lista.get(k).getReactions().get(j).getFecha() + "\n");
                System.out.println("Autor de la reaccion: " + lista.get(k).getReactions().get(j).getAutor() + "\n");
                System.out.println("Tipo de reaccion: " + lista.get(k).getReactions().get(j).getTipo() + "\n");
                System.out.println("Contenido de la reaccion: " + lista.get(k).getReactions().get(j).getContenido() + "\n");            
            }
            System.out.println("La publicacion actual tiene " + lista.get(k).getComments().size() + " comentarios\n");
            // comentarios de la publicacion
            for (int j = 0; j < lista.get(k).getComments().size(); j++) {
                System.out.println("     ^^^ Comentario numero " + (j+1)+ " ^^^\n");
                System.out.println("Fecha de creacion del comentario: " + lista.get(k).getComments().get(j).getFecha() + "\n");
                System.out.println("Autor del comentario: " + lista.get(k).getComments().get(j).getAutor().getUsername() + "\n");
                System.out.println("Tipo de comentario: " + lista.get(k).getComments().get(j).getTipo() + "\n");
                System.out.println("Contenido del comentario: " + lista.get(k).getComments().get(j).getTexto() + "\n");
                System.out.println("El comentario cuenta con otros: " + lista.get(k).getComments().get(j).getComments().size() + " comentarios\n");
                System.out.println("El comentario tiene: " + lista.get(k).getComments().get(j).getReactions().size() + " reacciones\n");
                System.out.println("El comentario tiene: " + lista.get(k).getComments().get(j).getTags().size() + " etiquetados\n");
                System.out.println("Ha sido compartido: " + lista.get(k).getComments().get(j).getShared().size() + " veces\n");
            }
        }
    }

}
