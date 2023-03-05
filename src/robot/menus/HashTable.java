package robot.menus;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Clase para crear HasTables(<em>hash tables</em>). Un HashTable generaliza el
 * concepto de arreglo, mapeando un conjunto de <em>llaves</em> a una colección
 * de <em>valores</em>. 
 * Notemos que K es del tipo que queremos que sea la llave y V es del tipo que
 * queremos que sean los elementos que queremos guardar.
 */
public class HashTable<K, V> implements Iterable<V> {

    /* Clase interna privada para entradas. */
    private class Entrada {

        /* La llave. */
        public K llave;
        /* El valor. */
        public V valor;

        /* Construye una nueva entrada. */
        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }
    }
    
    /* Clase interna privada para iteradores. */
    private class Iterador {
        
        /* En qué lista estamos. */
        private int indice;
        /* Iterador auxiliar. */
        private Iterator<Entrada> iterador;
        
        /* Construye un nuevo iterador, auxiliándose de las listas del
        * HashTable. */
        public Iterador(){
            indice = 0;
            mueveIterador();
        }
        
        /* Nos dice si hay una siguiente entrada. */
        public boolean hasNext(){
            if(iterador != null){
                return iterador.hasNext();
            }
            return false;
        }
        
        /* Regresa la siguiente entrada. */
        public Entrada siguiente(){
            if(iterador == null){
                throw new NoSuchElementException("No hay elemento siguiente.");
            }
            Entrada a = iterador.next();
            if(!iterador.hasNext()){
                indice++;
                mueveIterador();
            }
            return a;
        }
        
        /* Mueve el iterador a la siguiente entrada válida. */
        private void mueveIterador(){
            iterador = sigIterador();
        }

        /**
        * Metodo auxiliar para los iteradores, que nos regresa el siguiente
        * iterador que esta en el arreglo de entradas, a partir del indice i.
        * @param i El indice a partir del cual queremos encontrar el iterador
        * @return Nos regresa el siguiente iterador de una lista distinta de
        *         null en el arreglo, o null si ya no hay listas de entradas
        *         en el arreglo distintas de null.
        */
        private Iterator<Entrada> sigIterador(){
            for(int j = indice; j < entradas.length; j++){
                if(entradas[j] == null)
                    continue;                
                indice = j;
                return entradas[j].iterator();                
            }
            return null;
        }
    }
    
    /* Clase interna privada para iteradores de llaves. */
    private class IteradorLlaves extends Iterador
    implements Iterator<K> {
        
        /* Regresa el siguiente elemento. */
        @Override public K next() {
            return siguiente().llave;
        }
    }
    
    /* Clase interna privada para iteradores de valores. */
    private class IteradorValores extends Iterador
    implements Iterator<V> {
        
        /* Regresa el siguiente elemento. */
        @Override public V next() {
            return siguiente().valor;
        }
    }
    
    /** Máxima carga permitida por el HashTable. */
    public static final double MAXIMA_CARGA = 0.72;
    
    /* Capacidad mínima; decidida arbitrariamente a 2^6. */
    private static final int MINIMA_CAPACIDAD = 64;
    
    /* Dispersor. */
    private Dispersor<K> dispersor;
    /* Nuestro HashTable. */
    private LinkedList<Entrada>[] entradas;
    /* Número de valores. */
    private int elementos;
    
    /* Truco para crear un arreglo genérico. Es necesario hacerlo así por cómo
    Java implementa sus genéricos; de otra forma obtenemos advertencias del
    compilador. */
    @SuppressWarnings("unchecked")
    private LinkedList<Entrada>[] nuevoArreglo(int n) {
        return (LinkedList<Entrada>[])Array.newInstance(LinkedList.class, n);
    }
    
    /**
    * Construye un HashTable con una capacidad inicial y dispersor
    * predeterminados.
    */
    public HashTable() {
        this(MINIMA_CAPACIDAD, (K llave) -> llave.hashCode());
    }
    
    /**
    * Construye un HashTable con una capacidad inicial definida por el
    * usuario, y un dispersor predeterminado.
    * @param capacidad la capacidad a utilizar.
    */
    public HashTable(int capacidad) {
        this(capacidad, (K llave) -> llave.hashCode());
    }
    
    /**
    * Construye un HashTable con una capacidad inicial predeterminada, y un
    * dispersor definido por el usuario.
    * @param dispersor el dispersor a utilizar.
    */
    public HashTable(Dispersor<K> dispersor) {
        this(MINIMA_CAPACIDAD, dispersor);
    }
    
    /**
     * Construye un HashTable con una capacidad inicial y un método de
     * dispersor definidos por el usuario.
     * @param capacidad la capacidad inicial del HashTable.
     * @param dispersor el dispersor a utilizar.
     */
    public HashTable(int capacidad, Dispersor<K> dispersor) {
        this.dispersor = dispersor;
        if(capacidad <= MINIMA_CAPACIDAD)
            entradas = nuevoArreglo(MINIMA_CAPACIDAD);
        else
            entradas = nuevoArreglo(capacidadBase2(capacidad));        
    }

    /**
     * Agrega un nuevo valor al HashTable, usando la llave proporcionada. Si
     * la llave ya había sido utilizada antes para agregar un valor, el
     * HashTable reemplaza ese valor con el recibido aquí.
     * @param llave la llave para agregar el valor.
     * @param valor el valor a agregar.
     * @throws IllegalArgumentException si la llave o el valor son nulos.
     */
    public void agrega(K llave, V valor) {
        if(llave == null || valor == null)
            throw new IllegalArgumentException("La llave o el valor son null.");
        int i = dispersor.dispersa(llave) & (entradas.length-1);
        if(entradas[i] == null){
            entradas[i] = new LinkedList<Entrada>();
            entradas[i].add(new Entrada(llave, valor));
            elementos ++;
        }else{
            boolean val = true;
            for(Entrada j: entradas[i]){
                if(j.llave.equals(llave)){
                    j.valor = valor;
                    val = false;
                }
            }
            if(val){
                entradas[i].add(new Entrada(llave, valor));
                elementos ++;
            }
        }        
        if(MAXIMA_CARGA <= carga())
            rehacerArreglo();        
    }

    /**
     * Regresa el valor del HashTable asociado a la llave proporcionada.
     * @param llave la llave para buscar el valor.
     * @return el valor correspondiente a la llave.
     * @throws IllegalArgumentException si la llave es nula.
     * @throws NoSuchElementException si la llave no está en el HashTable.
     */
    public V get(K llave) {
        if(llave == null)
            throw new IllegalArgumentException("La llave es null");
        int i = dispersor.dispersa(llave) & (entradas.length-1);
        if(entradas[i] == null)
            throw new NoSuchElementException("La llave no está en el HashTable.");        
        for(Entrada j: entradas[i]){
            if(llave.equals(j.llave)){
                return j.valor;
            }
        }
        throw new NoSuchElementException("La llave no está en el HashTable.");
    }

    /**
     * Nos dice si una llave se encuentra en el HashTable.
     * @param llave la llave que queremos ver si está en el HashTable.
     * @return <code>true</code> si la llave está en el HashTable,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(K llave) {
        if(llave == null)
            return false;
        int i = dispersor.dispersa(llave) & (entradas.length-1);
        if(entradas[i] == null)
            return false;
        for(Entrada j: entradas[i]){
            if(llave.equals(j.llave)){
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina el valor del HashTable asociado a la llave proporcionada.
     * @param llave la llave para buscar el valor a eliminar.
     * @throws IllegalArgumentException si la llave es nula.
     * @throws NoSuchElementException si la llave no se encuentra en
     *         el HashTable.
     */
    public void elimina(K llave) {
        if(llave == null)
            throw new IllegalArgumentException("La llave es null");
        int i = dispersor.dispersa(llave) & (entradas.length-1);
        if(entradas[i] == null)
            throw new NoSuchElementException("La llave no está en el HashTable.");
        boolean noEsta = true;
        for(Entrada j: entradas[i]){
            if(!llave.equals(j.llave))
                continue;
            noEsta = false;
            entradas[i].remove(j);
            elementos --;
            break;
        }
        if(entradas[i].isEmpty())
            entradas[i] = null;
        if(noEsta)
            throw new NoSuchElementException("La llave no está en el HashTable.");
    }

    /**
     * Nos dice cuántas colisiones hay en el HashTable.
     * @return cuántas colisiones hay en el HashTable.
     */
    public int colisiones() {
        int cont = 0;
        for(int i = 0; i < entradas.length; i++){
            if(entradas[i] != null){
                cont += entradas[i].size()-1;
            }
        }
        return cont;
    }

    /**
     * Nos dice el máximo número de colisiones para una misma llave que tenemos
     * en el HashTable.
     * @return el máximo número de colisiones para una misma llave.
     */
    public int colisionMaxima() {
        int cont = 0;
        for(int i = 0; i < entradas.length; i++){
            if(entradas[i] != null && cont < entradas[i].size()-1){
                cont = entradas[i].size()-1;
            }
        }
        return cont;
    }

    /**
     * Nos dice la carga del HashTable.
     * @return la carga del HashTable.
     */
    public double carga() {
        return (double)elementos / (double)entradas.length;
    }

    /**
     * Regresa el número de entradas en el HashTable.
     * @return el número de entradas en el HashTable.
     */
    public int getElementos() {
        return elementos;
    }

    /**
     * Nos dice si el HashTable es vacío.
     * @return <code>true</code> si el HashTable es vacío, <code>false</code>
     *         en otro caso.
     */
    public boolean esVacia() {
        return elementos == 0;
    }

    /**
     * Limpia el HashTable de elementos, dejándolo vacío.
     */
    public void limpia() {
        entradas = nuevoArreglo(entradas.length);
        elementos = 0;
    }

    /**
     * Regresa una representación en cadena del HashTable.
     * @return una representación en cadena del HashTable.
     */
    @Override public String toString() {
        String d = "{";
        for(int i = 0; i < entradas.length; i++){
            if(entradas[i] != null){
                for(Entrada a: entradas[i]){
                    d += String.format(" '%d': '%d',", a.llave, a.valor);
                }
            }
        }
        if(elementos != 0)
            d += " ";
        d += "}";
        return d;
    }

    /**
     * Nos dice si el HashTable es igual al objeto recibido.
     * @param o el objeto que queremos saber si es igual al HashTable.
     * @return <code>true</code> si el objeto recibido es instancia de
     *         HashTable, y tiene las mismas llaves asociadas a los mismos
     *         valores.
     */
    @Override public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked") HashTable<K, V> d =
            (HashTable<K, V>)o;
        if(elementos == d.elementos){
            for(int i = 0; i < entradas.length; i++){
                if(entradas[i] != null){
                    for(Entrada a: entradas[i]){
                        try{
                            if(a.valor.equals(d.get(a.llave)))
                                continue;
                            return false;
                        }catch(IllegalArgumentException e){
                            return false;
                        }catch(NoSuchElementException e){
                            return false;
                        }
                    }                    
                }                
            }
            return true;
        }
        return false;
    }

    /**
     * Regresa un iterador para iterar las llaves del HashTable. El
     * HashTable se itera sin ningún orden específico.
     * @return un iterador para iterar las llaves del HashTable.
     */
    public Iterator<K> iteradorLlaves() {
        return new IteradorLlaves();
    }

    /**
     * Regresa un iterador para iterar los valores del HashTable. El
     * HashTable se itera sin ningún orden específico.
     * @return un iterador para iterar los valores del HashTable.
     */
    @Override public Iterator<V> iterator() {
        return new IteradorValores();
    }

    /**
     * Metodo auxiliar que nos regresa la primera potencia de 2 que sea
     * mayor o igual al doble de la capacidad que le pasemos.
     * @param capacidad La capacidad original que le pasemos.
     * @return La primera potencia de 2 que sea mayor o igual al doble
     *         de la capacidad que le pasen.
     */
    private int capacidadBase2(int capacidad){
        int i = 128;
        while(i < 2*capacidad){
            i *= 2;
        }
        return i;
    }

    /**
     * Metodo auxiliar que nos ayuda a rehacer el arreglo si la carga
     * del HashTable, excede o iguala a la máxima carga, para que todo
     * siga siendo en tiempo constante(Amortizado).
     */
    private void rehacerArreglo(){
        LinkedList<Entrada>[] temp = entradas;
        entradas = nuevoArreglo(temp.length*2);
        elementos = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != null){
                for(Entrada a: temp[i]){
                    agrega(a.llave,a.valor);
                }                
            }
        }
    }
}
