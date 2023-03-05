package robot.menus;

import java.util.LinkedList;

/**
 * Clase abstracta que nos representa a un platillo en general.
 */
public abstract class Platillo {
    
    /* El id que va a tener un platillo para poder identificarlo. */
    protected int id;
    /* El nombre del platillo. */
    protected String nombre;
    /* La descripción del platillo. */
    protected String descripcion;
    /* El precio del platillo. */
    protected double precio;
    /* Boolean para saber si el platillo tiene queso. */
    protected boolean tieneQueso;
    /* Boolean para saber si el platillo es vegetariano. */
    protected boolean esVegetariano;

    /**
     * Constructor por parametros de un platillo.
     * @param id El id del platillo.
     * @param nombre El nombre del platillo.
     * @param descripcion La descripción del platillo.
     * @param precio El precio del platillo.
     * @param tieneQueso Boolean para saber si el platillo tiene queso.
     * @param esVegetariano Boolean para saber si el platillo es vegetariano.
     */
    public Platillo(int id, String nombre, String descripcion, double precio, boolean tieneQueso, boolean esVegetariano){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tieneQueso = tieneQueso;
        this.esVegetariano = esVegetariano;
    }

    /**
     * Metodo getter para el Id del platillo.
     * @return el Id del platillo.
    */
    public int getId(){
        return id;
    }

    /**
     * Metodo getter para el nombre del platillo.
     * @return el nombre del platillo.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter para la descripción del platillo.
     * @return la descripción del platillo.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Metodo getter para el precio del platillo.
     * @return el precio del platillo.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo getter para saber si el platillo tiene queso.
     * @return true si el platillo tiene queso, false en otro caso.
     */
    public boolean tieneQueso(){
        return tieneQueso;
    }

    /**
     * Metodo getter para saber si el platillo es vegetariano.
     * @return true si el platillo es vegetariano, false en otro caso.
     */
    public boolean esVegetariano(){
        return esVegetariano;
    }

    /**
     * Metodo abstracto que nos ayuda a saber como se prepara el platillo, paso a paso.
     * @return Una Lista con los pasos que se siguen para preparar el platillo.
     */
    public abstract LinkedList<String> mostrarPreparacion();
}
