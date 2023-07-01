package main;

import main.modelo.User;

import java.util.Scanner;

/**
 * TEMPORAL PARA LEER CONSOLA INPUTS Y MOSTRAR MENUS
*/
public class EntradaSalida {

    private static final Scanner ENTRADA = new Scanner(System.in);

    public static String leerString(){
        return ENTRADA.nextLine();
    }

    public static boolean leerBoolean(){
        return ENTRADA.nextBoolean(); //Only for true|false
    }

    //Leer Entero
    public static int leerEntero(){
        int i;
        try {
            i = ENTRADA.nextInt();
        }catch (Exception e){
            //El valor ingresado no es un entero. Intente nuevamente.
            mostrarString(ConsoleText.ERROR_INT_EXPECTED_RETRY);
            i = leerEntero();
        }
        leerString();
        return i;
    }

    public static void mostrarString(String s){
        System.out.println(s);
    }



}
