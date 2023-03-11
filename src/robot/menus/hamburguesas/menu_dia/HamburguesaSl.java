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
        "Es tu deseo– Pan con una estrella dibujada con laser, doble carne, catsup, mostaza, vegetales",
        75.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Shen-Long.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando las dos carnes");
        preparacion.add("Dibujando la estrella en el pan");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo las dos carnes");
        if(this.tieneQueso())
            preparacion.add("Poniendo el queso");
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