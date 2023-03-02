package robot.estados;

/**
 * Clase que representa el Estado del robot.
 * @author 
 */
public interface EstadoRobot{

    /**
     * 
     */
    public void activar();

    /**
     * 
     */
    public void caminar();

    /**
     * 
     */
    public void atenderCliente();

    /**
     * 
     */
    public void cocinar();

    /**
     * 
     */
    public void suspender();
}