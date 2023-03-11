package robot.menus.hamburguesas.menu_dia;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Evangelion.
 */
public class HamburguesaEvangelion extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Evangelion.
     */
    public HamburguesaEvangelion(){
        super(3003, "Hamburguesa Evangelion", 
        "Ni tu la vas a entender – Pan clasico, zetas(no de las que se fumo el creador del anime) y vegetales",
        50.00, true);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Evangelion.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando las zetas");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo las zetas");
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