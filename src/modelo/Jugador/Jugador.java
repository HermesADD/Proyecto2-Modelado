package modelo.Jugador;

import modelo.*;

/**
 * Clase abstracta Jugador que representa a un jugador del juego
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public abstract class Jugador {
    
    /**
     * Tablero referencia del jugador
     */
    protected Tablero tablero;

    /**
     * Constructor jugador
     * @param tablero - tablero referencia
     */
    public Jugador(Tablero tablero){
        this.tablero = tablero;
    }

    /**
     * Metodo que regresa el simbolo de el jugador
     * @return simbolo del jugador
     */
    public abstract String getSimbolo();

}
