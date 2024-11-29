/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tres_en_raya;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rubén Fompedriña Añón
 *
 */
public class TRES_EN_RAYA {

    //creamos al array con las posiciones dentro del tablero de juego
    static char[] posicion = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    /** 
     * Punto de entrada de la aplicación Tres en Raya. 
     * 
     * @param args Los argumentos de la línea de comandos (no utilizados). 
     */
    public static void main(String[] args) {

        boolean continuar = true; //inicializamos el controlador de nuestro buble
        Scanner sc = new Scanner(System.in); //inicializamos el scanner

        System.out.println("Bienvenido a tres en raya");

        while (continuar) {

            //inicializamos los controladores para los bucles
            boolean ganador = false;
            boolean empate = false;
            boolean longitud = true;
            boolean entradaValida = false;
            int eleccionJuego = 0;
            
            //metodo para resetear los valores
            reset();
            
            while (!entradaValida) {
                try {
                    System.out.println("Elige una opción: \n (1) Jugar 2 jugadores. \n"
                            + " (2) Jugar 1 jugador (contra la máquina) \n (3) Salir.");
                    //Tomamos la eleccion
                    eleccionJuego = sc.nextInt();
                    entradaValida = true; //Si la entrada es valida cambiamos el valor
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no valida, intentalo de nuevo");
                    sc.next(); //limpiamos la entrada no valida
                }
            }
            
            switch (eleccionJuego) {
                case 1: //jugador vs jugador
                    System.out.println("Has seleccionado: Jugador contra jugador.");

                    estadoPartida();

                    //Bucle, que detecta cuando hay un ganador o un empate
                    while (!ganador && !empate) {

                        //iniciamos los controladores para los bucles
                        boolean jugadaAceptada = false;

                        while (!jugadaAceptada) {
                            //Escoge jugador 1
                            System.out.println("Turno jugador 1, escoge posición en el tablero! (1-9)");
                            String j1jugada = sc.next();
                            longitud = comprobarLongitudCadena(j1jugada);
                            if (longitud) {
                                char j1posicion = j1jugada.charAt(0);
                                jugadaAceptada = comprobarJugada(j1posicion);

                                //Si la jugada es correcta, se pone la posicion en el tablero
                                if (jugadaAceptada) {
                                    System.out.println("Jugador 1 ha escogido: " + j1posicion);
                                    intercambioPosicionX(j1posicion);
                                    estadoPartida();
                                    ganador = tresEnRaya(j1posicion);
                                    empate = metodoEmpate();

                                    //Si se confima que hay tres en raya muestra el mensaje de ganador.
                                    if (ganador) {
                                        System.out.println("\nFin de partida: Jugador 1 gana la partida!!\n");
                                    } else if (empate) {
                                        System.out.println("\nFin de partida: Empate!\n");
                                    }
                                } else {
                                    System.out.println("\nJugador 1, tu seleccion no es correcta! Intentalo de nuevo.");
                                }
                            }
                        }

                        //Comprobamos si podemos pasar al jugador dos, si la jugada es correcta y no hay ni ganador ni empate
                        if ((jugadaAceptada && !ganador) && (jugadaAceptada && !empate)) {

                            //reinicio el valor de jugada aceptada para el jugador 2
                            jugadaAceptada = false;
                            while (!jugadaAceptada) {
                                //jugador dos escoge
                                System.out.println("Turno jugador 2, escoge posición en el tablero! (1-9)");
                                String j2jugada = sc.next();
                                longitud = comprobarLongitudCadena(j2jugada);
                                if (longitud) {
                                    char j2posicion = j2jugada.charAt(0);
                                    jugadaAceptada = comprobarJugada(j2posicion);

                                    if (jugadaAceptada) {
                                        System.out.println("Jugador 2 ha escogido: " + j2posicion);
                                        intercambioPosicionO(j2posicion);
                                        estadoPartida();
                                        ganador = tresEnRaya(j2posicion);
                                        empate = metodoEmpate();

                                        if (ganador) {
                                            System.out.println("\nFin de partida: Jugador 2 gana la partida!!\n");
                                        } else if (empate) {
                                            System.out.println("\nFin de partida: Empate!\n");
                                        }
                                    } else {
                                        System.out.println("\nJugador 2, tu seleccion no es correcta! Intentalo de nuevo.");
                                    }
                                }
                            }
                        }
                    }
                    break;
                    
                case 2: //jugador vs maquina.

                    System.out.println("Has seleccionado: Jugador contra máquina.");

                    estadoPartida();

                    //Bucle, que detecta cuando hay un ganador o un empate
                    while (!ganador && !empate) {

                        //iniciamos los controladores para los bucles
                        boolean jugadaAceptada = false;

                        while (!jugadaAceptada) {
                            //Escoge jugador 1
                            System.out.println("Turno jugador 1, escoge posición en el tablero! (1-9)");
                            String j1jugada = sc.next();
                            longitud = comprobarLongitudCadena(j1jugada);

                            //Comprobamos si la longitud de  la palabra es correcta
                            if (longitud) {
                                char j1posicion = j1jugada.charAt(0);
                                jugadaAceptada = comprobarJugada(j1posicion);

                                //Si la jugada es correcta, se pone la posicion en el tablero
                                if (jugadaAceptada) {
                                    System.out.println("Jugador 1 ha escogido: " + j1posicion);
                                    intercambioPosicionX(j1posicion);
                                    estadoPartida();
                                    ganador = tresEnRaya(j1posicion);
                                    empate = metodoEmpate();

                                    //Si se confima que hay tres en raya muestra el mensaje de ganador.
                                    if (ganador) {
                                        System.out.println("\nFin de partida: Jugador 1 gana la partida!!\n");
                                    } else if (empate) {
                                        System.out.println("\nFin de partida: Empate!\n");
                                    }
                                } else {
                                    System.out.println("\nJugador 1, tu seleccion no es correcta! Intentalo de nuevo.");
                                }
                            }
                        }

                        //Comprobamos si podemos pasar turno si la jugada es correcta y no hay ni ganador ni empate
                        if ((jugadaAceptada && !ganador) && (jugadaAceptada && !empate)) {

                            //reinicio el valor de jugada aceptada para la jugada de la máquina
                            jugadaAceptada = false;
                            while (!jugadaAceptada) {
                                //Eleccion random de la maquina
                                //damos la lista de opciones
                                char[] opciones = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

                                //creamos la estructura para la eleccion aleatoria de la posicion.
                                Random rd = new Random(); //iniciamos el random

                                //creamos un indice aleatorio con el numero de posiciones del array
                                int indice = rd.nextInt(opciones.length);

                                //cambiamos la posicion en el indice por el caracter que representa.
                                char maquinaPosicion = opciones[indice];

                                jugadaAceptada = comprobarJugada(maquinaPosicion);

                                if (jugadaAceptada) {
                                    System.out.println("Turno máquina: ");
                                    System.out.println("La máquina ha escogido: " + maquinaPosicion);
                                    intercambioPosicionO(maquinaPosicion);
                                    estadoPartida();
                                    ganador = tresEnRaya(maquinaPosicion);
                                    empate = metodoEmpate();

                                    if (ganador) {
                                        System.out.println("\nFin de partida: La máquina ha ganado la partida!!\n");
                                    } else if (empate) {
                                        System.out.println("\nFin de partida: Empate\n");
                                    }
                                }
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("Has seleccionado salir");
                    continuar = false;
                    break;
                default: //recogemos las elecciones incorrectas
                    System.out.println("Selección erronea");
                    break;
            }
        }
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        sc.close();
    }

    /**
     * Este método muestra el campo de juego con las posiciones actualizadas
     */
    public static void estadoPartida() {
        System.out.println("\nEstado partida:\n\n   " + posicion[0] 
                + " | " + posicion[1] + " | " + posicion[2] 
                + "\n -------------" + "\n   " + posicion[3] 
                + " | " + posicion[4] + " | " + posicion[5] 
                + "\n -------------" + "\n   " + posicion[6] 
                + " | " + posicion[7] + " | " + posicion[8] + "\n");
    }

    /**
     * Este método comprueba que el string tomado al usuario no contiene mas de un caracter
     * @param palabra Toma el valor tomado al usuario
     * @return Devuelve un boolean en funcion de si cumple o no con las condiciones
     */
    public static boolean comprobarLongitudCadena(String palabra) {
        
        if (palabra.length() != 1) {
            System.out.println("Entrada no válida, por favor escoge un número entre 1 y 9.");
            return false;
        }
        return true;
    }

    /**
     * Este método comprueba que el valor tomado del string esta dentro de los valores del juego y que la posición está libre.
     * @param posicionJugador es el valor del primer caracter del string tomado al usuario
     * @return Devuelve un valor de tipo boolean en función de si cumple los parametros
     */
    public static boolean comprobarJugada(char posicionJugador) {

        //Comprobamos si el valor esta dentro de los limites del campo
        if ((posicionJugador == '1') | (posicionJugador == '2') | 
            (posicionJugador == '3') | (posicionJugador == '4') | 
            (posicionJugador == '5') | (posicionJugador == '6') | 
            (posicionJugador == '7') | (posicionJugador == '8') | 
            (posicionJugador == '9')) {
        } else {
            return false;
        }

        //Convertimos char a int
        int numeroPosicion = posicionJugador - '0';

        //Recorremos el bucle
        for (int i = 0; i < posicion.length; i++) {

            //Comprobamos dentro del if, que la posicion del jugador no este ocupada
            if (i == (numeroPosicion - 1)) {
                if (posicion[i] == posicionJugador) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Este método cambia la posición escogida por una X dentro de la posicion del array
     * @param posicionElegida toma el valor del caracter elegido por el usuario
     */
    public static void intercambioPosicionX(char posicionElegida) {

        for (int x = 0; x < posicion.length; x++) {
            if (posicion[x] == posicionElegida) {
                posicion[x] = 'X';
            }
        }
    }

    /**
     * Este método cambia la posición escogida por una O dentro de la posicion del array
     * @param posicionElegida toma el valor del caracter elegido por el usuario
     */
    public static void intercambioPosicionO(char posicionElegida) {
 
        for (int x = 0; x < posicion.length; x++) {
            if (posicion[x] == posicionElegida) {
                posicion[x] = 'O';
            }
        }
    }

    /**
     * Método que comprueba si hay tres posiciones iguales en ciertos indices
     * @param posicionElegida toma el valor de la posicion escogida
     * @return Devuelve un boolean si se dan las condiciones
     */
    public static boolean tresEnRaya(char posicionElegida) {

        //Comprobamos todos los posibles casos de 3 en raya
        if ((posicion[0] == posicion[1]) && (posicion[1] == posicion[2]) 
                && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la primera fila horizontal.");
            return true;
                
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) 
                && (posicion[3] == 'X' || posicion[3] == 'O')) {
            System.out.println("Tres en raya! En la segunda fila horizontal.");
            return true;
            
        } else if ((posicion[6] == posicion[7]) && (posicion[7] == posicion[8]) 
                && (posicion[6] == 'X' || posicion[6] == 'O')) {
            System.out.println("Tres en raya! En la tercera fila horizontal.");
            return true;
            
        } else if ((posicion[0] == posicion[3]) && (posicion[3] == posicion[6]) 
                && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la primera fila vetical.");
            return true;
            
        } else if ((posicion[1] == posicion[4]) && (posicion[4] == posicion[7]) 
                && (posicion[1] == 'X' || posicion[1] == 'O')) {
            System.out.println("Tres en raya! En la segunda fila vetical.");
            return true;
            
        } else if ((posicion[2] == posicion[5]) && (posicion[5] == posicion[8]) 
                && (posicion[2] == 'X' || posicion[2] == 'O')) {
            System.out.println("Tres en raya! En la tercera fila vetical.");
            return true;
            
        } else if ((posicion[0] == posicion[4]) && (posicion[4] == posicion[8]) 
                && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la diagonal descendente.");
            return true;
            
        } else if ((posicion[2] == posicion[4]) && (posicion[4] == posicion[6]) 
                && (posicion[2] == 'X' || posicion[2] == 'O')) {
            System.out.println("Tres en raya! En la diagonal ascendente.");
            return true;
        }
        return false;
    }

    /**
     * Método que analiza si quedan posiciones libres para seguir jugando
     * @return Devuelve un boolean si se dan las condiciones
     */
    public static boolean metodoEmpate() {

        //Recorremos el bucle buscando posiciones ocupadas
        for (int i = 0; i < posicion.length; i++) {
            if (!((posicion[i] == 'X') | (posicion[i] == 'O'))) {
                return false;
            }
        }
        //Aun quedan posiciones libres
        return true;
    }

    /**
     * Este método resetea los valores del array al valor original
     */
    public static void reset() {

        //recorremos todas las posiciones del array
        for (int i = 0; i < posicion.length; i++) {

            //En cada posicion ponemos el caracter correspondiente
            posicion[i] = (char) ((i + 1) + '0');
        }
    }
}