package robot.mesa;

import java.util.LinkedList;

public class MesaCliente{

    /* El no de mesa del cliente. */
    int noMesa;
    /* Las instrucciones que tiene que seguir el robot para llegar a la mesa del cliente. */
    LinkedList<Instruccion> instrucciones;
    /* Boolean para saber si el robot llego a la mesa del cliente. */
    boolean llego;

    /**
     * Constructor por defecto de una Mesa de cliente.
     * @param noMesa El no de mesa del cliente.
     * @param instrucciones Las instrucciones que tiene que seguir el robot para poder
     * llegar a la mesa del cliente.
     */
    public MesaCliente(int noMesa,LinkedList<Instruccion> instrucciones){
        this.noMesa = noMesa;
        this.instrucciones = instrucciones;
        llego = false;
    }

    /**
     * Metodo que imprime en terminal los pasos que da al robot para ira la mesa que
     * eligio el cliente.
     */
    public void irAMesa(){
        for(Instruccion inst: instrucciones){
            String rI = "";
            rI += " El robot esta recorriendo " + (((double)inst.getDistancia())/100) + "m";
            rI += " hacia " + getDireccion(inst.getDireccion());
            System.out.println(rI);
            /* En este caso el robot tarda un ms por cada cm recorrido */
            simularPausa(inst.getDistancia());
        }
        System.out.println("El robot llego a la mesa " + noMesa + ".");
        llego = true;
    }

    /**
     * Metodo que nos ayuda a simular que el robot termino de atender al cliente, y 
     * vuelve a su posición inicial
     */
    public void regresarPosicionInicial(){
        llego = false;
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