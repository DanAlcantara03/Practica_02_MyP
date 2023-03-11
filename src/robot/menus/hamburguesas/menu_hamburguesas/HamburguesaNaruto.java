package robot.menus.hamburguesas.menu_hamburguesas;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Naruto.
 */
public class HamburguesaNaruto extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Naruto.
     */
    public HamburguesaNaruto(){
        super(1003, "Hamburguesa Naruto", 
        "Mucho relleno - Pan clásico, catsup, mostaza, vegetales, soya",
        50, true);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Naruto.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Dando forma de carne para hamburguesa a la soya");
        preparacion.add("Calentando la soya");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la soya");
        preparacion.add("Poniendo la catsup");
        preparacion.add("Poniendo la mostaza");
        preparacion.add("Poniendo los pepinillos");
        preparacion.add("Poniendo la cebolla");
        preparacion.add("Poniendo la lechuga");
        preparacion.add("Poniendo el tomate");
        preparacion.add("Poniendo el pan que cubre");
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