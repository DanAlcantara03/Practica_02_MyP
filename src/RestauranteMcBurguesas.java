import java.util.Scanner;

import robot.Robot;

/**
 * Clase main que nos ayuda a probar el robot que creamos para el restaurante McBurguesas
 * Este main nos ayuda a simular varias situaciones 
 */
public class RestauranteMcBurguesas{
    public static void main( String [] args ){
        /* El robot que va a estar en el restaurante */
        Robot robotRestaurante = new Robot();
        /* El scanner que va a leer todo lo que incerte el usuario. */
        Scanner sc = new Scanner(System.in);
        /* Las opciones posibles que puede incertar el usuario */
        int opcion;

        System.out.println("### Bienvenido al restaurante McBurguesas. ###"
                        + "\nPor favor dele alguna instrucción al robot.\n");
        do{
            System.out.println(robotRestaurante.robotOpciones());
            while(true){
                try{
                    opcion = Integer.parseInt(sc.nextLine());
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Por favor ingrese una opción válida.\n"
                    + robotRestaurante.robotOpciones());
                }
            }

            switch(opcion){
                case 1: 
                    robotRestaurante.activar();
                    break;
                case 2:
                    robotRestaurante.caminar();
                    break;
                case 3:
                    robotRestaurante.leerMenu();
                    break;
                case 4:
                    robotRestaurante.cocinar();
                    break;
                case 5:
                    robotRestaurante.entregarPedido();
                    break;
                case 6:
                    robotRestaurante.suspender();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Por favor ingrese una instrucción valida.\n");
                    break;
            }
        }while(opcion != 0);
    }
}