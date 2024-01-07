import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterFinder {

    public static Set<Character> findUniqueCharacters(String[] texts) {
        Set<String> words = new HashSet<>();
        Set<Character> uniqueCharacters = new HashSet<>();
        int wordsFound = 0;

        for (String text : texts) {
            for (String word : text.split("\\s+")) {
                if (!words.add(word)) {
                    // Eğer kelime daha önce eklendiyse ve ikinci kez bulunmuşsa:
                    if (wordsFound < 2) {
                        for (char c : word.toCharArray()) {
                            uniqueCharacters.add(c);
                        }
                        wordsFound++;
                    }
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
