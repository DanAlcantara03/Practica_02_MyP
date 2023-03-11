package robot.menus;

import java.util.Iterator;

import robot.menus.hamburguesas.Hamburguesa;

/**
 * Interfaz para poder crear los menus de varios tipos
 */
public interface Menu {
    
    /* String para saber como se llama el menu o de que es. */
    public String getNombreMenu();

    /* El iterador del menu */
    public Iterator<Hamburguesa> createIterator();
}