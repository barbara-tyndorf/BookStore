import java.util.InputMismatchException;

public class CalcApp {

    public double addValues (double val1, double val2) {
        return val1 + val2;
    }

    public double substValues (double val1, double val2){
        return val1 - val2;
    }
    public double powValue (double val1, double pow){
        if (pow < 0) {
            throw new ArithmeticException("");
        }
        return Math.pow(val1, pow);
    }
    public double divValue (double val1, double val2){
        if (val2 == 0) {
            throw new ArithmeticException();
        }
        return val1/val2;
    }


    public double sqrtValue(double val1) {
        if (val1 <= 0) {
            throw new ArithmeticException();
        }
        return Math.sqrt(val1);

    }
}
