package vista;

import colors.Colors;

/**
 * Clase InicioVista donde se mostrara el menu inicial del juego
 *
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class InicioVista {

    /**
     * Constructor InicioVista
     */
    public InicioVista(){
    }

    /**
     * Metodo que da la bienvenida al juego
     */
    public void bienvenida(){
        Colors.println("Bienvenido al juego tres en raya!!!!", Colors.HIGH_INTENSITY);
    }

    /**
     * Metodo que da las opciones de inicio del juego
     */
    public void iniciarJuego(){
        Colors.println("Selecciona una opcion"
        + "\n1. Empezar juego"
        + "\n2. Terminar juego", Colors.HIGH_INTENSITY);
    }

    /**
     * Metodo que muestra que tipo de juego desea el usuario
     */
    public void modoDeJuego(){
        Colors.println("Ingresa el modo de juego que quieres jugar"
        + "\n1. 1 vs 1"
        + "\n2. 1 vs PC", Colors.CYAN);
    }

    /**
     * Metodo que muestra seleccionar la dificultad en modo 1vsPC
     */
    public void dificultad(){
        Colors.println("Selecciona la dificultad contra la que te quieres enfrentar"
        + "\n1. Pensante: La computadora pensara mejor sus movimientos!"
        + "\n2. Aleatorio: La computadora seleccionara una casilla al azar", Colors.CYAN);
    }

    /**
     * Metodo que indica si la opcion es incorrecta
     */
    public void opcionIncorrecta(){
        Colors.println("Opcion incorrecta!", Colors.RED);
    }
}
