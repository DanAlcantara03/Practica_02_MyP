package robot.menus.hamburguesas.menu_dia;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Shen-Long.
 */
public class HamburguesaSl extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Shen-Long.
     */
    public HamburguesaSl(){
        super(3002, "Hamburguesa Shen-Long", 
        "Es tu deseo– Pan con una estrella grabada, doble carne, vegetales, catsup, mostaza y mayonesa",
        75.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Shen-Long.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        return preparacion;
    }
}