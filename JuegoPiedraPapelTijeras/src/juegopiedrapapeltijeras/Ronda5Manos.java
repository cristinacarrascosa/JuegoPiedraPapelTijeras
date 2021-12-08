/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopiedrapapeltijeras;

import java.util.Scanner;

/**
 *
 * @author carra
 */
public class Ronda5Manos {
    public static void main(String[] args) {
        ronda5manos(5);
    }
    public static int ronda5manos (int jugadas){
        System.out.print("Elige opcion: ");
        int eleccionJug = 0;
        int puntos = 0;
        jugadas = 0;
        do {            
            mano(eleccionJug);
            jugadas += 1;
        } while (jugadas<=5);
        System.out.println(puntos);
        return puntos;
    }
    public static void mano(int eleccionJug) {
        // Variables y Arrays
        String elementos[] = {"", "Piedra", "Papel", "Tijeras"};//Array para guardar opciones
        Scanner sc = new Scanner(System.in);
        
        int eleccionPc;
        int puntos = 0;
        System.out.println("Empecemos!, Elija una opcion (1)Piedra, (2) Papel o (3) Tijeras.");
        eleccionJug = sc.nextInt();
        if ((eleccionJug < 1 || eleccionJug > 3)) { //Comprobamos que la opción elegida no supere el rango del 1 al 3.            
            System.out.println("Opcion incorrecta!, Elija otra vez, (1)Piedra, (2) Papel o (3) Tijeras.");
            eleccionJug = sc.nextInt();
        } else {
            eleccionPc = (int) (Math.random() * 3 + 1); //Obtenemos un número aleatorio del 1 al 3
            if (eleccionPc == eleccionJug) { //Comprobamos si se ha producido un empate
                System.out.println("La maquina a elegido " + elementos[eleccionPc] + " y usted a elegido " + elementos[eleccionJug] + ". EMPATE!");
                System.out.println("GANA 1 PUNTO");
                puntos += 1;
            } else {
                if ((eleccionPc == 1 && eleccionJug == 3) || (eleccionPc == 2 && eleccionJug == 1) || (eleccionPc == 3 && eleccionJug == 2)) { //Comprobamos si la maquina ha ganado
                    System.out.println("La maquina ha elegido " + elementos[eleccionPc] + " y usted ha elegido " + elementos[eleccionJug] + ". HA PERDIDO!");
                    
                } else {
                    System.out.println("La maquina ha elegido " + elementos[eleccionPc] + " y usted ha elegido " + elementos[eleccionJug] + ". HA GANADO!");
                    System.out.println("GANA 2 PUNTOS");
                    puntos += 2;
                }
                
            }
            
        }
        
    }
    
}
