package modelo.jugador;

import modelo.*;
/**
 * Clase JugadorX del juego tres en raya
 * 
 * @author Hermes 
 * @author Steve
 * @author Emiliano
 */
public class JugadorX extends Jugador {

    /**
     * Constructor JugadorX
     * @param tablero - tablero referencia
     */
    public JugadorX(Tablero tablero){
        super(tablero, "[ X ]");
    }

    @Override
    public void realizarMovimiento(int fila, int columna) {
        tablero.setCasilla(fila, columna, getSimbolo());
    }

}
