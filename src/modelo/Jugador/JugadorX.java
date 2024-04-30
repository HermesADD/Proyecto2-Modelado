package modelo.Jugador;

import modelo.*;

/**
 * Clase JugadorX
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class JugadorX extends Jugador {

    /**
     * Constructor de JugadorX
     * @param tablero - tablero referencia
     */
    public JugadorX(Tablero tablero) {
        super(tablero);
    }

    @Override
    public String getSimbolo() {
        return "[X]";
    }
    
}
