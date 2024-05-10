package modelo.jugador;

import modelo.*;

/**
 * Clase abstracta jugador
 * Patron abstract factory
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public abstract class Jugador {

    /**
     * Tablero donde hara movimientos el jugador
     */
    protected Tablero tablero;

    /**
     * Simbolo que representa al jugador
     */
    private String simbolo;

    /**
     * Constructor del jugador
     * @param tablero - tablero referencia
     * @param simbolo - simbolo del jugador
     */
    public Jugador(Tablero tablero,String simbolo){
        this.tablero = tablero;
        this.simbolo = simbolo;
    }

    /**
     * Metodo que regresa el simbolo del jugador
     * @return simbolo del jugador
     */
    public String getSimbolo(){
        return this.simbolo;
    }

    /**
     * Metodo que realiza un movimiento al tablero
     * @param fila - fila donde se hara el movimiento
     * @param columna - columna donde se hara el movimiento
     */
    public abstract void realizarMovimiento(int fila, int columna);

}
