package robot.menus;

import java.util.Iterator;
import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;

public class MenuDelDia implements Menu{
    /* Es la estructura de datos en donde guardaremos las hamburguesas del día. */
    private LinkedList<Hamburguesa> hamburguesas = new LinkedList<>();

    /**
     * 
     */
    public MenuDelDia(){
        //Hamburguesa Hamburguesa_Komi = new Hamburguesa(0001,"Hamburguesa Komi");
    }

    public Iterator<Hamburguesa> createIterator(){
        return hamburguesas.iterator();
    }
}
