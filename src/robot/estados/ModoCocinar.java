package robot.estados;

import robot.Robot;

/**
 * Clase que nos ayuda a representar el estado de un robot si llega
 * a estar en modo cocinando.
 */
public class ModoCocinar implements EstadoRobot{
    
    /* El robot al que queremos poner en estado cocinando */
    Robot robot;

    /**
     * Constructor publico para inicializar el estado del robot
     * @param robot El robot al que vamos a poner en modo cocinando.
     */
    public ModoCocinar(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot ya esta activado en este modo.
     */
    public void activar(){
        System.out.println(MensajesComunes.yaEsta("activado"));
    }

    /**
     * 
     */
    public void caminar(){
        
    }

    /**
     * 
     */
    public void leerMenu(){
        
    }

    /**
     * 
     */
    public void cocinarPedido(){
        
    }

    /**
     * 
     */
    public void entregarPedido(){

    }

    /**
     *  
     */
    public void suspender(){
        
    }

}
