package modelo;

import java.util.ArrayList;
import modelo.Jugador.*;
import vista.*;
/**
 * Clase que representa al tablero en el juego, 
 * en esta clase se implemente el patron observer
 * y el patron singleton
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Tablero implements Sujeto{

    /**
     * Tablero unico del juego
     */
    private static Tablero instacia;

    /**
     * Casillas del tablero
     */
    private Casilla[][] casillas;

    /**
     * Jugador actual en el tablero
     */
    private Jugador jugadorActual;


    /**
     * Lista de observadores, en este caso las vistas
     */
    private ArrayList<Observador> observadores;

    /**
     * Constructor privado de Tableros
     * 
     * @param casillas - casillas en el tablero
     * @param observadores - vistas del tablero
     * @param jugadores - jugadores en el tablero
     */
    private Tablero(Casilla[][] casillas,ArrayList<Observador> observadores){
        this.casillas = casillas;
        this.observadores = observadores;
        reiniciarTablero();
    }

    /**
     * Metodo estatico que regresa un tablero unico
     * @return tablero unico
     */
    public static Tablero getInstancia(){
        Casilla[][] c= new Casilla[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = new Casilla();
            }
        }

        ArrayList<Observador> obs = new ArrayList<>(); 
        instacia = new Tablero(c, obs);
        return instacia;
    }

    /**
     * Metodo que reinicia el tablero dejando los espacios en blanco
     */
    public void reiniciarTablero(){
        int filas = casillas.length;
        int columnas = casillas[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j].setContenido("[" + i + "," + j + "]" );
            }
        }
    }

    /**
     * Metodo que realiza un movimiento en el tablero
     * @param fila - fila del tablero donde sera el movimiento
     * @param columna - columna del tablero donde sera el movimiento
     * @return si el movimiento se pudo realizar 
     */
    public boolean realizarMovimiento(int fila, int columna){
        if (fila < 0 || fila >= casillas.length || columna < 0 || columna >= casillas[0].length) {
            return false;
        }
        if (casillas[fila][columna].estaOcupada()) {
            return false;
        }

        casillas[fila][columna].setContenido(jugadorActual.getSimbolo());

        setJugadorActual();

        notificar();

        return true;
    }

    /**
     * Metodo que cambia al jugador actual checando el simbolo que tiene
     */
    public void setJugadorActual(){
        if(jugadorActual.getSimbolo().equals("[X]")){
            jugadorActual = JugadorFactory.crearJugador("O", instacia);
        }else{
            jugadorActual = JugadorFactory.crearJugador("X", instacia);
        }
    }

    /**
     * Metodo que devuelve al jugador actual en el tablero 
     * @return Jugador actual
     */
    public Jugador getJugadorActual(){
        return jugadorActual;
    }

    /**
     * Metodo que devuelve a las casillas del tablero
     */
    public Casilla[][] getCasillas(){
        return casillas;
    }

    @Override
    public void registrar(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void remover(Observador observador) {
        observadores.remove(observador);
        
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }
    
}
