package robot.menus;

import java.util.LinkedList;

/**
 * Clase abstracta que nos representa a un Pedido en general.
 */
public abstract class Pedido {
    
    /* El id que va a tener un Pedido para poder identificarlo. */
    protected int id;
    /* El nombre del Pedido. */
    protected String nombre;
    /* La descripción del Pedido. */
    protected String descripcion;
    /* El precio del Pedido. */
    protected double precio;
    /* Boolean para saber si el Pedido tiene queso. */
    protected boolean tieneQueso;
    /* Boolean para saber si el Pedido es vegetariano. */
    protected boolean esVegetariano;

    /**
     * Constructor por parametros de un Pedido.
     * @param id El id del Pedido.
     * @param nombre El nombre del Pedido.
     * @param descripcion La descripción del Pedido.
     * @param precio El precio del Pedido.
     * @param tieneQueso Boolean para saber si el Pedido tiene queso.
     * @param esVegetariano Boolean para saber si el Pedido es vegetariano.
     */
    public Pedido(int id, String nombre, String descripcion, double precio){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tieneQueso = false;
        this.esVegetariano = false;
    }

    /**
     * Metodo getter para el Id del Pedido.
     * @return el Id del Pedido.
    */
    public int getId(){
        return id;
    }

    /**
     * Metodo getter para el nombre del Pedido.
     * @return el nombre del Pedido.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter para la descripción del Pedido.
     * @return la descripción del Pedido.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Metodo getter para el precio del Pedido.
     * @return el precio del Pedido.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo getter para saber si el Pedido tiene queso.
     * @return true si el Pedido tiene queso, false en otro caso.
     */
    public boolean tieneQueso(){
        return tieneQueso;
    }

    /**
     * Metodo getter para saber si el Pedido es vegetariano.
     * @return true si el Pedido es vegetariano, false en otro caso.
     */
    public boolean esVegetariano(){
        return esVegetariano;
    }

    /**
     * Metodo abstracto que nos ayuda a saber como se prepara el Pedido, paso a paso.
     * @return Una Lista con los pasos que se siguen para preparar el Pedido.
     */
    public abstract LinkedList<String> mostrarPreparacion();
}
