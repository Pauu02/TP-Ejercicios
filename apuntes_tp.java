//-19/09/2024-
public class Ejemplo {
    
    // psv
    public static void main(String[] args) {
        System.out.println("¡Hola Mundo!");
        
        byte b = 8; // 8 bits
        short s = 16; // 16 bits
        int x = 32; // 32 bits
        long myLong = 64; // 64 bits
        char c = 'c'; //character
        
        float f = 32; // 32 bits
        double d = 64; //64 bits
        
        String s1 = "Hola";
        String s2 = "Hola";
        
        // == commparar posición de memoria
        //compara si las cadenas de texto ocupan
        //la misma direccion de memoria no sin son iguales
        //para ver si son iguaes método equals
        //System.out.println(s1.equals(s2));
        if (s1 == s2) {
            System.out.println("Son iguales");
        }
        
        // if (condicionLogica) { -> expresión dé como resultado True o False
        
        if (5 > 4) {
            x = 3;
        
        } else if (condicionLogica) {
        x += 3;
        
        } else  {
            
        }
        
        for (int i = 0; i < MAX; i += 3) {
            
        }
        
        while (condicionLogica) {
            
        }
        
        do {
            //entra una vez en el bloque
        } while (condicionLogica);
        
        //for-each
        String[] cadenas;
        for (String c : cadenas) {
            
        }
    }
}

// -26/09/2024-
// Matrices

int source = new int[] {1, 2, 3, 4, 5};

int copy = new int[source.length]

for (int i = 0; i < source.length - 1; i++) {
    copy[i] = source[i];
}

//java.util.Arrays
import java.util.Arrays;

int[] copia = Arrays.copyOf(enteros, enteros.length);

//Se rellena con ceros
int[] copia = Arrays.copyOf(enteros, 10);

Arrays.copyOf(source, numItemsToCopy)
Arrays.copyOf(enteros, posInicial, posFinal)
Arrays.equals(enteros, copia)

//Está mal, da igual que el resultado sea cierto
"Hola" == "Hola"
//Todos los objetos se comparan con el método equals
"Hola".equals("Hola")

String holaUno = String.format("Hola")
String holaDos = String.format("Hola")
"holaUno" == "holaDos" //Da false (MAL)
"holaUno".equals("holaDos") //Da true (BIEN)

// Object
// - toString (para que se pueda imprimir el objeto hay que sobreescribir el método)
// - hashCode
// - equals(...)

//No lleva método equals
public class GestorEstudiantes {
    List<Estudiantes> estudiantes;
}

//Lleva método equals
public class Estudiante {
    
}


