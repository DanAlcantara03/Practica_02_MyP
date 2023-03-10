package robot.menus;

import java.util.Iterator;

import robot.menus.hamburguesas.Hamburguesa;

/**
 * Interfaz para poder crear los menus de varios tipos
 */
public interface Menu {
    
    /* El iterador del menu */
    public Iterator<Hamburguesa> createIterator();
}