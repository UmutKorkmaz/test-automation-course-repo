import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterFinder {

    public static Set<Character> findUniqueCharacters(String[] texts) {
        Set<Character> uniqueCharacters = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();

        for (String text : texts) {
            for (char c : text.toCharArray()) {
                if (!seenCharacters.add(c)) {
                    // Eğer kelime daha önce eklendiyse ve ikinci kez bulunmuşsa:
                    uniqueCharacters.add(c);
                }
            }
        }

        return uniqueCharacters;
    }

    public static String generateTextFromUniqueCharacters(Set<Character> uniqueCharacters) {
        StringBuilder result = new StringBuilder();
        
        for (Character c : uniqueCharacters) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] texts = {"hello", "world", "find", "world", "find", "good", "hello"};
        Set<Character> uniqueCharacters = findUniqueCharacters(texts);
        String generatedText = generateTextFromUniqueCharacters(uniqueCharacters);
        System.out.println("Generated text from unique characters: " + generatedText);
    }
}
