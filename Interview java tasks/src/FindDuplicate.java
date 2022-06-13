import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> elements = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        elements.set(20,22);
        findDuplicate(elements);
        findDuplicateWithHashSet(elements);
    }

    private static void findDuplicate(List<Integer> elements) {
        int sumOfUniqueElements = elements.stream().distinct().mapToInt(e -> e).sum();
        int sumOfAllElements = elements.stream().mapToInt(e -> e).sum();
        System.out.println("Повторяющийся элемент найден через разницу двух сумм: " +
                (sumOfAllElements - sumOfUniqueElements));
    }

    private static void findDuplicateWithHashSet(List<Integer> elements) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer e: elements) {
            if (!hashSet.contains(e)) {
                hashSet.add(e);
            }
            else System.out.println("Повторяющийся элемент найден с помощью HashSet: " + e);
        }
    }


}
