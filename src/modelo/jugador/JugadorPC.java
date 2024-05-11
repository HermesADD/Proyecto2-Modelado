package modelo.jugador;

import modelo.Tablero;
import modelo.jugador.dificultad.Dificultad;

public class JugadorPC extends Jugador {

    Dificultad dificultad;

    public JugadorPC(Tablero tablero, Dificultad dificultad) {
        super(tablero, "[ O ]");
        this.dificultad = dificultad;
    }

    @Override
    public void realizarMovimiento(int fila, int columna) {
        dificultad.realizarMovimiento(getSimbolo());
    }
    
}
