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
    public HamburguesaKotaro(){
        super(3001, "Hamburguesa Kotaro", 
        "Para niños– Pan de clasico, carne , catsup, mostaza, vegetales, todo en forma de estrella",
        40.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Kotaro.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando la carne");
        preparacion.add("Cortando la carne en forma de estrella");
        preparacion.add("Cortando los panes en forma de estrella"); 
        preparacion.add("Cortando los vegetales en forma de estella");
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