package modelo;

/**
 * Clase casilla que representa una casilla en el tablero del juego tres en raya
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Casilla {

    /**
     * Contenido dentro de la casilla
     */
    private String contenido;

    /**
     * Constructor de la casilla
     * @param contenido contenido que tendra la casilla
     */
    public Casilla(String contenido){
        this.contenido = contenido;
    }

    /**
     * Constructor vacio de casilla
     */
    public Casilla(){
    }

    /**
     * Metodo que devuelve el contenido de la casilla
     * @return contenido de la casilla 
     */
    public String getContenido(){
        return this.contenido;
    }

    /**
     * Metodo que modifica el contenido de la casilla
     * @param contenido nuevo contenido, "X" o "Y"     
     */
    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    /**
     * Metodo que devuelve si la casilla esta ocupada
     * @return true - si la casilla contiene [X] o [O]
     *          false- en otro caso
     */
    public boolean estaOcupada(){
        if(contenido.equals("[X]") || contenido.equals("[O]")){
            return true;
        }else{
            return false;
        }
    }
}