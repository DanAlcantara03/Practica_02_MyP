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
     * Metodo que nos ayuda a activar el robot solo en este modo, i.e.
     * solo mientras está suspendido.
     */
    public void activar(){
        System.out.println("\n******* El robot esta pasando a modo, caminar. *******\n");
        robot.recibirMesa(null);
        robot.asignarEstado(robot.getModoCaminar());
    }

    /**
     * El robot no puede caminar mientras esta suspendido, antes se tiene
     * que activar
     */
    public void caminar(){
        System.out.println(MensajesComunes.noPuede("caminar","suspendido"));
    }

    /**
     * El robot no puede leer el menu mientras esta suspendido, antes se tiene
     * que activar, y tiene que llegar a la mesa.
     */
    public void leerMenu(){
        System.out.println(MensajesComunes.noPuede("leerMenu","suspendido"));
    }

    /**
     * El robot no puede cocinar un pedido mientras esta suspendido, antes se tiene
     * que activar, llegar a la mesa, leer el menu y pregutnarle que quiere de comer
     * al cliente.
     */
    public void cocinarPedido(){
        System.out.println(MensajesComunes.noPuede("cocinar","suspendido"));
    }

    /**
     * El robot no puede cocinar un pedido mientras esta suspendido, antes se tiene
     * que activar, llegar a la mesa, leer el menu, preguntarle que quiere de comer
     * al cliente y cocinar el pedido.
     */
    public void entregarPedido(){
        System.out.println(MensajesComunes.noPuede("Entregar el Pedido","suspendido"));
    }

    /**
     * El robot no se puede suspender por que actualmente ya esta suspendido.
     */
    public void suspender(){
        System.out.println(MensajesComunes.yaEsta("suspendido"));
    }

}
