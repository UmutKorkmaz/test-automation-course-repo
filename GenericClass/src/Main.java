public class Main {
    public static void main(String[] args) {
        // Kullanım örneği:
        // String için örnek
        GenericClass<String> stringExample = new GenericClass<>("Hello World");
        stringExample.printField(); // Ekrana "Hello World" yazdırır.

        // Integer için örnek
        GenericClass<Integer> integerExample = new GenericClass<>(123);
        integerExample.printField(); // Ekrana "123" yazdırır.
    }
}

