package robot.menus.hamburguesas.menu_especial;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Sailor Moon.
 */
public class HamburguesaSailorMoon extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Sailor Moon.
     */
    public HamburguesaSailorMoon(){
        super(2002, "Hamburguesa Sailor Moon", 
        "De otro mundo– Pan de colores, tofu , catsup, mostaza, vegetales",
        100.75, true);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Sailor Moon.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Dando forma de carne para hamburguesa al tofu");
        preparacion.add("Calentando el tofu");
        preparacion.add("Poniendo el pan base de colores");
        preparacion.add("Poniendo el tofu");
        preparacion.add("Poniendo la catsup");
        preparacion.add("Poniendo la mostaza");
        preparacion.add("Poniendo los pepinillos");
        preparacion.add("Poniendo la cebolla");
        preparacion.add("Poniendo la lechuga");
        preparacion.add("Poniendo el tomate");
        preparacion.add("Poniendo el pan de colores que cubre");
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