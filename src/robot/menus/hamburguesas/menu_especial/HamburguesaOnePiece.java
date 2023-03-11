package robot.menus.hamburguesas.menu_especial;

import java.util.LinkedList;

import robot.menus.hamburguesas.Hamburguesa;
/**
 * Clase que modela una hamburguesa de tipo One Piece.
 */
public class HamburguesaOnePiece extends Hamburguesa{
    
    /**
     * Constructor por defecto de la hamburguesa One Piece.
     */
    public HamburguesaOnePiece(){
        super(2001, "Hamburguesa One Piece", 
        "Nunca te la podras terminar – Pan parrillero, triple carne, aros de cebolla, tenders, tocino, salsa BBQ, mayonesa y vegetales",
        120.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa One Piece.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        // Esto modificalo como quieras amor, solo es un ejemplo para que veas
        // como cual es mi idea de mostrar la preparación
        return preparacion;
    }
}