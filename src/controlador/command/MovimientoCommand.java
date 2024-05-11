package controlador.command;

import modelo.Tablero;
/**
 * Clase MovimientoCommand para hacer movimientos en el tablero
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class MovimientoCommand implements Command {
    
    /**
     * Tablero donde se aplicaran los movimientos
     */
    private Tablero tablero;

    /**
     * Fila donde se hara el movimiento
     */
    private int fila;

    /**
     * Columna donde se hara el movimiento
     */
    private int columna;

    /**
     * Constructor MovimientoCommand
     * @param fila - fila donde se hara el movimiento
     * @param columna - columna donde se hara el movimiento
     * @param tablero - tablero donde se hara el movimiento
     */
    public MovimientoCommand(int fila, int columna, Tablero tablero){
        this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
    }

    @Override
    public void execute() {
        tablero.getJugadorActual().realizarMovimiento(fila, columna);
        tablero.notificar();
    }
    
}
