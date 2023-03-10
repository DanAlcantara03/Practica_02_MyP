package robot.menus;

import java.util.Iterator;
import java.util.LinkedList;

public class MenuDelDia implements Menu{
    private LinkedList<Hamburguesa> hamburguesas = new LinkedList<>();


    public MenuDelDia(){
        //Hamburguesa Hamburguesa_Komi = new Hamburguesa(0001,"Hamburguesa Komi");
    }

    public Iterator<Hamburguesa> createIterator(){
        return hamburguesas.iterator();
    }
}
