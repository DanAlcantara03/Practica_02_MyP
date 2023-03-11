package robot.menus;

import java.util.Iterator;
import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
import robot.menus.hamburguesas.menu_dia.*;

public class MenuDelDia implements Menu{
    
    /* Es la estructura de datos en donde guardaremos las hamburguesas del día. */
    private LinkedList<Hamburguesa> hamburguesas = new LinkedList<>();

    /**
     * Constructor por defecto del menú del día.
     */
    public MenuDelDia(){
        hamburguesas.add(new HamburguesaEvangelion());
        hamburguesas.add(new HamburguesaKotaro());
        hamburguesas.add(new HamburguesaSl());
    }

    /**
     * Metodo que nos ayuda a saber como se llama el menú.
     * @return nos regresa el nombre de este menú
     */
    public String getNombreMenu(){
        return "Menu del Dia";
    }

    /**
     * Metodo para obtener el iterador de las hamburguesas
     * @return El iterador de todas las hamburguesas
     */
    public Iterator<Hamburguesa> createIterator(){
        return hamburguesas.iterator();
    }
}
