package modelo.Jugador;

import modelo.Tablero;

/**
 * Clase JugadorFactory que sirve para construir 
 * jugadores dependiendo el caso usando Factory
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class JugadorFactory {
 
    /**
     * Metodo estatico que crea un jugador 
     * @param tipo - tipo de jugador a crear
     * @param tablero - tablero donde jugara el jugador
     * @return jugador creado
     */
    public static Jugador crearJugador(String tipo, Tablero tablero ){
        if (tipo.equalsIgnoreCase("X")) {
            return new JugadorX(tablero);
        } else if (tipo.equalsIgnoreCase("O")) {
            return new JugadorO(tablero);
        }
        return null;
    }
}
