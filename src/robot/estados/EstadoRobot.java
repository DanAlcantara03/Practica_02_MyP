package robot.estados;

/**
 * Clase que representa el Estado en general que va a tener el robot.
 */
public interface EstadoRobot{

    /**
     * Metodo para simular la activación del robot solo si esta en modo Suspendido.
     * Lo primero que hace el cliente es entrar al establecimiento y activar el robot,
     * al activar el robot el cliente tiene que ingresar la mesa en la cual se va a sentar
     * (dichas mesas van a ser finitas y van a estar numeradas de 1-n), para que el robot
     */
    public void activar();

    /**
     * Metodo para simular la caminata del robot dependiendo del estado en el que este.
     * Si el cliente no ingresa la mesa en la cual se va a sentar, el robot no va a poder
     * caminar, en otro caso el robot caminara a la mesa en la que el cliente se va a 
     * sentar y se pondra enfrente de dicha mesa.
     * Cuando el cliente ya no quiera nada más del robot, dicho robot regresara al sitio
     * en donde el cliente lo activo.
     */
    public void caminar();

    /**
     * Metodo para simular como lee el menu el robot, dependiendo del estado en el que 
     * esté.
     * Cuando el robot esta recien llegando a la mesa procede a leer el menu, también
     * lee el menu despues de que entrego un platillo y ademas el cliente quiere 
     * pedirle otro.
     */
    public void leerMenu();


    /**
     * Metodo para simular que el cliente elige un platillo, dependiendo del estado 
     * en el que el robot esté.
     * Ya que el robot le mostro todo el Menu al cliente le da la opcion de elegir 
     * alguno de dichos platillos y aparte le pregunta si quiere agregar o quitar 
     * x ingrediente a dicho platillo.
     */
    public void elegirPlatillo();

    /**
     * Metodo auxiliar que nos ayuda a simular que el robot esta cocinando un platillo,
     * esto lo va a hacer mostrandole al cliente todo el proceso que se sigue al crear 
     * dicho platillo.
     * 
     * 
     */
    public void cocinarPlatillo();


    /**
     * Metodo auxiliar que nos ayuda a simular que el robot esta entregandole el
     * platillo al cliente
     */
    public void entregarPlatillo();

    /**
     * Metodo auxiliar que nos ayuda a pasar al robot al estado suspendido dependiendo
     * de cual sea su estado actual.
     * El robot solo se va a poder suspender si esta caminando o si ya entrego el 
     * platillo del cliente, y ademas el cliente ya no quiere ordenar nada más.
     */
    public void suspender();
}