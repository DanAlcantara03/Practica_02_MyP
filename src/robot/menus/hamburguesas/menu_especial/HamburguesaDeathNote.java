package robot.menus.hamburguesas.menu_especial;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo Death Note.
 */
public class HamburguesaDeathNote extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa Death Note.
     */
    public HamburguesaDeathNote(){
        super(2003, "Hamburguesa Death Note", 
        "Para morirse (no literalmente)– Pan con el nombre del cliente escrito con laser, carne tapa arterias , carne teriyaki , carne de pollo empanizada y BBQ",
        160.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Death Note.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Friendo la carne con extra mantequilla");
        preparacion.add("Preparando la carne teriyaki");
        preparacion.add("Preparando la carne de pollo empanizada");
        preparacion.add("Escribiendo el nombre del cliente con laser en el pan");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la carne con extra mantequilla");
        preparacion.add("Poniendo la carne teriyaki");
        preparacion.add("Poniendo la carne de pollo empanizada");
        if(this.tieneQueso())
            preparacion.add("Poniendo el queso");
        preparacion.add("Poniendo la BBQ");
        preparacion.add("Poniendo el pan que cubre");
        return preparacion;
    }
}