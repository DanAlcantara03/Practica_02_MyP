package robot;

import java.util.ArrayList;

import robot.menus.*;
import robot.menus.hamburguesas.Hamburguesa;
import robot.estados.*;

/**
 * Clase Robot que nos da un robot que hace de mesero y cocinero
 * para un restaurante.
 */
public class Robot{

    /* Los pasos que tiene que dar el robot para llegr a la mesa del cliente. */
    private int pasos;
    /* Es el id del pedido que le han hecho al robot para que lo pueda cocinar. */
    private Hamburguesa pedido;
    /* Nos ayuda a saber si el robot llego a la mesa */
    private boolean llegoALaMesa;
    /* Nos ayuda a saber si el robot ya recibio un pedido, y ademas ver si dicho
    pedido es correcto*/
    private boolean pedidoRecibido;
    /* Nos ayuda a saber si el robot termino de cocinar el Pedido */
    private boolean terminoPedido;
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
        /* Son los pasos que el robot tiene que dar para llegar a la mesa. */
        inicializarParams();
        estadoActual = new ModoSuspendido(this);
        /* Inicializamos todos los estados del robot con el propio robot. */
        modoSuspendido = new ModoSuspendido(this);
        modoCaminar = new ModoCaminar(this);
        modoAtenderCliente = new ModoAtenderCliente(this);
        modoCocinar = new ModoCocinar(this);
        /* Inicializamos y agregamos los menus a la lista de menus. */
        menus = new ArrayList<Menu>();
        menus.add(new MenuHamburguesas());
        menus.add(new MenuDelDia());
        menus.add(new MenuEspecial());
    }

    /* Metodos con las acciones que puede realizar el robot en general */

    /**
     * Metodo que activa, al robot si el estado actual es supendido, en otros casos
     * manda un mensaje de que no puede realizar dicha acción.
     */
    public void activar(){
        estadoActual.activar();
    }
    
    /**
     * Metodo que hace que el robot camine hasta la mesa del cliente, si esta en
     * estado caminando, en otros casos manda un mensaje de que no puede realizar
     * dicha acción.
     */
    public void caminar(){
        estadoActual.caminar();
    }

    /**
     * Metodo que hace que el robot nos lea todo el menu, si esta en el Modo 
     * AtenderCliente, y ademas hace que el cliente incerte algúna opción de dicho
     * menu para despues cocinarlo y posteriormente entregarlo.
     */
    public void leerMenu(){
        estadoActual.leerMenu();
    }

    /**
     * Metodo que hace que el robot cocine el Pedido dado por el usuario.
     */
    public void cocinar(){
        estadoActual.cocinarPedido();
    }

    /**
     * Metodo que hace que el robot entregue el Pedido, solo si ya lo termino de
     * cocinar y esta en el Modo atenderCliente.
     */
    public void entregarPedido(){
        estadoActual.entregarPedido();
    }

    /**
     * Metodo que hace que el robot se suspenda solo si esta en el modo caminando, o
     * si ya termino de cocinar y entrego el Pedido del cliente.
     */
    public void suspender(){
        estadoActual.suspender();
    }

    /* Metodos para obtener información del robot y asignar estados */

    /**
     * Metodo que nos ayuda a saber si el robot llego a la mesa.
     * @return True si el robot llego a la mesa, false en otro caso.
     */
    public boolean llegoALaMesa(){
        return llegoALaMesa;
    }

    /**
     * Metodo que nos ayuda a saber si el robot recibio el pedido correctamente.
     * @return False si el pedido no esta en el menú o si no se ah ingresado ningún
     * pedido, true en otro caso.
     */
    public boolean pedidoRecibido(){
        return pedidoRecibido;
    }

    /**
     * Metodo que nos ayuda a saber si el robot termino el Pedido.
     * @return True si el robot termino el Pedido, False en otro caso.
     */
    public boolean terminoPedido(){
        return terminoPedido;
    }

    /**
     * Metodo que nos ayuda a obtener el estado suspendio del robot.estados
     * @return El estado de Suspendido del robot
     */
    public EstadoRobot getModoSuspender(){
        inicializarParams();
        return modoSuspendido;
    }

    /**
     * Metodo que nos ayuda a obtener el estado caminando del robot
     * @return El estado de caminando del robot
     */
    public EstadoRobot getModoCaminar(){
        return modoCaminar;
    }

    /**
     * Metodo que nos ayuda a obtener el estado Atendiendo Cliente del robot
     * @return El estado atendiendo del robot
     */
    public EstadoRobot getModoAtenderCliente(){
        return modoAtenderCliente;
    }

    /**
     * Metodo que nos ayuda a obtener el estado Cocinando del robot.
     * @return El estado Cocinando del robot.
     */
    public EstadoRobot getModoCocinar(){
        return modoCocinar;
    }

    /**
     * Metodo getter para obtener los menus y poder leerselos al cliente.
     * @return Los menus que tiene el robot.
     */
    public ArrayList<Menu> getMenus(){
        return menus;
    }

    /**
     * Metodo getter para el pedido que le han hecho al robot.
     * @return El pedido que incerta el usuario para que el robot 
     * pueda cocinarlo
     */
    public Hamburguesa getPedido(){
        return pedido;
    }

    /* Metodos auxiliares tanto para los estados como para el funcionamiento
    en general del robot. */

    /**
     * Metodo para poner el id del Pedido en el robot
     * @param idPedido El id del pedido que queremos poner
     */
    public void setPedido(Hamburguesa pedido){
        this.pedido = pedido;
    }

    /**
     * Metodo que nos ayuda a asignar un estado al robot.
     * @param estado El estado que se le quiere asignar al robot.
     */
    public void asignarEstado(EstadoRobot estado){
        estadoActual = estado;
    }

    /**
     * Metodo para que simula, como cada vez el robot se acerca más a la mesa 
     * del cliente.
     */
    public void avanzar(){
        if(pasos <= 0)
            llegoALaMesa = true;
        else
            pasos--;
    }

    /**
     * Metodo que nos regresa las acciones que puede realizar el robot en un menu.
     * @return Un string con las acciones que puede realizar el robot.
     */
    public String robotOpciones(){
        String menu = "\n";
        menu += "1.- Activar.\n";
        menu += "2.- Caminar.\n";
        menu += "3.- Leer Menu.\n";
        menu += "4.- Cocinar.\n";
        menu += "5.- EntregarPedido.\n";
        menu += "6.- Suspender.\n";
        menu += "0.- Salir del restaurante.\n";
        return menu;
    }

    /**
     * Metodo auxiliar para inicializar los pasos y otras variables
     */
    private void inicializarParams(){
        pasos = 3;
        llegoALaMesa  = false;
        pedidoRecibido = false;
        terminoPedido = false;
    }
}