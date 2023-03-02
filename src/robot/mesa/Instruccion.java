package robot.mesa;

/**
 * Una instrucción que tiene que seguir el robot para llegar a la mesa
 */
public class Instruccion{
    
    /* La direccion que va a seguir el robot */
    private Direccion direccion;
    /* La distancia en cm que hay antes de que el robot tenga que girar. */
    private int distancia;

    /**
     * Constructor para progrmar una instrucción que el robot debe seguir.
     * @param distancia la distancia 
     * @param direccion la dirección a la que se tiene que ir en
     */
    public Instruccion(int distancia, Direccion direccion) {
        this.distancia = distancia;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Nos regresa la distancia que tiene que recorrer el robot en la dirección
     * elegida.
     * @return la distancia que hay de un punto a a un punto b en una dirección específica.
     */
    public int getDistancia() {
        return distancia;
    }
}