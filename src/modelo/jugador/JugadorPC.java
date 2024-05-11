package modelo.jugador;

import modelo.Tablero;
import modelo.jugador.dificultad.Dificultad;

/**
 * Clase JugadorPC
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class JugadorPC extends Jugador {

    /**
     * Dificultad del jugador
     */
    Dificultad dificultad;

    /**
     * Constructor del JugadorPC
     * @param tablero - tablero donde hara movimientos el jugador
     * @param dificultad - dificultad del jugador
     */
    public JugadorPC(Tablero tablero, Dificultad dificultad) {
        super(tablero, "[ O ]");
        this.dificultad = dificultad;
    }

    @Override
    public void realizarMovimiento(int fila, int columna) {
        dificultad.realizarMovimiento(getSimbolo());
    }
    
}
