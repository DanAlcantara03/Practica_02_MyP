package robot.estados;

import robot.Robot;

/**
 * Clase que nos ayuda a representar el estado de un robot si llega
 * a estar en modo caminando.
 */
public class ModoCaminar implements EstadoRobot{
    
    /* El robot al que queremos poner en estado caminando */
    Robot robot;

    /**
     * Constructor publico para inicializar el estado del robot
     * @param robot El robot al que vamos a poner en modo caminando.
     */
    public ModoCaminar(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot ya esta activado en este modo.
     */
    public void activar(){
        System.out.println(MensajesComunes.yaEsta("activado"));
    }

    /**
     * Metodo que nos ayuda a que el robot llegue a la mesa del cliente
     * para poder atenderlo.
     */
    public void caminar(){
      //Aqui va tu codigo  
    }

    /**
     * El robot no puede leer el menú, antes debe llegar a la mesa
     * en donde se encuentra el cliente.
     */
    public void leerMenu(){
        System.out.println(MensajesComunes.noPuede("leer menu", "caminar"));
    }

    /**
     * El robot no puede cocinar mientras camina.
     */
    public void cocinarPedido(){
            System.out.println(MensajesComunes.noPuede("cocinar", "caminar"));
    }

    /**
     * El robot no puede entregar el pedido sin antes haber llegado a
     * la mesa del cliente, haber recibido un pedido y cocinarlo.
     */
    public void entregarPedido(){
        System.out.println(MensajesComunes.noPuede("entregar pedido", "caminar"));
    }

    /**
     *  
     */
    public void suspender(){
        //Aqui va tu codigo
    }

}
