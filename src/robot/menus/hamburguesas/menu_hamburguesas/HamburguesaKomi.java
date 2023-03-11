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
        "Te va a dejar sin palabras - Pan clásico, carne, catsup, mostaza, vegetales",
        40.50, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Komi.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando la carne");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la carne");
        preparacion.add("Poniendo la catsup");
        preparacion.add("Poniendo la mostaza");
        preparacion.add("Poniendo los pepinillos");
        preparacion.add("Poniendo la cebolla");
        preparacion.add("Poniendo la lechuga");
        preparacion.add("Poniendo el tomate");
        preparacion.add("Poniendo el pan que cubre");
        return preparacion;
    }
}