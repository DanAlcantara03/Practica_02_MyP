package robot.estados;

/**
 * Clase auxiliar especialmente hecha para mandar mensajes generales de
 * que no puede hacer el robot, todos los metodos son estaticos.
 */
public class MensajesComunes {

    /**
     * Metodo auxiliar para poner explicitamente que no puede hacer el
     * robot en este estado de las acciones que se presentan arriba.
     * @param modo Es el modo en el cual no se puede realizar la acción
     * noP
     * @param noP Es la acción que el robot no puede realizar mientras este
     * en el estado modo.
     * @return Un mensaje con una advertencia de que la acción noP no se puede
     * realizar en el estado modo.
     */
    public static String noPuede(String modo, String noP){
        String msj = "";
        msj += "|#|#|#|#|#|#|#| MODO " + modo.toUpperCase() + "|#|#|#|#|#|#|#|\n";
        msj += "El robot no puede " + noP + " mientras esta " + modo.toLowerCase() + ".\n\n";
        return msj;
    }

    /**
     * Metodo auxiliar para poner explicitamente que no puede realizar una
     * acción en un modo, ya que el robot ya la esta realizando.
     * @param modo Es el modo del robot.
     * @return Un mensaje con una advertencia de que modo ya esta actualmente
     * activo por lo que no puedes volver a activarlo.
     */
    public static String yaEsta(String modo ){
        String msj = "";
        msj += "|#|#|#|#|#|#|#|#| MODO " + modo.toUpperCase() + "|#|#|#|#|#|#|#|\n";
        msj += "El robot ya esta " + modo.toLowerCase() + ".\n\n";
        return msj;
    }
}
