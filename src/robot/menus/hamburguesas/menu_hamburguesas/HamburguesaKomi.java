package robot.menus.hamburguesas.menu_hamburguesas;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Komi.
 */
public class HamburguesaKomi extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Komi.
     */
    public HamburguesaKomi(){
        super(1001, "Hamburguesa Komi", 
        "Te va a dejar sin palabras - Pan clásico, carne, catsup, mayonesa, mostaza",
        40.50, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Komi.
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
}