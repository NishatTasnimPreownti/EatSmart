import java.util.*;

class MealService {
    private final Scanner scanner;
    private final LinkedHashMap<Integer, Map<String, List<String>>> mealPlans = new LinkedHashMap<>();

    public MealService(Scanner scanner) {
        this.scanner = scanner;
        loadMealPlans();
    }

    private void loadMealPlans() {
        mealPlans.put(1200, Map.of(
                "Breakfast", List.of("Scrambled eggs with spinach", "Chia pudding with nuts", "Greek yogurt with granola"),
                "Lunch", List.of("Grilled fish with steamed veggies", "Lentil soup with salad", "Quinoa bowl with black beans"),
                "Dinner", List.of("Vegetable stir-fry with tofu", "Chicken salad with vinaigrette", "Stuffed bell peppers"),
                "Snacks", List.of("Cottage cheese with berries", "Handful of almonds", "Carrot sticks with hummus")
        ));

        mealPlans.put(1500, Map.of(
                "Breakfast", List.of("Oatmeal with nuts and berries", "Smoothie with protein powder", "Avocado toast with eggs"),
                "Lunch", List.of("Grilled chicken with brown rice", "Tuna wrap with whole wheat tortilla", "Vegetable soup with lentils"),
                "Dinner", List.of("Quinoa salad with chickpeas", "Turkey and hummus wrap", "Tofu and vegetable curry"),
                "Snacks", List.of("Apple with peanut butter", "Boiled eggs", "Handful of walnuts")
        ));

        mealPlans.put(1800, Map.of(
                "Breakfast", List.of("Egg and veggie omelet", "Smoothie with protein powder", "Pancakes with almond butter"),
                "Lunch", List.of("Chicken and sweet potato bowl", "Tofu stir-fry with brown rice", "Bulgur wheat with lentils"),
                "Dinner", List.of("Greek salad with grilled lamb", "Grilled shrimp with quinoa", "Salmon with roasted veggies"),
                "Snacks", List.of("Handful of mixed nuts", "Yogurt with flaxseeds", "Cucumber slices with tzatziki")
        ));

        mealPlans.put(2000, Map.of(
                "Breakfast", List.of("Avocado toast with eggs", "Protein smoothie with peanut butter", "Scrambled eggs with whole wheat toast"),
                "Lunch", List.of("Beef and broccoli stir-fry", "Pasta with turkey meatballs", "Buddha bowl with grilled tofu"),
                "Dinner", List.of("Salmon with roasted vegetables", "Steak fajitas with whole wheat tortillas", "Lamb kebabs with couscous"),
                "Snacks", List.of("Dark chocolate with almonds", "Cheese and whole grain crackers", "Banana with almond butter")
        ));

        mealPlans.put(2500, Map.of(
                "Breakfast", List.of("Peanut butter toast with banana", "Omelet with whole wheat toast", "Protein pancakes with Greek yogurt"),
                "Lunch", List.of("Baked tilapia with rice and beans", "Chicken burrito bowl with veggies", "Quinoa and grilled tofu wrap"),
                "Dinner", List.of("Lamb chops with mashed potatoes", "Salmon tacos with avocado slaw", "Chicken Alfredo with whole wheat pasta"),
                "Snacks", List.of("Granola with Greek yogurt", "Smoothie with banana and almond butter", "Trail mix with dried fruit")
        ));
    }

    public void suggestMeals() {
        int calorieGoal = getValidCalorieGoal();
        Map<String, List<String>> mealPlan = findClosestMealPlan(calorieGoal);

        System.out.println("\n🍽 YOUR PERSONALIZED MEAL PLAN :");
        mealPlan.forEach((mealType, meals) -> {
            System.out.println("\n **********  " + mealType + "  **********");
            meals.forEach(meal -> System.out.println("✅ " + meal));
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
        return mealPlans.get(2500);
    }
}
