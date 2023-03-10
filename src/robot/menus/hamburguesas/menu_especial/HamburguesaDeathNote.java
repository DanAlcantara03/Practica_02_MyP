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
        "Para morirse (no literalmente)– Pan con el nombre del cliente, carbe tapa arterias , carne teriyaki , carne de pollo empanizada y BBQ",
        160.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa Death Note.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        return preparacion;
    }
}