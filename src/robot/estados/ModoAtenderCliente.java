package robot.estados;

import robot.Robot;

/**
 * Clase que nos ayuda a representar el estado de un robot si llega
 * a estar en modo atendiendo cliente.
 */
public class ModoAtenderCliente implements EstadoRobot{
    
    /* El robot al que queremos poner en estado atendiendo */
    Robot robot;

    /**
     * Constructor publico para inicializar el estado del robot
     * @param robot El robot al que vamos a poner en modo atendiendo cliente.
     */
    public ModoAtenderCliente(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot ya esta activado en este modo.
     */
    public void activar(){
        System.out.println(MensajesComunes.yaEsta("activado"));
    }

    /**
     * El robot no puede caminar mientras está atendiendo al cliente ya que se 
     * encuentra frente a la mesa.
     */
    public void caminar(){
        System.out.println(MensajesComunes.noPuede("caminar", "atendiendo"));
        
    }

    /**
     * 
     * 
     */
    public void leerMenu(){
        //Aqui va tu codigo

    }

    /**
     * El robot no puede cocinar un platillo sin antes haber
     * recibido un pedido.
     */
    public void cocinarPedido(){
        System.out.println(MensajesComunes.noPuede("cocinar", "atendiendo")); 
    }

    /**
     * 
     */
    public void entregarPedido(){
        //Aqui va tu codigo

    }

    /**
     *  El robot no se puede suspender en este momento ya que 
     * se encuentra atendiendo al cliente.
     */
    public void suspender(){
        System.out.println(MensajesComunes.noPuede("suspenderme", "atendiendo"));
        
    }

}
