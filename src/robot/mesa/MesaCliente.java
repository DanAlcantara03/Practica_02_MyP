package robot.mesa;

import java.util.Iterator;
import java.util.LinkedList;

public class MesaCliente{

    /* El no de mesa del cliente. */
    private int noMesa;
    /* Las instrucciones que tiene que seguir el robot para llegar a la mesa del cliente. */
    private LinkedList<Instruccion> instrucciones;
    /* Un iterador para ir recorriendo poco a poco las instrucciones que se le dan al robot. */
    private Iterator<Instruccion> iterator;
    /* Boolean para saber si el robot llego a la mesa del cliente. */
    private boolean llego;

    /**
     * Constructor por defecto de una Mesa de cliente.
     * @param noMesa El no de mesa del cliente.
     * @param instrucciones Las instrucciones que tiene que seguir el robot para poder
     * llegar a la mesa del cliente.
     */
    public MesaCliente(int noMesa,LinkedList<Instruccion> instrucciones){
        this.noMesa = noMesa;
        this.instrucciones = instrucciones;
        this.iterator = instrucciones.iterator();
        if(!iterator.hasNext())
            llego = true;
    }

    /**
     * Metodo getter para saber el no de la Mesa que escogio el cliente
     * @return el no de mesa del cliente
     */
    public int getNoMesa(){
        return noMesa;
    }

    /**
     * Metodo getter para saber si el robot llegó a la mesa.
     * @return
     */
    public boolean llego(){
        return llego;
    }

    /**
     * Metodo que hace que el robot avance hacia la siguiente coordenada de la 
     * instrucción, para así poder llegar a la mesa del cliente, y también nos dice
     * como avanzo el robot y hacia que dirección, o si ya llego a la mesa del cliente.
     */
    public void acercarseAMesa(){
        if(!iterator.hasNext()){
            llego = true;
            System.out.print("El robot ah llegado a la mesa del cliente.");
        }else{
            Instruccion instActual = iterator.next();
        /* En este caso el robot tarda un ms por cada cm recorrido */
            System.out.println(mensajeDist(instActual));
            simularPausa(instActual.getDistancia());
        }
    }
    
    /**
     * Metodo que nos ayuda a simular que el robot termino de atender al cliente, y 
     * vuelve a su posición inicial
     */
    public void regresarPosicionInicial(){
        iterator = instrucciones.iterator();
        if(iterator.hasNext())
            llego = false;
    }

    /**
     * Metodo auxiliar para saber hacia donde va el robot y que distancia va a recorrer.
     * @param inst la instrucción que va a ejecutar el robot para recorrer x distancia 
     * en y direccion.
     * @return Un mensaje con información de los movimientos que va a realizar el robot.
     */
    private String mensajeDist(Instruccion inst){
        String rI = "";
            rI += " El robot esta recorriendo " + (((double)inst.getDistancia())/100) + "m";
            rI += " hacia " + getDireccion(inst.getDireccion());
        return rI;
    }

    /**
     * Metodo auxiliar que nos ayuda a obtener una representación en cadena de cada 
     * enumeración de las Direcciones.
     * @param dir La Dirección de la que quieres obtener la representación en cadena.
     * @return La representación en cadena de dir.
     */
    private String getDireccion(Direccion dir){
        if(dir == Direccion.adelante){
            return "adelante";
        }else if( dir == Direccion.atras){
            return "atras";
        }else if(dir == Direccion.izquierda){
            return "la izquierda";
        }else{
            return "la derecha";
        }
    }

    /**
     * Metodo auxiliar que nos ayuda a simular el tiempo que tarda el robot en caminar
     * Esta pensado que por cada cm que camine, tarde x ms en recorrer dicho cm
     * @param mills Una proporcion de los ms que tarde el robot en recorrer n cm
     */
    private void simularPausa(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {}
    }
}