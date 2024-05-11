package modelo.jugador.dificultad;

/**
 * Interface Dificultad para la clase JugadorPC
 * Patron Strategy
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public interface Dificultad {
    
    /**
     * Metodo que realiza un movimiento en el tablero
     * @param simbolo - simbolo del jugador
     */
    void realizarMovimiento(String simbolo);
    
}
