import controlador.*;
/**
 * Juego Tres en raya
 * @author Hermes
 * @author Steve
 * @author Emiliano
 * @version mayo 2024
 */
public class TresEnRaya {
    public static void main(String[] args) {
        //Controlador1v1 controlador = new Controlador1v1();

        //controlador.iniciarJuego();
        // System.out.println("Nivel Pensante");
        // Controlador1vPC control = new Controlador1vPC(1);

        // control.iniciarJuego();
        // System.out.println("Nivel aleatorio");
        // Controlador1vPC c2 = new Controlador1vPC(0);
        // c2.iniciarJuego();
        ControladorInicio inicio = new ControladorInicio();
        inicio.inicioJuego();
    }
}
