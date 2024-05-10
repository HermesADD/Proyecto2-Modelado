package vista;

import colors.Colors;

public class InicioVista {
    
    public InicioVista(){
        bienvenida();
        modoDeJuego();
    }

    public void bienvenida(){
        Colors.println("Bienvenido al juego tres en raya!!!!", Colors.HIGH_INTENSITY);
    }

    public void modoDeJuego(){
        Colors.println("Ingresa el modo de juego que quieres jugar" 
        + "\n1. 1 vs 1"
        + "\n2. 1 vs PC", Colors.CYAN);
    }

    public void dificultad(){
        Colors.println("Selecciona la dificultad contra la que te quieres enfrentar"
        + "1. RANDOM: La computadora seleccionara una casilla al azar"
        + "2. IA: La computadora pensara mejor sus movimientos!", Colors.CYAN);
    }
}
