package robot.estados;

import robot.Robot;

/**
 * Clase que nos ayuda a representar el estado de un robot si llega
 * a estar en modo suspendido.
 */
public class ModoSuspendido implements EstadoRobot{
    
    /* El robot al que queremos poner en estado suspendido */
    Robot robot;

    /**
     * Constructor publico para inicializar el estado del robot
     * @param robot El robot al que vamos a poner en modod suspendidio.
     */
    public ModoSuspendido(Robot robot){
        this.robot = robot;
    }

    /**
     * 
     */
    public void activar(){
        
    }
}
