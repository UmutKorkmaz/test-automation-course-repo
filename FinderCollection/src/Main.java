import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Integer listesi için örnek");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(Finder.findItem(numbers, 3)); // 3 döndürür
        System.out.println(Finder.findItem(numbers, 6)); // -1 döndürür

        System.out.println("-----");

        System.out.println("String listesi için örnek");
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println(Finder.findItem(words, "banana")); // "banana" döndürür
        System.out.println(Finder.findItem(words, "orange")); // -1 döndürür
    }
}
