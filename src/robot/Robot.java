package robot;

import java.util.ArrayList;

import robot.menus.*;
import robot.estados.*;
/**
 * Clase Robot ...
 */
public class Robot{

    /* Son los menus que puede llegar a tener el restaurante y que va poder leer el
       robot */
    ArrayList<Menu> menus;
    /* Es el estado actual del robot */
    EstadoRobot estadoActual;
    /* Son los estados que puede tener el Robot */

    /**
     * Constructor que inicializa al robot 
     */
    public Robot(){
        
    }

}