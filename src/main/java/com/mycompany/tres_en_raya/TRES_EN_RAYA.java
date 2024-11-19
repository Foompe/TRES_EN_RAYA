/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tres_en_raya;

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a tres en raya");

        while (continuar) {

            //
            boolean jugadaAceptada = false;
            boolean ganador = false;

            System.out.println("Elige una opción: \n (1) Jugar 2 jugadores. \n (2) Jugar 1 jugador. \n (3) Salir.");
            //escaneamos la palabra de usuario ya que no podemos recoger directamente un char
            String palabra = sc.next();
            //sacamos el primer caracter del string
            char eleccionJuego = palabra.charAt(0);
            switch (eleccionJuego) {
                case '1': //jugador vs jugador
                    System.out.println("Has seleccionado 1vs1");

                    //falta meter un buble (con controlador de ganador)
                    estadoPartida(posicion);

                    //Bucle, cuando el metodo ganador detecte que un jugador ha ganado hara terminar la partida
                    while (!ganador) {
                        while (!jugadaAceptada) {
                            //Escoge jugador 1
                            System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
                            String j1jugada = sc.next();
                            char j1posicion = j1jugada.charAt(0);
                            jugadaAceptada = comprobarJugada(j1posicion);
                            intercambioPosicionX(j1posicion);
                            ganador = finPartida(j1posicion);
                        }

                        if (jugadaAceptada & !ganador) {
                            jugadaAceptada = false;
                            while (!jugadaAceptada) {
                                //jugador dos escoge
                                System.out.println("Jugador 2, escoge posición en el tablero! (1-9)");
                                String j2jugada = sc.next();
                                char j2posicion = j2jugada.charAt(0);
                                jugadaAceptada = comprobarJugada(j2posicion);
                                intercambioPosicionO(j2posicion);
                                ganador = finPartida(j2posicion);
                            }
                        }
                    }
                    //en funcion de si la seleccion es correcta continuaremos con la jugada.
                    break;
                case '2': //jugador vs maquina.
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
        //Pediente!! Comprobar si el valor esta dentro de los limites.
        
        
        
        //Convertimos char a int
        int numeroPosicion = posicionJugador - '0';

        //Recorremos el bucle
        for (int i = 0; i < posicion.length; i++) {

            //    
            if (i == (numeroPosicion - 1)) {

                if (posicion[i] == posicionJugador) {
                    System.out.println("Jugada correcta!");
                    return true;
                } else {
                    System.out.println("Jugada incorrecta!");
                    return false;
                }
            }
        }
        System.out.println("No es correcto ni incorrecto"); //Este mensaje no deberia salir nunca
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
    public static boolean finPartida(char posicionElegida) {

        //comprobar que es tres en raya o que no quedan mas sitios libres y por ende es empate
        //Comprobamos si en la primera linea horizontal son todos X u O 
        if ((posicion[0] == posicion[1]) && (posicion[1] == posicion[2]) && (posicion[0] == 'X' || posicion[0] == 'O')) {
            return true;
            //comprobamos la segunda fila horizontal    
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos la tercera fila horizontal
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos la primera fila vertical
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos la segunda fila vertical
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos la tercera fila vertical
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos una diagonal
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
            //comprobamos la segunda diagonal
        } else if ((posicion[3] == posicion[4]) && (posicion[4] == posicion[5]) && (posicion[3] == 'X' || posicion[3] == 'O')) {
            return true;
        }
            //comprobar si quedan posiciones libres
        for (int i = 0; i < posicion.length; i++) {
            //comprobamos si en la posicion del array hay una x u o, si no hay podemos continuar la partida
            if (!((posicion[i] == 'X') | (posicion[i] == 'O'))) { 
                return false; 
            }
        }
        System.out.println("Error en busqueda de tres en raya");
        return true;
    }
}
