package robot.menus.hamburguesas.menu_hamburguesas;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo One Punch Man.
 */
public class HamburguesaOPM extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa One Punch Man.
     */
    public HamburguesaOPM(){
        super(1002, "Hamburguesa One Punch Man", 
        "Con una te basta - Pan brioche, catsup, mayonesa, mostaza, extra vegetales, extra carne y extra queso",
        80, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa One Punch Man.
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