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

    public static void main(String[] args) {

        boolean continuar = true; //inicializamos el controlador de nuestro buble
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Bienvenido a tres en raya");

        while (continuar) {
            System.out.println("Elige una opción: \n (1) Jugar 2 jugadores. \n (2) Jugar 1 jugador. \n (3) Salir.");
            String palabra = sc.next(); //escaneamos la palabra de usuario ya que no podemos recoger directamente un char
            char eleccionJuego = palabra.charAt(0); //sacamos el primer caracter del string
            switch (eleccionJuego) {
                case '1':
                    System.out.println("Has seleccionado 1vs1");
                    intercambioPosicion(); //llamamos al metodo logica juego para que muestre la puntuación en pantalla
                    seleccionJugada();
                    break;
                case '2':
                    System.out.println("Has seleccionado 1 vs maquina");
                    intercambioPosicion(); 
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
//metodo para mostrar la puntuación en pantalla

    public static void estadoPartida(char[] posicion) {
        
        //asignamos los valores del array para mostrarlos en pantalla
        char x1 = posicion[0]; 
        char x2 = posicion[1]; 
        char x3 = posicion[2]; 
        char x4 = posicion[3]; 
        char x5 = posicion[4]; 
        char x6 = posicion[5]; 
        char x7 = posicion[6]; 
        char x8 = posicion[7]; 
        char x9 = posicion[8];
        
        //componemos el mensaje que mostrara el estado de la partida
        System.out.println("\nEstado partida:\n\n   " + x1 + " | " + x2 + " | " + x3 + "\n -------------" + "\n   " + x4 + " | " + x5 + " | " + x6 + "\n -------------" + "\n   " + x7 + " | " + x8 + " | " + x9 + "\n");
    }
    
//metodo donde va la logica del juego
    public static void intercambioPosicion() {
        
        //valores de prueba que despues se tomaran de otro metodo
        char jugador1 = '2';
        char jugador2 = '6';
        char maquina = '8';
        //intercambio de valores para buscar en el array
        char x = jugador1;
        char o = jugador2;
        char y = maquina;
        //array que usaremos para las posiciones dentro del tablero.
        char[] posicion = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        //recorremos el array con el bucle, para buscar la seleccion del jugador e intercambiarla con su ficha
        for(int i = 0; i < posicion.length; i++) {
            if (posicion[i] == x) {
                posicion[i] = 'X';
            }
        }
        //llamamos al metodo estado partida y le pasamos el array
        estadoPartida(posicion);

    }
     public static void seleccionJugada(){
         
         Scanner sc = new Scanner(System.in);
         //preguntar por la jugada a seleccionar
         System.out.println("Jugador 1, escoge posición en el tablero! (1-9)");
         String jugada = sc.next();
         char j1posicion = jugada.charAt(0);
         System.out.println("ho  la");
         //comprobar si esa jugada es correcta
         //ver si la posicion escogida no esta tomada de antes
     }

}