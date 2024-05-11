package controlador;

import vista.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import colors.Colors;

public class ControladorInicio {

    private final Controlador1v1 onevsone;

    private final Controlador1vPC onevPCpensante;

    private final Controlador1vPC onevPCaleatorio;

    private final InicioVista inicioVista;


    public ControladorInicio(){
        this.onevsone = new Controlador1v1();
        this.onevPCpensante = new Controlador1vPC(1);
        this.onevPCaleatorio= new Controlador1vPC(2);
        inicioVista = new InicioVista();
    }

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
