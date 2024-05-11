package modelo.jugador.dificultad;

import java.util.Random;
import modelo.Tablero;

/**
 * Clase Random donde la dificultad del jugador es facil
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Aleatorio implements Dificultad{

    /**
     * Tablero donde se hara el movimiento
     */
    private final Tablero tablero;

    /**
     * Constructor Random
     * @param tablero - tablero donde se hara el movimiento
     */
    public Aleatorio(Tablero tablero){
        this.tablero= tablero;
    }

    @Override
    public void realizarMovimiento(String simbolo) {
        int fila, columna;
        do {
            fila = obtenerFilaAleatoria();
            columna = obtenerColumnaAleatoria();
        } while (!tablero.getValorCasilla(fila, columna).equals("[ " + fila + "," + columna + " ]"));
        tablero.setCasilla(fila, columna, simbolo);
    }

    /**
     * Metodo que regresa una fila aleatoria
     * @return fila aleatoria
     */
    private int obtenerFilaAleatoria(){
        Random rand = new Random();
        return rand.nextInt(3);
    }

    /**
     * Metodo que regresa una columna aleatoria
     * @return columna aleatoria
     */
    private int obtenerColumnaAleatoria(){
        Random rand = new Random();
        return rand.nextInt(3);
    }


    
}
