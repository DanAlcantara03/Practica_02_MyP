package robot.menus;

import java.util.Hashtable;
import java.util.Iterator;

import robot.menus.hamburguesas.Hamburguesa;

/**
 * Clase que nos ayuda a obtener el menú especial del MCResutaurante
 */
public class MenuEspecial implements Menu{
    
    /* Es el hash table en donde guardaremos las hamburguesas */
    private Hashtable <Integer,Hamburguesa> deluxe = new Hashtable<Integer,Hamburguesa>();

    /**
     * Constructor por defecto del menú especial.
     */
    public MenuEspecial() {
        // Aqui vamos a inicialiar el menu con las hamburguesas del menu especial
    }

    public Iterator<Hamburguesa> createIterator(){
        return deluxe.values().iterator();
    }
    
}
