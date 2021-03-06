/*
 * Proyecto JuegoPiedraPapelTijeras - Archivo JuegoPiedraPapelTijeras.java - Compañía DAW
 * License Creative Commons BY-NC-SA 4.0
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package juegopiedrapapeltijeras;

import java.util.Scanner;

/**
 *
 * @author Cristina Carrascosa Torres <cctausias@gmail.com>
 * @version 1.0
 * @date 2 dic. 2021 19:26:09
 */
public class JuegoPiedraPapelTijeras_Final {
    public static void main(String[] args) {
        // Creo Scanner
        Scanner sc = new Scanner(System.in);

        // Variables y Arrays
        
        String[] jugadores; // Array que almacenará el nombre de los jugadores
        int[] puntuaciones; // Array que almacenará las puntuaciones
        int cuantosJugadores; // para crear el tamaño del array de los jugadores
        boolean opcionCorrecta = true; // Para que el jugador introduzca la opción correcta

        System.out.println("----------------------------");
        System.out.println("Juego Piedra Papel o Tijeras");
        System.out.println("----------------------------");
        System.out.println("");

        // Preguntamos cuantos van a ser para establecer el tamaño del Array jugadores y puntuaciones
        System.out.print("¿Cuántos jugadores se enfrentarán a la máquina?: ");
        cuantosJugadores = sc.nextInt();
        jugadores = new String[cuantosJugadores];
        puntuaciones = new int[cuantosJugadores];
        sc.nextLine();

        // Con un for se van registrando los jugadores
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("Nombre: ");
            jugadores[i] = sc.nextLine();
        }

        System.out.println("");
        System.out.println("------- LISTADO -------");
        // Mostramos el listado de jugadores
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(i + ": " + jugadores[i]);
        }

        System.out.println("************ EMPECEMOS ************");

        // El jugador elije opción y nos aseguramos que esté en rango con la función pedirIntEnRango
        System.out.println("Empecemos!, Elija una opcion (1)Piedra, (2) Papel o (3) Tijeras.");
        



        //Función que ejecuta el juego
        juego(cuantosJugadores, jugadores, puntuaciones);



    }

    public static void juego(int cuantosJugadores, String[] jugadores, int[] puntuaciones){
      // Llamamos a la función ronda
      for (int i = 0; i < cuantosJugadores; i++ ) {
        puntuaciones[i] = ronda(jugadores[i]);
      }
      for (int i = 0; i < cuantosJugadores; i++ ) {
        System.out.println("Jugador: " + jugadores[i] + ": " + puntuaciones[i]);
      }

      //Calculamos el ganador y en caso de empate, volvemos a jugar.
      int maxima = 0;
      int ganador = -1; // con el -1 no habrá ningún ganador hasta que no se ejecute el for, ya que no hay ningún jugador -1
      boolean empate = false;
      // Este for va recorriendo el array puntuaciones i comparandolas, quedándose así con la puntuación mas elevada
      for (int i = 0; i < cuantosJugadores; i++) {
          if (puntuaciones[i] > maxima) {
            maxima = puntuaciones[i];
            ganador = i;
        } else if (puntuaciones[i] == maxima){
            empate = true;
            System.out.println("Se vuelve a jugar: ");
            System.out.println("------------------");
            juego(cuantosJugadores, jugadores, puntuaciones);
        }
      }

      if (empate) {
        System.out.println("Se ha producido un empate. Volved a jugar!");
      } else {
        System.out.println("El ganador es: " + jugadores[ganador] + " con una puntuación de " + maxima + " puntos");
      }
    }

    // En una ronda se juegan 5 manos y se guarda la puntuación
    public static int ronda (String jugador){
        int jugadas = 0;
        int totalpuntos = 0;
        int eleccionJug = 0;
        do {
            System.out.println("Está jugando: " + jugador);
            eleccionJug = pedirIntEnRango(1, 3);
            totalpuntos /*puntos de la función ronda */ += mano(eleccionJug); //puntos de la función mano()
           
            System.out.println("Tienes: "+totalpuntos+" puntos.");
            jugadas +=1;
        } while (jugadas < 5);
        return totalpuntos;
    }
    // Juega una mano contra la máquina y devuelve los puntos obtenidos
    public static int mano(int eleccionJug) {
        // Array que almacena las opciones
        String elementos[] = {"", "Piedra", "Papel", "Tijeras"};
        int eleccionPc; // Variable que almacenará la elección de la máquina
        int puntos = 0; // Almacenará los puntos obtenidos en una mano

        // El pc elije
        eleccionPc = (int)(Math.random() * 3) + 1;
        if (eleccionJug == eleccionPc) {
            puntos = puntos + 1;
            System.out.println("La maquina a elegido " + elementos[eleccionPc] + " y usted a elegido " + elementos[eleccionJug] + ". EMPATE!");
            System.out.println("Obtienes 1 punto :)");
        }
        if ((eleccionPc == 1 && eleccionJug == 3) || (eleccionPc == 2 && eleccionJug == 1) || (eleccionPc == 3 && eleccionJug == 2)) { //Comprobamos si la maquina ha ganado
            System.out.println("La maquina ha elegido " + elementos[eleccionPc] + " y usted ha elegido " + elementos[eleccionJug] + ". HA PERDIDO! ;(");
            System.out.println("No obtienes ningún punto" + " :(");
        } else {
            puntos = puntos + 2;
            System.out.println("La maquina ha elegido " + elementos[eleccionPc] + " y usted ha elegido " + elementos[eleccionJug] + ". HA GANADO! :)");
            System.out.println("Obtienes 2 puntos");
        }
        return puntos;
    }
     // Pide al usuario una opción de tipo int, una y otra vez hasta que responde con una opción que esté dentro del rango
    public static int pedirIntEnRango(int min, int max) {

        Scanner in = new Scanner(System.in);
        int valor;

        do {
            System.out.print("Elige opción entre " + min + " y " + max + ": ");
            valor = in.nextInt();
            if (valor < min || valor > max) {
                System.out.println("AVISO: Opción no válido.");
            }
        } while (valor < min || valor > max);

        return valor;
    }

}
