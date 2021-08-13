package model;

import java.util.Date;
import java.text.SimpleDateFormat;
public class React {
    private static Integer idGlobal = 0;
    private Integer id;
    private String autor;
    private String fecha;
    private String contenido;
    private String tipo;

    public React(String autor, String contenido, String tipo){
        idGlobal = idGlobal + 0;
        this.id = idGlobal;
        this.autor = autor;
        this.contenido = contenido;
        this.tipo = tipo;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipoFecha.format(tempDate);

    }
    // getters

    /**
     *
     * @return La id de la reaccion
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return retorna el autor de la reaccion
     */
    public String getAutor() {
        return autor;
    }
    

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @return la fecha de la reaccion
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return el contenido de la reaccion
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @return el tipo de reaccion
     */
    public String getTipo() {
        return tipo;
    }



}


