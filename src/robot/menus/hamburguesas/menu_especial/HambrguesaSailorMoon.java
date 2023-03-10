package robot.menus.hamburguesas.menu_especial;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Sailor Moon.
 */
public class HambrguesaSailorMoon extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Sailor Moon.
     */
    public HambrguesaSailorMoon(){
        super(2002, "Hamburguesa Sailor Moon", 
        "De otro mundo– Pan de colores, tofu , catsup, mayonesa, mostaza, vegetales",
        100.75, true);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Sailor Moon.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        return preparacion;
    }
}