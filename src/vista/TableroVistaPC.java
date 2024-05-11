package vista;

import colors.Colors;
import modelo.Tablero;

public class TableroVistaPC implements Observador{
    /**
     * Referencia tablero para la vista
     */
    protected Tablero modelo;

    /**
     * Constructor del Tablero Vista
     * @param modelo - tablero que mostrara la vista
     */
    public TableroVistaPC(Tablero modelo){
        this.modelo = modelo;
        modelo.registrar(this);
    }

    /**
     * Metodo que muestra el tablero
     */
    public void mostrarTablero(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String valor = modelo.getValorCasilla(i, j);
                if (valor.equals("[ O ]")) {
                    Colors.print(valor, Colors.RED);
                } else if (valor.equals("[ X ]")) {
                    Colors.print(valor, Colors.GREEN);
                } else {
                    Colors.print(valor, Colors.BLUE);
                }
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" ---|---|---");
            }
        }
        System.out.println();
    }
    
    /**
     * Metodo que solicita movimiento al jugador
     */
    public void solicitarMovimiento(){
        Colors.println("Jugador " + modelo.getJugadorActual().getSimbolo() +" selecciona la casilla donde quieres realizar tu movimiento"
        + "\n", Colors.GREEN);
    }

    /**
     * Metodo que solicita la fila donde se hara el movimiento
     */
    public void solicitarMovimientoFila(){
        Colors.println("Selecciona la fila donde quieres realizar tu movimiento", Colors.GREEN);
    }

    /**
     * Metodo que solicita la columna donde se hara el movimiento
     */
    public void solicitarMovimientoColumna(){

        Colors.println("Selecciona la columna donde quieres realizar tu movimiento", Colors.GREEN);
    }

    /**
     * Metodo que indica si el movimiento es incorrecto
     */
    public void movimientoIncorrecto(){
        Colors.println("No se puede realizar movimiento", Colors.RED);
    }

    /**
     * Metodo que indica al ganador del juego
     */
    public void ganador(){
        if(modelo.getJugadorActual().getSimbolo().equals("[ O ]")){
            Colors.println("La computador ha ganado lo siento :(", Colors.CYAN);
        }else{
            Colors.println("Felicidades has ganado jugador! " + modelo.getJugadorActual().getSimbolo(),Colors.CYAN);
        }
    }

    /**
     * Metodo que indica si hay empate
     */
    public void empate(){
        Colors.println("Ha sido un empate :(", Colors.CYAN);
    }

    public void turnoPC(){
        Colors.println("Es el turno de la PC, espera!", Colors.CYAN);
        try {
            // Simular un tiempo de espera de 2 segundos (2000 milisegundos)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Manejar la excepción si ocurre algún error al pausar el hilo
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar() {
        mostrarTablero();
    }
}
    
