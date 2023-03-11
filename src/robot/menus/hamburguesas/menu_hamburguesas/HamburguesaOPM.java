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
        "Con una te basta - Pan brioche, catsup, mostaza, extra vegetales, extra carne",
        80, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa One Punch Man.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando la extra carne");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la extra carne");
        preparacion.add("Poniendo la catsup");
        preparacion.add("Poniendo la mostaza");
        preparacion.add("Poniendo extra pepinillos");
        preparacion.add("Poniendo extra cebolla");
        preparacion.add("Poniendo extra lechuga");
        preparacion.add("Poniendo extra tomate");
        preparacion.add("Poniendo el pan que cubre");
        return preparacion;
    }
}