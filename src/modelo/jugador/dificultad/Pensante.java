package modelo.jugador.dificultad;

import modelo.Tablero;

/**
 * Clase pensate donde la PC se mueve con IA
 * @author Hermes
 * @author Steve
 * @author Emiliano
 */
public class Pensante implements Dificultad {
    /**
     * Tablero donde se haran los movimientos
     */
    private final Tablero tablero;

    /**
     * Constructor Pensante
     * @param tablero - tablero donde se haran los movimien
     */
    public Pensante(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void realizarMovimiento(String simbolo) {
        int[] mejorMovimiento = calcularMejorMovimiento(simbolo);
        tablero.setCasilla(mejorMovimiento[0], mejorMovimiento[1], simbolo);
    }

    /**
     * Metodo que calcula el mejor movimiento para la inteligencia artificial.
     * Utiliza el algoritmo minimax para evaluar todas las posibles jugadas y
     * determinar el mejor puntaje.
     *
     * @param tablero El tablero sobre el cual se evaluan los movimientos.
     * @param simbolo El simbolo del jugador para el cual se calcula el movimiento.
     * @return Un arreglo con las coordenadas [fila, columna] del mejor movimiento.
     */
    private int[] calcularMejorMovimiento(String simbolo) {
        int[] mejorMovimiento = new int[2];
        int mejorPuntaje = Integer.MIN_VALUE;

        // Iterar sobre todas las casillas vacías y calcular el puntaje para cada una
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero.getValorCasilla(fila, columna).equals("[ " + fila + "," + columna + " ]")) {
                    // Realizar un movimiento simulado en esta casilla
                    tablero.setCasilla(fila, columna, simbolo);
                    int puntaje = minimax(0, false, simbolo);
                    // Deshacer el movimiento simulado
                    tablero.setCasilla(fila, columna, "[ " + fila + "," + columna + " ]");

                    // Actualizar el mejor movimiento si este puntaje es mayor
                    if (puntaje > mejorPuntaje) {
                        mejorPuntaje = puntaje;
                        mejorMovimiento[0] = fila;
                        mejorMovimiento[1] = columna;
                    }
                }
            }
        }

        return mejorMovimiento;
    }

    /**
     * Metodo que implementa el algoritmo minimax para calcular el mejor movimiento.
     * Este metodo es recursivo y evalua todas las posibles jugadas para determinar
     * el mejor puntaje.
     *
     * @param tablero       El tablero sobre el cual se evaluan los movimientos.
     * @param profundidad   La profundidad actual en la busqueda del arbol de juego.
     * @param esMaximizando Indica si se esta maximizando o minimizando el puntaje.
     * @param simbolo       El simbolo del jugador para el cual se calcula el
     *                      movimiento.
     * @return El puntaje del mejor movimiento en la posicion actual del tablero.
     */
    private int minimax(int profundidad, boolean esMaximizando, String simbolo) {
        // Evaluar el estado del tablero
        if (tablero.hayGanador()) {
            return esMaximizando ? -10 + profundidad : 10 - profundidad;
        }
        if (tablero.hayEmpate()) {
            return 0;
        }

        // Maximizar o minimizar los puntajes
        if (esMaximizando) {
            int mejorPuntaje = Integer.MIN_VALUE;
            for (int fila = 0; fila < 3; fila++) {
                for (int columna = 0; columna < 3; columna++) {
                    if (tablero.getValorCasilla(fila, columna).equals("[ " + fila + "," + columna + " ]")) {
                        tablero.setCasilla(fila, columna, simbolo);
                        int puntaje = minimax(profundidad + 1, false, simbolo);
                        tablero.setCasilla(fila, columna, "[ " + fila + "," + columna + " ]");
                        mejorPuntaje = Math.max(mejorPuntaje, puntaje);
                    }
                }
            }
            return mejorPuntaje;
        } else {
            int mejorPuntaje = Integer.MAX_VALUE;
            for (int fila = 0; fila < 3; fila++) {
                for (int columna = 0; columna < 3; columna++) {
                    if (tablero.getValorCasilla(fila, columna).equals("[ " + fila + "," + columna + " ]")) {
                        tablero.setCasilla(fila, columna, simbolo.equals("[ O ]") ? "[ X ]" : "[ O ]");
                        int puntaje = minimax(profundidad + 1, true, simbolo);
                        tablero.setCasilla(fila, columna, "[ " + fila + "," + columna + " ]");
                        mejorPuntaje = Math.min(mejorPuntaje, puntaje);
                    }
                }
            }
            return mejorPuntaje;
        }
    }
}
