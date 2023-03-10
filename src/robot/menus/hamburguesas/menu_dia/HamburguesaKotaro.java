package robot.menus.hamburguesas.menu_dia;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Kotaro.
 */
public class HamburguesaKotaro extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Kotaro.
     */
    public HambrguesKotaro(){
        super(3001, "Hamburguesa Kotaro", 
        "Para niños– Pan de clasico, carne , catsup, mayonesa y vegetales, todo en forma de estrella",
        40.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Kotaro.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        return preparacion;
    }
}