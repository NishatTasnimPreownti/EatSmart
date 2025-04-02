import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MealService {
    private final Scanner scanner;
    private final Map<Integer, List<String>> mealSuggestions = Map.of(
            1500, List.of("Greek yogurt with fruit", "\nLentil soup with salad", "\nOatmeal with nuts and berries"),
            2000, List.of("Grilled chicken with brown rice", "\nVeggie stir-fry with tofu", "\nQuinoa salad with chickpeas"),
            2500, List.of("Baked salmon with quinoa", "\nChicken burrito bowl with veggies", "\nSteak with roasted sweet potatoes")
    );

    public MealService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void suggestMeals() {
        int calorieGoal = getValidCalorieGoal();

        List<String> meals = mealSuggestions.getOrDefault(
                calorieGoal < 1500 ? 1500 : (calorieGoal < 2000 ? 2000 : 2500),
                List.of("Balanced plate: Protein + Veggies + Healthy Carbs")
        );

        System.out.println("\n🍽 Suggested Meals:");
        meals.forEach(meal -> System.out.println("✅ " + meal));
    }

    private int getValidCalorieGoal() {
        while (true) {
            System.out.print("Enter your calorie goal: ");
            if (scanner.hasNextInt()) {
                int calorieGoal = scanner.nextInt();
                if (calorieGoal > 500) {
                    return calorieGoal;
                }
                System.out.println("⚠️ Please enter a realistic calorie goal above 500.");
            } else {
                System.out.println("⚠️ Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }
}
