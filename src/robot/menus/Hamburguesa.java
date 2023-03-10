package robot.menus;

import java.util.LinkedList;

/**
 * Clase abstracta que nos representa a una Hamburgueza en general.
 */
public abstract class Hamburguesa {
    
    /* El id que va a tener una Hamburguesa para poder identificarla. */
    protected int id;
    /* El nombre de la Hamburguesa. */
    protected String nombre;
    /* La descripción de la Hamburguesa. */
    protected String descripcion;
    /* El precio de la Hamburguesa. */
    protected double precio;
    /* Boolean para saber si la Hamburguesa tiene queso. */
    protected boolean tieneQueso;
    /* Boolean para saber si la Hamburguesa es vegetariana. */
    protected boolean esVegetariano;

    /**
     * Constructor por parametros de la Hamburguesa.
     * @param id El id del Hamburguesa.
     * @param nombre El nombre del Hamburguesa.
     * @param descripcion La descripción del Hamburguesa.
     * @param precio El precio del Hamburguesa.
     * @param tieneQueso Boolean para saber si el Hamburguesa tiene queso.
     * @param esVegetariano Boolean para saber si el Hamburguesa es vegetariano.
     */
    public Hamburguesa(int id, String nombre, String descripcion, double precio){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tieneQueso = false;
        this.esVegetariano = false;
    }

    /**
     * Metodo getter para el Id de la Hamburguesa.
     * @return el Id del Hamburguesa.
    */
    public int getId(){
        return id;
    }

    /**
     * Metodo getter para el nombre de la Hamburguesa.
     * @return el nombre del Hamburguesa.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter para la descripción de la Hamburguesa.
     * @return la descripción del Hamburguesa.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Metodo getter para el precio de la Hamburguesa.
     * @return el precio del Hamburguesa.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo getter para saber si la Hamburguesa tiene queso.
     * @return true si el Hamburguesa tiene queso, false en otro caso.
     */
    public boolean tieneQueso(){
        return tieneQueso;
    }

    /**
     * Metodo getter para saber si el Hamburguesa es vegetariano.
     * @return true si el Hamburguesa es vegetariano, false en otro caso.
     */
    public boolean esVegetariano(){
        return esVegetariano;
    }

    /**
     * Metodo abstracto que nos ayuda a saber como se prepara el Hamburguesa, paso a paso.
     * @return Una Lista con los pasos que se siguen para preparar el Hamburguesa.
     */
    public abstract LinkedList<String> mostrarPreparacion();
}
