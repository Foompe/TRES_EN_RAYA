/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tres_en_raya;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author FP Multip Al iniciar el juego nos aparecerá un menú. Este menú saldrá
 * al iniciar el juego y cada vez que se acabe una partida. Nos mostrará las
 * siguientes opciones: Jugar 2 jugadores. Jugar 1 jugador (contra la máquina)
 * Salir Al iniciar el juego nos mostrará en modo texto en la pantalla la
 * situación de la partida. Las posiciones de un jugador se marcará con una X y
 * la del otro jugador con O. Se irán alternando los turnos entre los jugadores,
 * y se comprobará que la jugada de cada uno de ellos es una posición correcta.
 * Si no lo es, se avisará al jugador. Cuando un jugador haga tres en raya, se
 * felicitará al jugador ganador y se volverá al menú inicial. En la opción de
 * un jugador, la máquina elegirá su posición aleatoriamente.
 */
public class TRES_EN_RAYA {

    //creamos al array con las posiciones dentro del tablero
    static char[] posicion = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {

        boolean continuar = true; //inicializamos el controlador de nuestro buble
        Scanner sc = new Scanner(System.in); //inicializamos el scanner

        System.out.println("Bienvenido a tres en raya");

        while (continuar) {

            //inicializamos los controladores para los bucles
            boolean ganador = false;
            boolean empate = false;

            //metodo para resetear los valores
            reset();

            System.out.println("Elige una opción: \n (1) Jugar 2 jugadores. \n (2) Jugar 1 jugador (contra la máquina) \n (3) Salir.");
            //escaneamos la palabra de usuario ya que no podemos recoger directamente un char
            String palabra = sc.next();
            //sacamos el primer caracter del string
            char eleccionJuego = palabra.charAt(0);
            switch (eleccionJuego) {
                case '1': //jugador vs jugador
                    System.out.println("Has seleccionado: Jugador contra jugador.");

                    //falta meter un buble (con controlador de ganador)
                    estadoPartida(posicion);

                    //Bucle, que detecta cuando hay un ganador o un empate
                    while (!ganador && !empate) {

                        //iniciamos los controladores para los bucles
                        boolean jugadaAceptada = false;

                        while (!jugadaAceptada) {
                            //Escoge jugador 1
                            System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
                            String j1jugada = sc.next();
                            char j1posicion = j1jugada.charAt(0);
                            jugadaAceptada = comprobarJugada(j1posicion);

                            //Si la jugada es correcta, se pone la posicion en el tablero
                            if (jugadaAceptada) {
                                intercambioPosicionX(j1posicion);
                                estadoPartida(posicion);
                                ganador = tresEnRaya(j1posicion);
                                empate = metodoEmpate(j1posicion);

                                //Si se confima que hay tres en raya muestra el mensaje de ganador.
                                if (ganador) {
                                    System.out.println("Jugador uno gana la partida!!");
                                }
                            } else {
                                System.out.println("Jugador uno, tu seleccion no es correcta! Intentalo de nuevo.");
                            }
                        }

                        //Comprobamos si podemos pasar al jugador dos, si la jugada es correcta y no hay ni ganador ni empate
                        if ((jugadaAceptada && !ganador) && (jugadaAceptada && !empate)) {

                            //reinicio el valor de jugada aceptada para el jugador 2
                            jugadaAceptada = false;
                            while (!jugadaAceptada) {
                                //jugador dos escoge
                                System.out.println("Jugador 2, escoge posición en el tablero! (1-9)");
                                String j2jugada = sc.next();
                                char j2posicion = j2jugada.charAt(0);
                                jugadaAceptada = comprobarJugada(j2posicion);

                                if (jugadaAceptada) {
                                    intercambioPosicionO(j2posicion);
                                    estadoPartida(posicion);
                                    ganador = tresEnRaya(j2posicion);
                                    empate = metodoEmpate(j2posicion);

                                    if (ganador) {
                                        System.out.println("Jugador dos gana la partida!!");
                                    }
                                } else {
                                    System.out.println("Jugador dos, tu seleccion no es correcta! Intentalo de nuevo.");
                                }
                            }
                        }
                    }
                    //en funcion de si la seleccion es correcta continuaremos con la jugada.
                    break;
                case '2': //jugador vs maquina.

                    System.out.println("Has seleccionado: Jugador contra máquina.");

                    //falta meter un buble (con controlador de ganador)
                    estadoPartida(posicion);

                    //Bucle, que detecta cuando hay un ganador o un empate
                    while (!ganador && empate) {

                        //iniciamos los controladores para los bucles
                        boolean jugadaAceptada = false;

                        while (!jugadaAceptada) {
                            //Escoge jugador 1
                            System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
                            String j1jugada = sc.next();
                            char j1posicion = j1jugada.charAt(0);
                            jugadaAceptada = comprobarJugada(j1posicion);

                            //Si la jugada es correcta, se pone la posicion en el tablero
                            if (jugadaAceptada) {
                                intercambioPosicionX(j1posicion);
                                estadoPartida(posicion);
                                ganador = tresEnRaya(j1posicion);
                                empate = metodoEmpate(j1posicion);

                                //Si se confima que hay tres en raya muestra el mensaje de ganador.
                                if (ganador) {
                                    System.out.println("Jugador uno gana la partida!!");
                                }
                            } else {
                                System.out.println("Jugador uno, tu seleccion no es correcta! Intentalo de nuevo.");
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
                                    intercambioPosicionO(maquinaPosicion);
                                    estadoPartida(posicion);
                                    ganador = tresEnRaya(maquinaPosicion);
                                    empate = metodoEmpate(maquinaPosicion);

                                    if (ganador) {
                                        System.out.println("La máquina ha ganado la partida!!");
                                    }
                                }
                            }
                        }
                    }

                    break;
                case '3':
                    System.out.println("Has seleccionado salir");
                    continuar = false;
                    break;
                default:
                    System.out.println("Selección erronea");
                    break;
            }
        }
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        sc.close();
    }

    //metodo para mostrar la puntuación en pantalla (¿es necesario?)
    public static void estadoPartida(char[] posicion) { //es necesario un metodo para esto?
        System.out.println("\nEstado partida:\n\n   " + posicion[0] + " | " + posicion[1] + " | " + posicion[2] + "\n -------------" + "\n   " + posicion[3] + " | " + posicion[4] + " | " + posicion[5] + "\n -------------" + "\n   " + posicion[6] + " | " + posicion[7] + " | " + posicion[8] + "\n");
    }

    //metodo para comprobar que la posicion escogida no esta ocupada
    public static boolean comprobarJugada(char posicionJugador) {

        //Comprobamos si el valor esta dentro de los limites del campo
        if ((posicionJugador == '1') | (posicionJugador == '2') | (posicionJugador == '3') | (posicionJugador == '4') | (posicionJugador == '5') | (posicionJugador == '6') | (posicionJugador == '7') | (posicionJugador == '8') | (posicionJugador == '9')) {
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

    //metodo para cambiar la eleccion por una X
    public static void intercambioPosicionX(char posicionElegida) {
        //cambio eleccion jugador por una X
        for (int x = 0; x < posicion.length; x++) {
            if (posicion[x] == posicionElegida) {
                posicion[x] = 'X';
            }
        }
    }

    //metodo para cambiar la eleccion por una O
    public static void intercambioPosicionO(char posicionElegida) {
        //cambio eleccion jugador por una X
        for (int x = 0; x < posicion.length; x++) {
            if (posicion[x] == posicionElegida) {
                posicion[x] = 'O';
            }
        }
    }

    //metodo para comprobar tres en raya o empate.
    public static boolean tresEnRaya(char posicionElegida) {

        //comprobar que es tres en raya o que no quedan mas sitios libres y por ende es empate
        //Comprobamos si en la primera linea horizontal son todos X u O 
        if ((posicion[0] == posicion[1]) && (posicion[1] == posicion[2]) && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la primera fila horizontal.");
            return true;
            //comprobamos la segunda fila horizontal    
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            System.out.println("Tres en raya! En la segunda fila horizontal.");
            return true;
            //comprobamos la tercera fila horizontal
        } else if ((posicion[6] == posicion[7]) && (posicion[7] == posicion[8]) && (posicion[6] == 'X' || posicion[6] == 'O')) {
            System.out.println("Tres en raya! En la tercera fila horizontal.");
            return true;
            //comprobamos la primera fila vertical
        } else if ((posicion[0] == posicion[3]) && (posicion[3] == posicion[6]) && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la primera fila vetical.");
            return true;
            //comprobamos la segunda fila vertical
        } else if ((posicion[1] == posicion[4]) && (posicion[4] == posicion[7]) && (posicion[1] == 'X' || posicion[1] == 'O')) {
            System.out.println("Tres en raya! En la segunda fila vetical.");
            return true;
            //comprobamos la tercera fila vertical
        } else if ((posicion[2] == posicion[5]) && (posicion[5] == posicion[8]) && (posicion[2] == 'X' || posicion[2] == 'O')) {
            System.out.println("Tres en raya! En la tercera fila vetical.");
            return true;
            //comprobamos una diagonal
        } else if ((posicion[0] == posicion[4]) && (posicion[4] == posicion[8]) && (posicion[0] == 'X' || posicion[0] == 'O')) {
            System.out.println("Tres en raya! En la diagonal descendente.");
            return true;
            //comprobamos la segunda diagonal
        } else if ((posicion[2] == posicion[4]) && (posicion[4] == posicion[6]) && (posicion[2] == 'X' || posicion[2] == 'O')) {
            System.out.println("Tres en raya! En la diagonal ascendente.");
            return true;
        }
        return false;
    }

    //metodo para indicar un empate
    public static boolean metodoEmpate(char eleccion) {
        for (int i = 0; i < posicion.length; i++) {

            //comprobamos si en la posicion del array hay una x u o, si no hay podemos continuar la partida
            if (!((posicion[i] == 'X') | (posicion[i] == 'O'))) {
                return false;
            }
        }
        //Al no entrar a ningun bucle entendemos que no hay ningun tres en raya ni ningun espacio libre disponible
        System.out.println("Empate! no quedan posiciones libres.");
        return true;
    }

    //metodo para resetear los valores del array para poder jugar mas de una partida
    public static void reset() {

        //recorremos todas las posiciones del array
        for (int i = 0; i < posicion.length; i++) {

            //En cada posicion ponemos el caracter correspondiente
            posicion[i] = (char) ((i + 1) + '0');
        }
    }
}
