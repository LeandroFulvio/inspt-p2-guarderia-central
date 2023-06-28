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
        return ENTRADA.nextInt();
    }

    public static void mostrarString(String s){
        System.out.println(s);
    }



}
