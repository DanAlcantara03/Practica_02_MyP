package robot.menus.hamburguesas;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase abstracta que nos representa a una Hamburguesa en general.
 */
public abstract class Hamburguesa {
    
    /* El id que va a tener una Hamburguesa para poder identificarla. */
    protected int id;
    /* El nombre de la Hamburguesa. */
    protected String nombre;
    /* La descripción de la Hamburguesa. */
    protected String descripcion;
    /* El precio de la Hamburguesa. */
    protected double precio;
    /* Boolean para saber si la Hamburguesa tiene queso. */
    protected boolean tieneQueso;
    /* Boolean para saber si la Hamburguesa es vegetariana. */
    protected boolean esVegetariana;

    /**
     * Constructor por parametros de una hamburguesa especifica.
     * Este constructor esta pensado para que las hamburguesas que extiendad a esta 
     * clase pongan sus parametros de una forma rapida y fácil
     * @param id El id de la Hamburguesa.
     * @param nombre El nombre de la Hamburguesa.
     * @param descripcion La descripción de la Hamburguesa.
     * @param precio El precio de la Hamburguesa.
     * @param tieneQueso Boolean para saber si la Hamburguesa tiene queso.
     * @param esVegetariana Boolean para saber si la Hamburguesa es vegetariana.
     */
    protected Hamburguesa(int id, String nombre, String descripcion, double precio, boolean esVegetariana){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esVegetariana = esVegetariana;
    }

    /**
     * Metodo getter para el Id de la Hamburguesa.
     * @return el Id del Hamburguesa.
    */
    public int getId(){
        return id;
    }

    /**
     * Metodo getter para el nombre de la Hamburguesa.
     * @return el nombre del Hamburguesa.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter para la descripción de la Hamburguesa.
     * @return la descripción del Hamburguesa.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Metodo getter para el precio de la Hamburguesa.
     * @return el precio del Hamburguesa.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Metodo getter para saber si la Hamburguesa tiene queso.
     * @return true si el Hamburguesa tiene queso, false en otro caso.
     */
    public boolean tieneQueso(){
        return tieneQueso;
    }

    /**
     * Metodo getter para saber si el Hamburguesa es vegetariano.
     * @return true si el Hamburguesa es vegetariano, false en otro caso.
     */
    public boolean esVegetariana(){
        return esVegetariana;
    }

    /**
     * Metodo que nos ayuda a obtener toda la información relaciónada con la
     * hamburguesa.
     * @return Un String con una descripción detallada de la hamburguesa.
     */
    public String getHamburguesa(){
        String hamburguesa = "";
        hamburguesa += "Id: " + getId() + "\n";
        hamburguesa += "   Nombre:" + getNombre() + "\n";
        hamburguesa += "   Descripción: " + getDescripcion() + "\n";
        hamburguesa += "   Precio: " + getPrecio() + "\n";
        hamburguesa += "   Es Vegetariana: " + vegetariana() + "\n";
        return hamburguesa;
    }

    /**
     * Metodo hook para que el robot le pregunte al cliente si quiere ponerle queso a
     * su Hamburguesa o no, o simplemente que diga que no lleva queso, ya que es
     * vegetariana.
     */
    protected void llevaQueso(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n ¿Quiéres queso en tu hamburguesa? (S,N): ");
        String o = sc.nextLine();
        while(true){
            if(o.toUpperCase().equals("S")){
                System.out.println("\nSimon sale con queso.");
                tieneQueso = true;
                break;
            }else if(o.toUpperCase().equals("N")){
                System.out.println("\nEntonces sin queso sera.");
                break;
            }else{
                System.out.println("\nPor favor incerte una opción correcta (S,N)");
            }
        }
    }

    /**
     * Metodo abstracto que nos ayuda a saber como se prepara el Hamburguesa, paso a paso.
     * @param extras son los pasos extras que puede haber en la preparación de la hamburguesa.
     * Dichos pasos siempre se ponen entre los panes de la hamburguesa.
     * @return Una Lista con los pasos que se siguen para preparar el Hamburguesa.
     */
    public abstract LinkedList<String> mostrarPreparacion();

    /**
     * Metodo auxiliar para poder comunicar si la hamburguesa es vegetariana.
     * @return True si la hamburguesa es vegetariana, false en otro caso.
     */
    private String vegetariana(){
        if(esVegetariana){
            return "(SI)";
        }else{
            return "(NO)";
        }
    }
}
