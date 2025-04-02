import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BMIService bmiService = new BMIService();
        CalorieService calorieService = new CalorieService();
        MealService mealService = new MealService(scanner);
        IngredientService ingredientService = new IngredientService();
        ChallengeService challengeService = new ChallengeService();

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> bmiService.calculateAndDisplayBMI(scanner);
                case 2 -> calorieService.calculateAndDisplayCalorieGoal(scanner);
                case 3 -> mealService.suggestMeals();
                case 4 -> ingredientService.suggestAlternative(scanner);
                case 5 -> challengeService.showRandomChallenge();
                case 6 -> {
                    System.out.println("Thanks for using the app! Stay healthy!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- EAT SMART ---");
        System.out.println("1. Calculate BMI");
        System.out.println("2. Get Daily Calorie Goal");
        System.out.println("3. Suggest Meals by Calorie Goal");
        System.out.println("4. Ingredient Swap");
        System.out.println("5. Daily Challenge");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
}