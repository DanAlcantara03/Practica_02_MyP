package robot.estados;

import java.util.Iterator;
import java.util.Scanner;

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
        if(robot.terminoPedido()){
            System.out.println("El robot no puede leer el menú ya que tiene que entregar el pedido hecho anteriormente.");
        }else{
            for(Menu menu: robot.getMenus()){
                Iterator<Hamburguesa> hamb = menu.createIterator();
                    System.out.println("======================================= " + menu.getNombreMenu().toUpperCase() + " =========================================\n");
                while(hamb.hasNext()){                
                    System.out.println(hamb.next().getHamburguesa());
                }
            }
            insertarPedido();
            System.out.println("\n******* El robot esta pasando, a modo cocinando. *******\n");
            robot.asignarEstado(robot.getModoCocinar());
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
            System.out.println("Aquí tiene su " + robot.getPedido().getNombre() + " que la disfrute. (: \n");
            System.out.println("\n******* El robot ah terminado el pedido y pasara a modo suspendido. *******\n");
            robot.asignarEstado(robot.getModoSuspender());
        }else{
            System.out.println("\nEl robot no puede entregar el pedido ya que no ah sido cocinado.\n");
        }
    }

    /**
     * El robot no se puede suspender en este momento ya que se encuentra atendiendo al cliente.
     */
    public void suspender(){
        System.out.println(MensajesComunes.noPuede("suspenderse", "atendiendo"));
    }

    /**
     * Metodo auxiliar para saber si el id del pedido que ingreso el
     * cliente es valido
     * @param id El id del pedido que escogio el cliente.
     * @return true si el id del pedido se encuentra dentro del menu, false
     * en otro caso.
     */
    private Hamburguesa idValido(int id){
        for(Menu menu: robot.getMenus()){
            Iterator<Hamburguesa> hamb = menu.createIterator();
            while(hamb.hasNext()){
                Hamburguesa t = hamb.next();
                if(t.getId() == id){
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * Metodo auxliar que nos ayuda a que el cliente pueda insertar correctamente su pedido
     */
    private void insertarPedido(){
        Scanner sc = new Scanner(System.in);
        Hamburguesa t;
        int id = 0;
        do{
            try{
                System.out.print("\nPor favor inserte el id del pedido que quiere hacer del menu: ");
                id = sc.nextInt();
            }catch(NumberFormatException e){}
            t = idValido(id);
        }while( t == null);
        robot.setPedido(t);
    }
}
