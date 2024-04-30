package modelo;
import vista.*;
/**
 * Interface sujeto del patron observer
 * 
 * @author Hermes
 * @author Steve 
 * @author Emiliano
 */
public interface Sujeto {
   
    /**
     * Metodo que registra un observador
     * @param observador - observador a registrar
     */
    void registrar(Observador observador);

    /**
     * Metodo que remueve un observador
     * @param observador - observador a remover
     */
    void remover(Observador observador);

    /**
     * Metodo que notifica a los observadores
     */
    void notificar();
}
