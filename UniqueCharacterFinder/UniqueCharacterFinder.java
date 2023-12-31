import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterFinder {

    public static Set<Character> findUniqueCharacters(String[] texts) {
        Set<Character> foundCharacters = new HashSet<>();
        Set<Character> uniqueCharacters = new HashSet<>();
        int wordsFound = 0;

        for (String text : texts) {
            for (String word : text.split("\\s+")) {
                if (wordsFound < 2 && allCharsRepeat(texts, word)) {
                    for (char c : word.toCharArray()) {
                        uniqueCharacters.add(c);
                    }
                    wordsFound++;
                }
            }
        }

        return uniqueCharacters;
    }

    private static boolean allCharsRepeat(String[] texts, String word) {
        for (char c : word.toCharArray()) {
            int count = 0;
            for (String text : texts) {
                for (char textChar : text.toCharArray()) {
                    if (textChar == c) {
                        count++;
                    }
                }
            }
            if (count < 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] texts = {"hello world", "good day", "repeatable characters", "final test"};
        Set<Character> result = findUniqueCharacters(texts);
        System.out.println("Unique characters: " + result);
    }
}
