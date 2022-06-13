import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicates {
    public static void main(String[] args) {
        List<Integer> elements = IntStream.range(0, 101).boxed().collect(Collectors.toList());
        elements.set(11, 55);
        elements.set(22, 55);
        elements.set(33, 100);
        findDuplicates(elements);
    }

    private static void findDuplicates(List<Integer> elements) {
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        elements.forEach(e -> duplicates
                .put(e, duplicates.get(e) == null ? 1 : duplicates.get(e) + 1));
        List <Map.Entry <Integer, Integer> > result;
        result = duplicates
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toList());
        result.forEach(e -> System.out.printf("Элемент %d встречается %d раз%n", e.getKey(), e.getValue()));
    }
}
