import java.io.*;
import java.util.*;

class IngredientService {
    private static final String SWAPS_FILE = "swaps.txt";
    private final Map<String, String> swaps = new HashMap<>();

    public IngredientService() {
        loadSwapsFromFile();
    }

    public void suggestAlternative(Scanner scanner) {
        System.out.print("Enter a food item to find a healthier alternative: ");
        String input = scanner.nextLine().trim().toLowerCase();
        String suggestion = swaps.getOrDefault(input, "No healthy alternative found for that item.");
        System.out.println("Alternative: " + suggestion);
    }

    private void loadSwapsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SWAPS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    swaps.put(parts[0].trim().toLowerCase(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file '" + SWAPS_FILE + "': " + e.getMessage());
        }
    }
}
