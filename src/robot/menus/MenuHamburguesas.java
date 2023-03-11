package robot.menus;

import java.util.Iterator;
import robot.menus.hamburguesas.Hamburguesa;
import robot.menus.hamburguesas.menu_hamburguesas.*;

/**
 * Clase que representa el menu de hamburguesas de toda la vida del restaurante
 * MCHamburguesas
 */
public class MenuHamburguesas implements Menu{
    
    /* Es la estructura de datos en donde vamos a poner las hamburgesas que siempre
    estan disponibles para el restaurante. */
    private Hamburguesa[] hamburguesas = new Hamburguesa[3];

    /**
     * Constructor por defecto de las hamburgesas en general.
     */
    public MenuHamburguesas(){
        hamburguesas[0] = new HamburguesaKomi();
        hamburguesas[1] = new HamburguesaNaruto();
        hamburguesas[2] = new HamburguesaOPM();
    }

    /**
     * Metodo para poder obtener un nuevo iterador de todas las hamburguesas del menu,
     * cada que lo mandemos a llamar.
     * @return Un iterador de las hamburguesas que están en esté menú.
     */
    public Iterator<Hamburguesa> createIterator(){
        return new ArrHamburguesasIterador();
    }

    /**
     * Subclase para obtener el iterador de este menu de Hamburguesas.
     */
    public class ArrHamburguesasIterador implements Iterator<Hamburguesa>{
        /* El indice para recorrer el arreglo */
        int indice = 0;

        /**
         * Metodo has next de un iterador para el menu de hamburgesas general.
         */
        @Override public boolean hasNext(){
            return indice < hamburguesas.length;
        }

        /* Metodo next para obtener el elemento del indice actual */
        @Override public Hamburguesa next(){;
            if(this.hasNext())
                return hamburguesas[indice++];
            return null;
        }
    }
}
