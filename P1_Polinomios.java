public class Polinomio {
    private int[] coeficientes;

    public Polinomio() {
        // this.coeficientes = new int[] {0};
        this.coeficientes = new int[0];
    }
    
    public Polinomio(int[] polinomio) {
        this.polinomio = polinomio
    }
    
    def public int grado() {
        for (int i = coeficientes.length - 1; i >= 0; i--) {
            if (coeficientes[i] != 0) {
                return i;
        }
    
    def public int coeficiente(int i) {
        if (polinomio.length < i) {
            return 0;
        }
        return polinomio[i];
    }
  
    def public void coeficiente(int i, int v) {
        polinomio[i] = v;
    }

    def public int[] coeficientes() {
        return Arrays.copyOf(polinomio, polinomio.length);
    }
        
    //def public String toString() {
    //   return
    //}
        
    def public float valor(float v) {
        float cont = 0
        for (int i = 0; i < coeficientes.length; i++) {
            cont += coeficientes[i] * Math.pow(v, i);
        }
        return cont
    }

    def public Polinomio suma(Polinomio other) {
        int gradoMax = Math.max(this.grado(), other.grado());
        int[] nuevoCoefs = new int[gradoMax];

        for (int i = 0; i <= gradoMax; i++) {
            nuevoCoefs[i] = this.polinomio(i) + other.polinomio(i);
        }

        return new Polinomio(nuevoCoefs);
    }
        
    def public Polinomio resta(Polinomio other) {
        int gradoMax = Math.max(this.grado(), other.grado());
        int[] nuevoCoefs = new int[gradoMax];

        for (int i = 0; i <= gradoMax; i++) {
            nuevoCoefs[i] = this.polinomio(i) - other.polinomio(i);
        }

        return new Polinomio(nuevoCoefs);
    }
}

