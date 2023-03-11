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
        "Nunca te la podras terminar – Pan parrillero, triple carne, aros de cebolla, tenders, tocino, BBQ, vegetales",
        120.00, false);
    }

    /**
     * Metodo que nos devuelve la preparación paso a paso de la hamburguesa One Piece.
     */
    @Override public LinkedList<String> mostrarPreparacion(){
        LinkedList<String> preparacion = new LinkedList<>();
        preparacion.add("Calentando las tres carnes carnes");
        preparacion.add("Preparando los aros de cebolla");
        preparacion.add("Preparando los tenders"); 
        preparacion.add("Friendo el tocino");
        preparacion.add("Poniendo el pan base");
        preparacion.add("Poniendo la BBQ");
        preparacion.add("Poniendo las tres carnes");
        preparacion.add("Poniendo los aros de cebolla");
        preparacion.add("Poniendo los tenders"); 
        preparacion.add("Poniendo el tocino");
        preparacion.add("Poniendo los pepinillos");
        preparacion.add("Poniendo la cebolla");
        preparacion.add("Poniendo la lechuga");
        preparacion.add("Poniendo el tomate");
        preparacion.add("Poniendo el pan que cubre");
        return preparacion;
    }
}