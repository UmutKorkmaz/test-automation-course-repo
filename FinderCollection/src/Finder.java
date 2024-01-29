import java.util.Collection;
import java.util.Optional;

public class Finder {
    public static <T> String findItem(Collection<T> collection, T itemToFind) {
        return Optional.ofNullable(collection)
                .flatMap(coll -> coll.stream().filter(item -> item.equals(itemToFind)).findFirst())
                .map(Object::toString)
                .orElse("-1");
    }
}
