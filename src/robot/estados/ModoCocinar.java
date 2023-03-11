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
     * El robot no puede cocinar mientras camina.
     */
    public void caminar(){
        System.out.println(MensajesComunes.noPuede("caminar", "cocinar"));
    }

    /**
     * El robot no puede leer el menu ya que se encuentra cocinando
     * un pedido que se le hizo con anterioridad.
     */
    public void leerMenu(){
        System.out.println(MensajesComunes.noPuede("leer menu", "cocinar"));  
    }

    /**
     * 
     */
    public void cocinarPedido(){
        
    }

    /**
     * El robot no puede entregar el pedido sin haber acabado de cocinarlo
     * antes.
     */
    public void entregarPedido(){
        System.out.println(MensajesComunes.noPuede("entregar pedido", "cocinar"));
    }

    /**
     *  El robot no se puede suspender mientras está cocinando un pedido, primero 
     * deberá terminar de cocinar y atender al cliente.
     */
    public void suspender(){
        System.out.println(MensajesComunes.noPuede("suspender", "cocinar"));
    }

}
