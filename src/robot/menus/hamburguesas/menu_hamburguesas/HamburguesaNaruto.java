package robot.menus.hamburguesas.menu_hamburguesas;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Naruto.
 */
public class HamburguesaNaruto extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Naruto.
     */
    public HamburguesaNaruto(){
        super(1003, "Hamburguesa Naruto", 
        "Mucho relleno - Pan clásico, catsup, mayonesa, mostaza, vegetales, soya",
        50, true);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Naruto.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        preparacion.add("Calentando el pan clásico");
        preparacion.add("Calentando la carne");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la carne");
        preparacion.add("Poniendo la mayonesa");
        preparacion.add("Poniendo el ketchup");
        preparacion.add("Poniendo la mostaza");
        preparacion.add("Poniendo el pan que cubre");
        return preparacion;
    }

    /**
     * Metodo hook que nos pone por defecto que la hamburguesa no lleve queso,
     * ya que es vegetariana.
     */
    @Override public void llevaQueso(){
        this.tieneQueso = false;
    }
}