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

    //array que usaremos para las posiciones dentro del tablero.

        
    public static void main(String[] args) {
        boolean jugadaAceptada;
        boolean continuar = true; //inicializamos el controlador de nuestro buble
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Bienvenido a tres en raya");

        while (continuar) {
            
            //creamos al array con las posiciones dentro del tablero
            char[] posicion = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            
            
            System.out.println("Elige una opción: \n (1) Jugar 2 jugadores. \n (2) Jugar 1 jugador. \n (3) Salir.");
            String palabra = sc.next(); //escaneamos la palabra de usuario ya que no podemos recoger directamente un char
            char eleccionJuego = palabra.charAt(0); //sacamos el primer caracter del string
            switch (eleccionJuego) {
                case '1': //jugador vs jugador
                    System.out.println("Has seleccionado 1vs1");
                    
                    //falta meter un buble (con controlador de ganador)
                    estadoPartida(posicion); 
                    //Escoge jugador 1
                    System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
                    String j1jugada = sc.next();
                    char j1posicion = j1jugada.charAt(0);
                   
                    //jugador dos escoge
                    System.out.println("Jugador 2, escoge posición en el tablero! (1-9)");
                    String j2jugada = sc.next();
                    char j2posicion = j2jugada.charAt(0);
                    jugadaAceptada = comprobarJugada(posicion, j1posicion, j2posicion);
                    
                    //en funcion de si la seleccion es correcta continuaremos con la jugada.
                    if (jugadaAceptada){
                        
                        System.out.println("Entra al bucle");
                        //cambiamos los valores elegidos por sus fichas
                    intercambioPosicion(posicion, j1posicion, j2posicion);
                    
                    estadoPartida(posicion);
                    }
                    System.out.println("no entra al bucle");
                    
                    
                    //pendientes: bucle, hacer turnos.
                    break;
                case '2': //jugador vs maquina.
                    System.out.println("Has seleccionado 1 vs maquina");
                    
                    //falta meter un buble (con controlador de ganador)
                    
                    //Escoge jugador 1 (buscar solucion al repetir nombre de variable
                    System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
                    
                    //char j1posicionM = jugada.charAt(0);
                    
                    //jugador dos escoge
                    System.out.println("Jugador 2, escoge posición en el tablero! (1-9)");
                    
                    
                    
                    
                    
                    
                    
                    
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
    
    //metodo para mostrar la puntuación en pantalla (se puede meter comprobacion ganador?)
    public static void estadoPartida(char[] posicion) { //es necesario un metodo para esto?
        System.out.println("\nEstado partida:\n\n   " + posicion[0] + " | " + posicion[1] + " | " + posicion[2] + "\n -------------" + "\n   " + posicion[3] + " | " + posicion[4] + " | " + posicion[5] + "\n -------------" + "\n   " + posicion[6] + " | " + posicion[7] + " | " + posicion[8] + "\n");
    }
    
    
    //metodo para comprobar que la posicion escogida no esta ocupada
    public static boolean comprobarJugada(char[] posicion, char j1posicion, char j2posicion) {
        /**
         * A corregir:
         *  comprobar que los valores de lo jugadores esten dentro del rango
         *  pasar las elecciones de jugador de char a int
         *  hacer coincidir la eleccion del jugador con su posicion dentro del indice del array
         *  comprobar que el valor que posee el indice no sea ni una 'X' ni una 'O'
         *  retornar el valor para poder continuar
         */
        //creamos un validador de jugada
        boolean jugadaValida = true;
        
        //comparamos las jugadas
        if (j1posicion != j2posicion) {
             
             //recorremos el array
            for(int i = 0; i < posicion.length; i++) {
                
                //buscamos si esta libre la posicion elegida(si no, suponemos o que esta ocupada o no es un valor correcto)
                if(posicion[i] == j1posicion) {
                    System.out.println("Posición valida! Jugador 1 ha escogido: " + j1posicion);
                } else if(posicion[i] == j2posicion) {
                    System.out.println("Posición valida! Jugador 2 ha escogido: " + j2posicion);
                } else {
                System.out.println("Posicion ocupada o valor incorrecto!");
                jugadaValida = false;
                }
            }           
        } else {
             System.out.println("No valido la selección es la misma! Intentalo de nuevo!");
             jugadaValida = false;
        }
        
        //devolvemos el valor del validador de jugada
        return jugadaValida;
    }    
    

//metodo donde va la logica del juego (puede que sea necesario hacer un metodo diferente para cada jugador
    public static void intercambioPosicion(char[] posicion, char j1posicion, char j2posicion) {
        
        //cambio eleccion jugador 1 por una X
        for(int x = 0; x < posicion.length; x++) {
            if (posicion[x] == j1posicion) {
                posicion[x] = 'X';
            }
        }
        //cambio eleccion jugador 2 por una Y
        for(int o = 0; o < posicion.length; o++) {
            if (posicion[o] == j2posicion) {
                posicion[o] = 'O';
            }
        }
    }
}