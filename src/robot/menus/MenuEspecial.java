package robot.menus;

import java.util.Hashtable;
import java.util.Iterator;
import robot.menus.hamburguesas.Hamburguesa;
import robot.menus.hamburguesas.menu_especial.*;

/**
 * Clase que nos ayuda a obtener el menú especial del MCResutaurante
 */
public class MenuEspecial implements Menu{
    
    /* Es el hash table en donde guardaremos las hamburguesas */
    private Hashtable <Integer,Hamburguesa> hamburguesasDeluxe = new Hashtable<Integer,Hamburguesa>();

    /**
     * Constructor por defecto del menú especial.
     */
    public MenuEspecial() {
        hamburguesasDeluxe.put(2001,new HamburguesaOnePiece());
        hamburguesasDeluxe.put(2002,new HamburguesaSailorMoon());
        hamburguesasDeluxe.put(2003,new HamburguesaDeathNote());
    }

    
    public Iterator<Hamburguesa> createIterator(){
        return hamburguesasDeluxe.values().iterator();
    }
    
}
