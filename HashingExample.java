import java.util.HashMap;
import java.util.Map;

public class HashingExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Insert key-value pairs
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Orange", 2);

        // Retrieve value by key
        System.out.println("Quantity of Bananas: " + map.get("Banana"));

        // Check if key exists
        if (map.containsKey("Orange")) {
            System.out.println("Orange is in the map.");
        }

        // Iterate over the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}
