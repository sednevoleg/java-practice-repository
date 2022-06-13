import java.util.HashMap;

public class CountWordsInString {
    public static void main(String[] args) {
        countWordsInString();
    }

    private static void countWordsInString() {
        String st = "Hello hello Hello World World";

        String[] words = st.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        HashMap<String,Integer> keyValue = new HashMap<>();
        for (int i=0; i<= words.length-1; i++) {
            if (keyValue.containsKey(words[i])) {
                int counter = keyValue.get(words[i]);
                keyValue.put(words[i], counter+1);
            }
            else {
                keyValue.put(words[i], 1);
            }
        }
        System.out.println(keyValue);
    }

}
