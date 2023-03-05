package robot.mesa;

/**
 * Una instrucción que tiene que seguir el robot para llegar a la mesa
 * primero se le inserta la direccion a la que tiene que ir y luego la distancia
 * que tiene que recorrer en dicha direccion.
 */
public class Instruccion{
    
    /* La direccion que va a seguir el robot */
    private Direccion direccion;
    /* La distancia en cm que hay entre un punto A y un punto B dada una direccion */
    private int distancia;

    /**
     * Constructor para progrmar una instrucción que el robot debe seguir. 
     * @param direccion la dirección 
     * @param distancia la distancia que tiene que recorrer dada la direccion a la
     *  que tiene que ir
     */
    public Instruccion(Direccion direccion, int distancia) {        
        this.direccion = direccion;
        this.distancia = distancia;
    }

    /**
     * Metodo geter para la direccion.
     * @return la direccion en la que tiene que ir el robot.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Metodo getter para la distancia que tiene que recorrer el robot en la dirección
     * elegida.
     * @return la distancia que hay de un punto a a un punto b dada una direccion.
     */
    public int getDistancia() {
        return distancia;
    }
}