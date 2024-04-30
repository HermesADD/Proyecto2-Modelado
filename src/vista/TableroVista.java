package vista;
import modelo.*;
import colors.*;
/**
 * Clase que representa la vista del tablero
 */
public class TableroVista implements Observador{
    
    /**
     * Tablero modelo
     */
    private Tablero modelo;

    /**
     * Constructor de TableroVista
     * @param modelo - tablero modelo del tablero vista
     */
    public TableroVista(Tablero modelo){
        this.modelo = modelo;
        modelo.registrar(this);
    }

    public void mostrarTablero(){
        Colors.println(modelo, Colors.BLUE);
    }

    public void solicitarMovimiento(){
        Colors.println("Selecciona la casilla donde quieres realizar tu movimiento"
        + "\n", Colors.GREEN);
    }

    public void solicitarMovimientoFila(){
        Colors.println("Selecciona la fila donde quieres realizar tu movimiento", Colors.GREEN);
    }

    public void solicitarMovimientoColumna(){

        Colors.println("Selecciona la columna donde quieres realizar tu movimiento", Colors.GREEN);
    }

    public void movimientoIncorrecto(){
        Colors.println("No se puede realizar movimiento", Colors.RED);
    }

    public void ganador(){
        Colors.println("Felicidades has ganado jugador! " + modelo.getJugadorActual().getSimbolo(),Colors.CYAN);
    }

    public void empate(){
        Colors.println("Ha sido un empate :(", Colors.CYAN);
    }

    @Override
    public void actualizar() {
        mostrarTablero();
    }
    
}
