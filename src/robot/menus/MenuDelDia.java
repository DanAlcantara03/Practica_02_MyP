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


    public Iterator<Hamburguesa> createIterator(){
        return hamburguesas.iterator();
    }
}
