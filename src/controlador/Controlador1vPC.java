package controlador;

import controlador.command.Command;
import controlador.command.MovimientoCommand;
import java.util.NoSuchElementException;
import java.util.Scanner;
import modelo.Tablero1vPC;
import vista.TableroVistaPC;

public class Controlador1vPC {
    /**
     * Tablero 1v1
     */
    private final Tablero1vPC modelo;

    /**
     * Vista del tablero en este caso 1v1
     */
    private final  TableroVistaPC vista;

    /**
     * Constructor del controlador 1 vs PC
     * @param nivel - indica el nivel del juego
     */
    public Controlador1vPC(int nivel){
        this.modelo = new Tablero1vPC(nivel);
        this.vista = new TableroVistaPC(modelo);
    }

    /**
     * Metodo que inicia el juego
     */
    public void iniciarJuego(){
        vista.mostrarTablero();
        while (!juegoTerminado()) {
            if(modelo.getJugadorActual().getSimbolo().equals("[ O ]")){
                vista.turnoPC();
                Command movPC = new MovimientoCommand(0, 0,modelo);
                movPC.execute();
            }else{
                int[] movimiento = solicitarMovimiento();
                Command mov = new MovimientoCommand(movimiento[0], movimiento[1], modelo);
                mov.execute();
            }
            if (modelo.hayGanador()) {
                vista.ganador();
            } else if (modelo.hayEmpate()) {
                vista.empate();
            }
            modelo.cambiarJugadorActual();
        }
        
    }


    /**
     * Metodo privado que sirve para solicitar movimiento
     * @return Arreglo de int con fila y columna donde se hara el movimiento
     */
    private int[] solicitarMovimiento(){
        int[] fc = new int[2];
        int fila = -1;
        int columna = -1;
        vista.solicitarMovimiento();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                vista.solicitarMovimientoFila();
                fila = sc.nextInt();
                if(fila < 0 || fila > 2){
                    vista.movimientoIncorrecto();
                    continue;
                }
                vista.solicitarMovimientoColumna();
                columna = sc.nextInt();
                if(columna < 0 || columna > 2){
                    vista.movimientoIncorrecto();
                    continue;
                }
                if (!modelo.getValorCasilla(fila, columna).equals("[ " + fila + "," + columna +   " ]")) {
                    vista.movimientoIncorrecto();
                    continue;
                }
                fc[0] = fila;
                fc[1] = columna;
                break;
            } catch(NoSuchElementException | NumberFormatException e){
                vista.movimientoIncorrecto();
            }finally {
                // Consumir la nueva línea del buffer del Scanner
                sc.nextLine();
            }
        }
        return fc; 
    }

    
    /**
     * Indica si el juego termino
     * @return true - si termino el juego
     *         false- no termino el juego
     */
    public boolean juegoTerminado(){
        if(modelo.hayGanador() || modelo.hayEmpate()){
            modelo.reiniciarTablero();
            return true;
        }else{
            return  false;
        }
    }
    
}
