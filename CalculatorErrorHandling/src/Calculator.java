public class Calculator {

    public static double divide(int dividend, int divisor) throws ArithmeticException, IllegalArgumentException, CustomException {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero.");
        }
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        if (dividend < divisor) {
            throw new CustomException("Dividend should be greater than or equal to divisor.");
        }
        return (double) dividend / divisor;
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
