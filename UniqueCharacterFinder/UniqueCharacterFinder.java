import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterFinder {

    public static Set<Character> findUniqueCharacters(String[] texts) {
        Set<Character> uniqueCharacters = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();

        for (String text : texts) {
            for (char c : text.toCharArray()) {
                if (!seenCharacters.add(c)) {
                    // If the character has been seen before, add it to the uniqueCharacters set.
                    uniqueCharacters.add(c);
                }
            }
        }

        return uniqueCharacters;
    }

    public static void main(String[] args) {
        String[] texts = {"hello", "world", "find", "world", "find", "good", "hello"};
        Set<Character> result = findUniqueCharacters(texts);
        System.out.println("Unique characters: " + result);
    }
}
