public class Main {
    public static void main(String[] args) {
        testDivide(10, 0); // Bölen sıfır olduğunda
        testDivide(-10, 5); // Negatif sayılar verildiğinde
        testDivide(5, 10); // Bölünen, böleninden küçük olduğunda
        testDivide(10, 5); // Normal durum
    }

    private static void testDivide(int dividend, int divisor) {
        try {
            double result = Calculator.divide(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument: " + e.getMessage());
        } catch (CustomException e) {
            System.out.println("Custom Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Error: " + e.getMessage());
        }
    }}