package modelo;

import java.util.ArrayList;
import modelo.jugador.*;
import modelo.jugador.dificultad.*;
import vista.Observador;

/**
 * Clase Tablero1vPC que es el tablero donde se juega 1 contra PC "X" vs "O"
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Tablero1vPC implements Tablero {

    /**
     * Casillas del tablero
     */
    private final String casilla[][];

    /**
     * Jugador que tiene el turno de mover
     */
    private Jugador jugadorActual;

    /**
     * JugadorPC "O" del juego
     */
    private final JugadorPC jugadorOPC;

    /**
     * Jugador "X" del juego
     */
    private final JugadorX jugadorX;

    /**
     * Lista de observadores del tablero
     */
    private final ArrayList<Observador> observadores;

    /**
     * Constructor del tablero 1 vs 1
     * @param nivel - indica el nivel del juego
     *              - 1 si es pensante
     *              - otro caso entonces es aleatorio
     */
    public Tablero1vPC(int nivel){
        this.casilla = new String[3][3];
        this.observadores = new ArrayList<>();
        this.jugadorX = new JugadorX(this);
        if(nivel == 1){
            this.jugadorOPC = new JugadorPC(this, new Pensante(this));
        }else{
            this.jugadorOPC = new JugadorPC(this, new Aleatorio(this));
        } 
        this.jugadorActual = jugadorX;
        reiniciarTablero();
    
    }

    @Override
    public void reiniciarTablero() {
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j<3 ; j++){
                casilla[i][j] = "[ " + i +","+ j +" ]";
            }
        }
    }

    @Override
    public void setCasilla(int fila, int columna, String simbolo) {
        casilla[fila][columna] = simbolo;
    }

    @Override
    public void cambiarJugadorActual() {
        if(jugadorActual.getSimbolo().equals("[ X ]")){
            jugadorActual = this.jugadorOPC;
        }else if(jugadorActual.getSimbolo().equals("[ O ]")){
            jugadorActual = this.jugadorX;
        }
    }

    @Override
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    @Override
    public String getValorCasilla(int fila, int columna) {
        return casilla[fila][columna];
    }

    @Override
    public boolean hayGanador() {
        for (int i = 0; i < 3; i++) {
            if (casilla[i][0].equals(casilla[i][1]) && casilla[i][1].equals(casilla[i][2])) {
                return true;
            }
            if (casilla[0][i].equals(casilla[1][i]) && casilla[1][i].equals(casilla[2][i])) {
                return true;
            }
        }
        // Verificar diagonales
        if ((casilla[0][0].equals(casilla[1][1]) && casilla[1][1].equals(casilla[2][2])) ||
                (casilla[0][2].equals(casilla[1][1]) && casilla[1][1].equals(casilla[2][0]))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hayEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casilla[i][j].equals("[ " + i +","+ j + " ]")) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void registrar(Observador o) {
        observadores.add(o);
    }

    @Override
    public void remover(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }
}
