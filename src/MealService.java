import java.util.Scanner;
import java.util.List;
import java.util.Map;

class ConsoleCalorieInputHandler implements CalorieInputHandler {
    private final Scanner scanner;

    public ConsoleCalorieInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int getCalorieGoal() {
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

class MealService {
    private final CalorieInputHandler inputHandler;
    private final Map<Integer, List<String>> mealSuggestions = Map.of(
            1500, List.of("Greek yogurt with fruit", "Lentil soup with salad", "Oatmeal with nuts and berries"),
            2000, List.of("Grilled chicken with brown rice", "Veggie stir-fry with tofu", "Quinoa salad with chickpeas"),
            2500, List.of("Baked salmon with quinoa", "Chicken burrito bowl with veggies", "Steak with roasted sweet potatoes")
    );

    public MealService(CalorieInputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void suggestMeals() {
        int calorieGoal = inputHandler.getCalorieGoal();
        List<String> meals = mealSuggestions.getOrDefault(
                calorieGoal < 1500 ? 1500 : (calorieGoal < 2000 ? 2000 : 2500),
                List.of("Balanced plate: Protein + Veggies + Healthy Carbs")
        );

        System.out.println("\n Suggested Meals:");
        meals.forEach(meal -> System.out.println("✅ " + meal));
    }

}