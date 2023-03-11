package robot.estados;

import java.util.Iterator;

import robot.Robot;
import robot.menus.Menu;
import robot.menus.hamburguesas.Hamburguesa;

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
     * Metodo que nos imprime en terminal todos los menus completos de los 
     * restaurantes.
     */
    public void leerMenu(){
        for(Menu menu: robot.getMenus()){
            Iterator<Hamburguesa> hamb = menu.createIterator();
            while(hamb.hasNext()){
                System.out.println("------------------------------------------------------");
                System.out.println("===============" + menu.getNombreMenu().toUpperCase() + "=================\n");
                System.out.println(hamb.next().getHamburguesa());
            }
        }
    }

    /**
     * El robot no puede cocinar un platillo sin antes haber recibido un pedido.
     */
    public void cocinarPedido(){
        System.out.println(MensajesComunes.noPuede("cocinar", "atendiendo")); 
    }

    /**
     * El robot entrega el pedido si y solo si el pedido ya ah sido cocinado.
     */
    public void entregarPedido(){
        if(robot.terminoPedido()){
            System.out.println("\n******* El robot ah terminado el pedido y pasara a modo suspendido. *******\n");
            robot.asignarEstado(robot.getModoSuspender());
        }else{
            System.out.println("\nEl robot no puede entregar el pedido ya que no ah sido cocinado.\n");
        }

    }

    /**
     * El robot no se puede suspender en este momento ya que 
     * se encuentra atendiendo al cliente.
     */
    public void suspender(){
        System.out.println(MensajesComunes.noPuede("suspenderme", "atendiendo"));
        
    }

}
