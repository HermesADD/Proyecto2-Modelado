package modelo.jugador;

import modelo.*;
/**
 * Clase JugadorO del juego tres en raya
 * 
 * @author Hermes 
 * @author Steve
 * @author Emiliano
 */
public class JugadorO extends Jugador{

     /**
     * Constructor JugadorO
     * @param tablero - tablero referencia
     */
    public JugadorO(Tablero tablero){
        super(tablero, "[ O ]");
    }

    @Override
    public void realizarMovimiento(int fila, int columna) {
        tablero.setCasilla(fila, columna, getSimbolo());
    }
}
