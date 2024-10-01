import java.util.Arrays;

public class Polinomio {
    private int[] polynomial;

    public static void main(String[] args) {
        Polinomio pol = new Polinomio();
        Polinomio pol2 = new Polinomio(new int[]{1, 0, 1, 0, 2});
        System.out.println(String.format("%s - %s", pol.toString(), pol2.toString()));
        Polinomio polSuma = pol.resta(pol2);
        System.out.println(polSuma.toString());
    }

    public Polinomio() { this.polynomial = new int[]{0}; }
    public Polinomio(int[] coeficients) {
        
        int lastNotZero = 1;
        for (int i = coeficients.length - 1; i >= 0; i--) {
            if (coeficients[i] != 0 || i == 0) {
                lastNotZero = i + 1;
                break;
            }
        }
 
        this.polynomial = Arrays.copyOfRange(coeficients, 0, lastNotZero);
    }

    public int grado() {
        return this.polynomial.length > 0 ? this.polynomial.length - 1 : this.polynomial.length;
    }
    
    public int coeficiente(int index) {
        if (index < 0 || index > this.polynomial.length - 1) return 0;
        
        return this.polynomial[index];
    }
    
    public void coeficiente(int index, int value) {
        if (this.polynomial.length -1 >= index) {
            this.polynomial[index] = value;
        } else {
            this.polynomial = Arrays.copyOf(polynomial, index+1);
            this.polynomial[index] = value;
        }
        
        int lastNotZero = 1;
        for (int i = polynomial.length - 1; i >= 0; i--) {
            if (polynomial[i] != 0 || i == 0) {
                lastNotZero = i + 1;
                break;
            }
        }
        
        this.polynomial = Arrays.copyOfRange(this.polynomial, 0, lastNotZero);
    }
    
    public int[] coeficientes() {
        return Arrays.copyOf(polynomial, polynomial.length);
    }
    
    public Polinomio suma(Polinomio other) {
        final int greatestLen = other.coeficientes().length > this.polynomial.length ? other.coeficientes().length : this.polynomial.length;
        
        final int[] thisPol = Arrays.copyOf(this.polynomial, greatestLen);
        final int[] otherPol = Arrays.copyOf(other.coeficientes(), greatestLen);
        
        int[] sum = new int[greatestLen];
        for (int i = 0; i < greatestLen; i++) {
            sum[i] = thisPol[i] + otherPol[i];
        }
        
        return new Polinomio(sum);
    }
    
    public Polinomio resta(Polinomio other) {
        final int greatestLen = other.coeficientes().length > this.polynomial.length ? other.coeficientes().length : this.polynomial.length;
        
        final int[] thisPol = Arrays.copyOf(this.polynomial, greatestLen);
        final int[] otherPol = Arrays.copyOf(other.coeficientes(), greatestLen);
        
        System.out.println(Arrays.toString(thisPol));
        System.out.println(Arrays.toString(otherPol));
        int[] sub = new int[greatestLen];
        for (int i = 0; i < greatestLen; i++) {
            sub[i] = thisPol[i] - otherPol[i];
        }
        System.out.println(Arrays.toString(sub));
        
        return new Polinomio(sub);
    }
    
    public float valor(float value) {
        float result = 0;
        for (int i = this.polynomial.length - 1; i >= 0 ; i--) {
            result += this.polynomial[i] * Math.pow(value, i);
        }
        return result;
    }
    
    @Override
    public String toString() {
        String result = "";
        
        for (int i = this.polynomial.length - 1; i >= 0; i--) {
            final int value = this.polynomial[i];
            if (value != 0 && i > 1) {
                result += value > 0 ? !result.isEmpty() ? "+" : "" :  "-";
                result += Math.abs(value) != 1 ? String.format("%dx^%d", Math.abs(value), i) : String.format("x^%d", i);
            } else if (value != 0  && i == 1) {
                result += value > 0 ? !result.isEmpty() ? "+" : "" :  "-";
                result += Math.abs(value) != 1 ? String.format("%dx", Math.abs(value)) : "x";
            } else if (i == 0) {
                result += value > 0 && !result.isEmpty() ? "+" : "";
                result += result.isEmpty() || value != 0 ? value : "";
            }
        }
        
        return result;
    }
}
