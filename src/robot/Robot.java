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
    private ArrayList<Menu> menus;
    /* Es el estado actual del robot */
    private EstadoRobot estadoActual;
    /* Son los estados que puede tener el Robot */
    private EstadoRobot modoSuspendido;
    private EstadoRobot modoCaminar;
    private EstadoRobot modoAtenderCliente;
    private EstadoRobot modoCocinar;

    /**
     * Constructor que inicializa al robot y todos sus parametros.
     */
    public Robot(){
        
    }

    /**
     * Metodo que nos ayuda a asignar un estado al robot
     * @param estado El estado que se le quiere asignar al robot
     */
    public void asignarEstado(EstadoRobot estado){
        estadoActual = estado;
    }

}