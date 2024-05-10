package modelo;

import vista.Observador;

/**
 * Interface sujeto, que sirve para notificar a las vistas del tablero
 * Patron Observer
 * 
 * @author Hermes
 * @author Emiliano
 * @author Steve
 */
public interface Sujeto {
    
    /**
     * Registra un nuevo observador al sujeto
     * @param o - observador a agregar
     */
    void registrar(Observador o);

    /**
     * Remueve un nuevo observador al sujeto
     * @param o - observador a remover
     */
    void remover(Observador o);

    /**
     * Notifica a los observadores del sujeto
     */
    void notificar();
}
