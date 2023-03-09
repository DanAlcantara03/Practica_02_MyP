package robot;

import java.util.ArrayList;

import robot.menus.*;
import robot.estados.*;
import robot.mesa.*;

/**
 * Clase Robot ...
 */
public class Robot{

    /* Es la mesa del cliente a la que el robot tiene que ir */
    private MesaCliente mesa;
    /* Nos ayuda a saber si el robot llego a la mesa */
    private boolean llegoALaMesa;
    /* Nos ayuda a saber si el robot ya recibio un pedido, y ademas ver si dicho
    pedido es correcto*/
    private boolean pedidoRecibido;
    /* Nos ayuda a saber si el robot termino de cocinar el platillo */
    private boolean terminoPlatillo;
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
        llegoALaMesa  = false;
        pedidoRecibido = false;
        terminoPlatillo = false;

    }

    /**
     * Metodo que esta pensado para usarse con el metodo activar en el estado
     * suspendido, para que cuando el usuario active el robot, este le pueda incertar
     * la mesa en la que quiere sentarse.
     */
    public void recibirMesa(MesaCliente mesa){
        this.mesa = mesa;
    }

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
     * Metodo que nos ayuda a saber si el robot termino el platillo.
     * @return True si el robot termino el platillo, False en otro caso.
     */
    public boolean terminoPlatillo(){
        return terminoPlatillo;
    }

    /**
     * Metodo que nos regresa la Mesa que el cliente inserto al activar el robot.
     * @return La mesa que el cliente puso.
     */
    public MesaCliente getMesacliente(){
        return mesa;
    }

    /**
     * Metodo que nos ayuda a asignar un estado al robot.
     * @param estado El estado que se le quiere asignar al robot.
     */
    public void asignarEstado(EstadoRobot estado){
        estadoActual = estado;
    }

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
     * Metodo que hace que el robot cocine el platillo dado por el usuario.
     */
    public void cocinar(){
        estadoActual.cocinarPlatillo();
    }

    /**
     * Metodo que hace que el robot entregue el platillo, solo si ya lo termino de
     * cocinar y esta en el Modo atenderCliente.
     */
    public void entregarPlatillo(){
        estadoActual.entregarPlatillo();
    }

    /**
     * Metodo que hace que el robot se suspenda solo si esta en el modo caminando, o
     * si ya termino de cocinar y entrego el platillo del cliente.
     */
    public void suspender(){
        estadoActual.suspender();
    }

    /**
     * Metodo que nos regresa las acciones que puede realizar el robot en un menu.
     * @return Un string con las acciones que puede realizar el robot.
     */
    public String robotOpciones(){
        String menu = "";
        menu += "1.- Activar.\n";
        menu += "2.- Caminar.\n";
        menu += "3.- Leer Menu.\n";
        menu += "4.- Cocinar.\n";
        menu += "5.- EntregarPlatillo.\n";
        menu += "6.- Suspender.\n";
        menu += "0.- Salir del restaurante.\n";
        return menu;
    }

}