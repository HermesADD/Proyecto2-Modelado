package controlador;

import java.util.NoSuchElementException;
import java.util.Scanner;
import vista.*;

/**
 * Clase controlador inicio, donde se conecta el menu inicial con los demas controladores
 * 
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class ControladorInicio {

    /**
     * Controlador 1v1
     */
    private final Controlador1v1 onevsone;

    /**
     * Controlador 1vPC en nivel pensante
     */
    private final Controlador1vPC onevPCpensante;

    /**
     * Controlador 1vPC en nivel aleatorio
     */
    private final Controlador1vPC onevPCaleatorio;

    /**
     * Vista de inicio, menu principal
     */
    private final InicioVista inicioVista;

    /**
     * Constructor de ControladorInicio
     */
    public ControladorInicio(){
        this.onevsone = new Controlador1v1();
        this.onevPCpensante = new Controlador1vPC(1);
        this.onevPCaleatorio= new Controlador1vPC(2);
        inicioVista = new InicioVista();
    }

    /**
     * Metodo que inicia el juego tres en raya
     */
    public void inicioJuego(){
        inicioVista.bienvenida();
        boolean fin = true;
        while(fin){
            inicioVista.iniciarJuego();
            int opcion1 = seleccionaOpcion();
                switch (opcion1) {
                    case 1:
                        inicioVista.modoDeJuego();
                        int opcion2 = seleccionaOpcion();
                        switch (opcion2) {
                            case 1:
                                onevsone.iniciarJuego();
                                break;
                            case 2:
                                inicioVista.dificultad();
                                int opcion3 = seleccionaOpcion();
                                    switch (opcion3) {
                                        case 1:
                                            onevPCpensante.iniciarJuego();
                                            break;
                                        case 2:
                                            onevPCaleatorio.iniciarJuego();
                                            break;
                                        default:
                                            inicioVista.opcionIncorrecta();
                                            break;
                                    }
                                break;
                            default:
                                inicioVista.opcionIncorrecta();
                                break;
                                
                        }
                        break;
                    case 2:
                        fin = false;
                        break;
                    default:
                        inicioVista.opcionIncorrecta();
                        break;
                }
        }
    }

    /**
     * Metodo privado que sirve para seleccionar una opcion 
     */
    private int seleccionaOpcion(){
        Scanner sc1 = new Scanner(System.in);
        int opcion;
        while(true){
            try{
                opcion = sc1.nextInt();
                if (opcion == 1 || opcion == 2) {
                    break; // Si la opción es válida, salimos del bucle
                } else {
                    inicioVista.opcionIncorrecta();
                }
            } catch(NoSuchElementException | NumberFormatException e){
                inicioVista.opcionIncorrecta();
            }finally {
                // Consumir la nueva línea del buffer del Scanner
                sc1.nextLine();
            }
        }
        return opcion;
    }
    
}
