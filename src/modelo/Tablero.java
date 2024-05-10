package modelo;

import modelo.jugador.Jugador;

/**
 * Interface tablero
 * 
 * @author Hermes
 * @author Steve 
 * @author Emiliano
 */
public interface Tablero extends Sujeto{
   
    /**
     * Metodo que reinicia el tablero
     */
    void reiniciarTablero();


    /**
     * Metodo que modifica el valor de una casilla
     * @param fila - fila donse se modificara el valor
     * @param columna - columna donde se modificara el valor
     * @param simbolo - nuevo valor
     */
    public void setCasilla(int fila, int columna, String simbolo);

    /**
     * Metodo que cambia jugador actual
     */
    void cambiarJugadorActual();

    /**
     * Metodo que regresa el jugador actual
     * @return jugador actual
     */
    Jugador getJugadorActual();

    /**
     * Metodo que regresa el valor que tiene la casilla
     * @param fila - fila donde se encuentra el valor
     * @param columna - columna donde se encuentra el valor
     * @return valor de la casilla
     */
    String getValorCasilla(int fila, int columna);

    /**
     * Metodo que dice si hay ganador
     * @return true - hay ganador
     *         false - no hay ganador
     */
    boolean hayGanador();

    /**
     * Metodo que dice si empataron
     * @return true - hay empate
     *         false- no hay empate
     */
    boolean hayEmpate();
}
