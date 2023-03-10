package robot.menus;

import java.util.LinkedList;

public class HamburguesaVegetariana extends Hamburguesa{
    
    /**
     * Constructor por parametros de una Hamburguesa vegetariana.
     * @param id El id de la Hamburguesa.
     * @param nombre El nombre de la Hamburguesa.
     * @param descripcion La descripción de la Hamburguesa.
     * @param precio El precio del Hamburguesa.
     * @param tieneQueso Boolean para saber si el Hamburguesa tiene queso.
     * @param esVegetariano Boolean para saber si el Hamburguesa es vegetariano.
     */
    public HamburguesaVegetariana(int id, String nombre, String descripcion, double precio){
        super(id, nombre, descripcion, precio);
        this.tieneQueso = false;
        this.esVegetariana = true;
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa.
     */
    @Override public LinkedList<String> mostrarPreparacion(String[] extras){
        LinkedList<String> preparacion = new LinkedList<>();

        return preparacion;
    }
}
