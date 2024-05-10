package modelo;

import java.util.ArrayList;

import modelo.jugador.*;
import vista.*;

/**
 * Clase Tablero1v1 que es el tablero donde se juega 1 contra 1 "X" vs "O"
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Tablero1v1 implements Tablero{

    /**
     * Casillas del tablero
     */
    private String casilla[][];

    /**
     * Jugador que tiene el turno de mover
     */
    private Jugador jugadorActual;

    /**
     * Jugador "O" del juego
     */
    private JugadorO jugadorO;

    /**
     * Jugador "Y" del juego
     */
    private JugadorX jugadorX;

    /**
     * Lista de observadores del tablero
     */
    private ArrayList<Observador> observadores;

    /**
     * Constructor del tablero 1 vs 1
     */
    public Tablero1v1(){
        this.casilla = new String[3][3];
        this.jugadorO = new JugadorO(this);
        this.jugadorX = new JugadorX(this);
        this.jugadorActual = jugadorO;
        observadores = new ArrayList<>();
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
    public void setCasilla( int fila, int columna, String simbolo){
        casilla[fila][columna] = simbolo;
    }

    @Override
    public void cambiarJugadorActual() {
        if(jugadorActual.getSimbolo().equals("[ O ]")){
            jugadorActual = this.jugadorX;
        }else if(jugadorActual.getSimbolo().equals("[ X ]")){
            jugadorActual = this.jugadorO;
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
    public boolean hayGanador(){
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

    public boolean hayEmpate(){
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
