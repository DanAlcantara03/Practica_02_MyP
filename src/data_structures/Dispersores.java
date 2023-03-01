package data_structures;

/**
* Clase para métodos estáticos con dispersores de bytes.
*/
public class Dispersores {
    
    /* Constructor privado para evitar instanciación. */
    private Dispersores() {}
    
    /**
    * Función de dispersión XOR.
    * Esta función de dispersión no es tan recomendable de usar
    * yq que es muy facil encontrar una colisión en esta.
    * @param llave la llave a dispersar.
    * @return la dispersión de XOR de la llave.
    */
    public static int dispersaXOR(byte[] llave) {
        int r = 0;
        int longLlave = llave.length, i = 0;
        while(longLlave > 3){
            r ^= bigEndian(llave[i], llave[i+1], llave[i+2], llave[i+3]);
            i += 4;
            longLlave -= 4;
        }
        if(0 < longLlave){
            if(longLlave == 3){
                r ^= bigEndian(llave[i], llave[i+1], llave[i+2], (byte) 0x00);
            }else if(longLlave == 2){
                r ^= bigEndian(llave[i], llave[i+1], (byte) 0x00, (byte) 0x00);
            }else if(longLlave == 1 ){
                r ^= bigEndian(llave[i], (byte) 0x00, (byte) 0x00, (byte) 0x00);
            }
        }
        return r;
    }
    
    /**
    * Función de dispersión de Bob Jenkins.
    * @param llave la llave a dispersar.
    * @return la dispersión de Bob Jenkins de la llave.
    */
    public static int dispersaBJ(byte[] llave) {
        int a = 0x9E3779B9, b = 0x9E3779B9, c = 0xFFFFFFFF;
        int longLLave = llave.length, i = 0;
        while(longLLave >= 12){
            a += littleEndian(llave[i], llave[i+1], llave[i+2], llave[i+3]);
            b += littleEndian(llave[i+4], llave[i+5], llave[i+6], llave[i+7]);
            c += littleEndian(llave[i+8], llave[i+9], llave[i+10], llave[i+11]);            
            // Mezclamos:
            // 1a
            a -= b; a -= c; a ^= (c >>> 13);
            //1b
            b -= c; b -= a; b ^= (a << 8);
            //1c
            c -= a; c -= b; c ^= (b >>> 13);
            //2a
            a -= b; a -= c; a ^= (c >>> 12);
            //2b
            b -= c; b -= a; b ^= (a << 16);
            //2c
            c -= a; c -= b; c ^= (b >>> 5);
            //3a
            a -= b; a -= c; a ^= (c >>> 3);
            //3b
            b -= c; b -= a; b ^= (a << 10);
            //3c
            c -= a; c -= b; c ^= (b >>> 15);
            
            i += 12;
            longLLave -= 12;
        }
        c += (llave.length & 0xFF);
        switch(longLLave){
            case 11: c += ((llave[i+10] & 0xFF) << 24);
            case 10: c += ((llave[i+9] & 0xFF) << 16);
            case 9: c += ((llave[i+8] & 0xFF) << 8);
            case 8: b += ((llave[i+7] & 0xFF) << 24);
            case 7: b += ((llave[i+6] & 0xFF) << 16);
            case 6: b += ((llave[i+5] & 0xFF) << 8);
            case 5: b += (llave[i+4] & 0xFF);
            case 4: a += ((llave[i+3] & 0xFF) << 24);
            case 3: a += ((llave[i+2] & 0xFF) << 16);
            case 2: a += ((llave[i+1] & 0xFF) << 8);
            case 1: a += (llave[i] & 0xFF);
        }
        // 1a
        a -= b; a -= c; a ^= (c >>> 13);
        //1b
        b -= c; b -= a; b ^= (a << 8);
        //1c
        c -= a; c -= b; c ^= (b >>> 13);
        //2a
        a -= b; a -= c; a ^= (c >>> 12);
        //2b
        b -= c; b -= a; b ^= (a << 16);
        //2c
        c -= a; c -= b; c ^= (b >>> 5);
        //3a
        a -= b; a -= c; a ^= (c >>> 3);
        //3b
        b -= c; b -= a; b ^= (a << 10);
        //3c
        c -= a; c -= b; c ^= (b >>> 15);
        return c;
    }
    
    /**
    * Función de dispersión Daniel J. Bernstein.
    * @param llave la llave a dispersar.
    * @return la dispersión de Daniel Bernstein de la llave.
    */
    public static int dispersaDJB(byte[] llave) {
        int h = 5381;
        for(int i = 0; i < llave.length; i++){
            h += (h << 5) + (llave[i] & 0xFF);
        }
        return h;
    }
    
    /**
    * Metodo estatico que nos ayuda a empaqutar 4 bytes en un int de
    * 32 bits empezando por el byte menos significativo
    * @param a El primer byte que queremos empaquetar.
    * @param b El segundo byte que queremos empaquetar.
    * @param c El tercer byte que queremos empaquetar.
    * @param d El cuarto byte que queremos empaquetar.
    * @return El entero en el que empaquetamos los cuatro bits en
    *         littleEndian.
    */
    private static int littleEndian(byte a, byte b, byte c, byte d){
        return ((d & 0xFF) << 24) | ((c & 0xFF) << 16) | ((b & 0xFF) << 8) | (a & 0xFF);
    }

    /**
    * Metodo estatico que nos ayuda a empaqutar 4 bytes en un int de
    * 32 bits empezando por el byte más significativo
    * @param a El primer byte que queremos empaquetar.
    * @param b El segundo byte que queremos empaquetar.
    * @param c El tercer byte que queremos empaquetar.
    * @param d El cuarto byte que queremos empaquetar.
    * @return El entero en el que empaquetamos los cuatro bits en
    *         bigEndian.
    */
    private static int bigEndian(byte a, byte b, byte c, byte d){                
        return ((a & 0xFF) << 24) | ((b & 0xFF) << 16) | ((c & 0xFF) << 8) | (d & 0xFF);
    }

}
