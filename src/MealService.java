import java.io.*;
import java.util.*;

public class MealService {
    private final Scanner scanner;
    private final LinkedHashMap<Integer, Map<String, List<String>>> mealPlans = new LinkedHashMap<>();
    private static final String MEAL_PLAN_FILE = "mealplan.txt";

    public MealService(Scanner scanner) {
        this.scanner = scanner;
        loadMealPlans();
    }

    private void loadMealPlans() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MEAL_PLAN_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("\\|");
                if (parts.length != 3) continue;

                int calories = Integer.parseInt(parts[0].trim());
                String mealType = parts[1].trim();
                String mealItem = parts[2].trim();

                mealPlans.putIfAbsent(calories, new HashMap<>());
                Map<String, List<String>> categoryMap = mealPlans.get(calories);
                categoryMap.putIfAbsent(mealType, new ArrayList<>());
                categoryMap.get(mealType).add(mealItem);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to load meal plans: " + e.getMessage());
        }
    }

    public void suggestMeals() {
        int calorieGoal = getValidCalorieGoal();
        Map<String, List<String>> mealPlan = findClosestMealPlan(calorieGoal);

        if (mealPlan == null || mealPlan.isEmpty()) {
            System.out.println("⚠️ No meals available for your calorie goal.");
            return;
        }

        System.out.println("\nYOUR PERSONALIZED MEAL PLAN :");
        mealPlan.forEach((mealType, meals) -> {
            System.out.println("\n**********  " + mealType + "  **********");
            for (String meal : meals) {
                System.out.println( meal);
            }
        });
    }

    private int getValidCalorieGoal() {
        while (true) {
            System.out.print("Enter your daily calorie goal: ");
            String input = scanner.nextLine().trim();

            try {
                int calorieGoal = Integer.parseInt(input);
                if (calorieGoal > 500) return calorieGoal;
                System.out.println("⚠️ Please enter a realistic calorie goal above 500.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a number.");
            }
        }
    }

    private Map<String, List<String>> findClosestMealPlan(int calorieGoal) {
        for (Integer key : mealPlans.keySet()) {
            if (calorieGoal <= key) return mealPlans.get(key);
        }
        return mealPlans.get(mealPlans.keySet().stream().max(Integer::compareTo).orElse(0));
    }
}
