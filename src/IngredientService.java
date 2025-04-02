import java.util.Map;
import java.util.Scanner;

class IngredientService {
    private final Map<String, String> swaps = Map.of(
            "sugar", "honey or stevia",
            "white rice", "brown rice or quinoa",
            "butter", "olive oil or avocado",
            "cream", "Greek yogurt"


    );

    public void suggestSwap(Scanner scanner) {
        System.out.print("Enter ingredient to swap: ");
        String input = scanner.nextLine().toLowerCase();

        String suggestion = swaps.getOrDefault(input, "No healthy swap found for that ingredient.");
        System.out.println("Suggestion: " + suggestion);
    }
}
