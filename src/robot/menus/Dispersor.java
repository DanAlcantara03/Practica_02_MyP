package robot.menus;

/**
 * Interfaz genérica para dispersores.
 * Principalmente esta diseñada para usarse con lambdas.
 */
@FunctionalInterface
public interface Dispersor<T> {

    /**
     * Calcula la función de dispersión del objeto recibido.
     * @param objeto el objeto que queremos dispersar.
     * @return el resultado de dispersar del objeto recibido.
     */
    public int dispersa(T objeto);
}
