package controlador.command;

import modelo.Tablero;

public class MovimientoCommand implements Command {
    Tablero tablero;

    int fila;
    int columna;

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
