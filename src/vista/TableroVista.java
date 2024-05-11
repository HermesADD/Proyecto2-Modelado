package vista;

import colors.Colors;
import modelo.*;

/**
 * Clase tablero vista que sirve para manejar las vistas del tablero u otras opciones
 * Implementa la interface observador del patron Observer
 * 
 * @author Hermes
 * @author Steve 
 * @author Emiliano
 */
public class TableroVista implements Observador {

    /**
     * Referencia tablero para la vista
     */
    protected Tablero modelo;

    /**
     * Constructor del Tablero Vista
     * @param modelo - tablero que mostrara la vista
     */
    public TableroVista(Tablero modelo){
        this.modelo = modelo;
        modelo.registrar(this);
    }

    /**
     * Metodo que muestra el tablero
     */
    public void mostrarTablero(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String valor = modelo.getValorCasilla(i, j);
                if (valor.equals("[ O ]")) {
                    Colors.print(valor, Colors.RED);
                } else if (valor.equals("[ X ]")) {
                    Colors.print(valor, Colors.GREEN);
                } else {
                    Colors.print(valor, Colors.BLUE);
                }
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ---|---|---");
            }
        }
        System.out.println();
    }
    
    /**
     * Metodo que solicita movimiento al jugador
     */
    public void solicitarMovimiento(){
        Colors.println("Jugador " + modelo.getJugadorActual().getSimbolo() +" selecciona la casilla donde quieres realizar tu movimiento"
        + "\n", Colors.GREEN);
    }

    /**
     * Metodo que solicita la fila donde se hara el movimiento
     */
    public void solicitarMovimientoFila(){
        Colors.println("Selecciona la fila donde quieres realizar tu movimiento", Colors.GREEN);
    }

    /**
     * Metodo que solicita la columna donde se hara el movimiento
     */
    public void solicitarMovimientoColumna(){

        Colors.println("Selecciona la columna donde quieres realizar tu movimiento", Colors.GREEN);
    }

    /**
     * Metodo que indica si el movimiento es incorrecto
     */
    public void movimientoIncorrecto(){
        Colors.println("No se puede realizar movimiento", Colors.RED);
    }

    /**
     * Metodo que indica al ganador del juego
     */
    public void ganador(){
        Colors.println("Felicidades has ganado jugador! " + modelo.getJugadorActual().getSimbolo(),Colors.CYAN);
    }

    /**
     * Metodo que indica si hay empate
     */
    public void empate(){
        Colors.println("Ha sido un empate :(", Colors.CYAN);
    }

    @Override
    public void actualizar() {
        mostrarTablero();
    }
}
