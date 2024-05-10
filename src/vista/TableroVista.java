package vista;

import colors.Colors;
import modelo.*;

public class TableroVista implements Observador {

    protected Tablero modelo;

    public TableroVista(Tablero modelo){
        this.modelo = modelo;
        modelo.registrar(this);
    }

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
    
    public void solicitarMovimiento(){
        Colors.println("Jugador " + modelo.getJugadorActual().getSimbolo() +" selecciona la casilla donde quieres realizar tu movimiento"
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
