import java.util.Arrays;

public class Polinomio {
    // this.coeficientes = new int[] {0};
    private int[] polynomial;

    public Polinomio() {
        this.polynomial = new int[0];
    }

    public Polinomio(int[] coeficients) {

        int lastNotZero = coeficients.length;
        for (int i = 0; i < coeficients.length; i++) {
            if (coeficients[i] != 0) {
                lastNotZero = i;
                break;
            }
        }

        this.polynomial = Arrays.copyOfRange(coeficients, lastNotZero, coeficients.length);
    }

    public int grado() {
        return this.polynomial.length > 0 ? this.polynomial.length - 1 : this.polynomial.length;
    }

    public int coeficiente(int i) {
        if (i < 0 || i > this.polynomial.length - 1)
            return 0;
        i = this.polynomial.length - (i + 1);

        return this.polynomial[i];
    }

    public void coeficiente(int index, int v) {
        if (this.polynomial.length - 1 >= index) {
            this.polynomial[index] = v;
        } else {
            this.polynomial = Arrays.copyOf(polynomial, index + 1);
            this.polynomial[index] = v;
        }

        int lastNotZero = this.polynomial.length;
        for (int i = 0; i < this.polynomial.length; i++) {
            if (this.polynomial[i] != 0) {
                lastNotZero = i;
                break;
            }
        }

        this.polynomial = Arrays.copyOfRange(this.polynomial, lastNotZero, this.polynomial.length);
    }

    public int[] coeficientes() {
        return Arrays.copyOf(polynomial, polynomial.length);
    }

    public Polinomio suma(Polinomio other) {
        int gradoMax = Math.max(this.grado(), other.grado());
        int[] nuevoCoefs = new int[gradoMax];

        for (int i = 0; i <= gradoMax; i++) {
            nuevoCoefs[i] = this.polynomial[i] + other.polynomial[i];
        }

        return new Polinomio(nuevoCoefs);
    }

    public Polinomio resta(Polinomio other) {
        int gradoMax = Math.max(this.grado(), other.grado());
        int[] nuevoCoefs = new int[gradoMax];

        for (int i = 0; i <= gradoMax; i++) {
            nuevoCoefs[i] = this.polynomial[i] - other.polynomial[i];
        }

        return new Polinomio(nuevoCoefs);
    }

    public float valor(float v) {
        float result = 0;
        for (int i = 0; i < polynomial.length; i++) {
            result += polynomial[i] * Math.pow(v, i);
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.polynomial.length; i++) {
            final int value = this.polynomial[i];
            if (value != 0 && i < this.polynomial.length - 2) {
                result += value > 0 && i != 0 ? "+" : "";
                result += value != 1 ? String.format("%dx^%d", value, this.polynomial.length - (i + 1))
                        : String.format("x^%d", this.polynomial.length - 1 - i);
            } else if (value != 0 && i == this.polynomial.length - 2) {
                result += value > 0 ? "+" : "";
                result += value != 1 ? String.format("%dx", value) : "x";
            } else if (i == this.polynomial.length - 1) {
                result += result != "" && value > 0 ? String.format("+%d", value) : "";
            }
        }

        return result;
    }
}
