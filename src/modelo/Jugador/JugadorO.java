package modelo.Jugador;

import modelo.*;

/**
 * Clase JugadorY
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class JugadorO extends Jugador{

    /**
     * Contructor de JugadorY
     * @param tablero - tablero referencia
     */
    public JugadorO(Tablero tablero) {
        super(tablero);
    }

    @Override
    public String getSimbolo() {
        return "[O]";
    }
    
}
