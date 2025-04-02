import java.util.Scanner;

class MealService {
    public void suggestMeals(Scanner scanner) {
        System.out.print("Enter your calorie goal: ");
        int calorieGoal = scanner.nextInt();

        System.out.println("Suggested Meals:");
        if (calorieGoal < 1500) {
            printMeals("Greek yogurt with fruit", "Lentil soup with salad");
        } else if (calorieGoal < 2000) {
            printMeals("Grilled chicken with brown rice", "Veggie stir-fry with tofu");
        } else {
            printMeals("Baked salmon with quinoa", "Chicken burrito bowl with veggies");
        }
    }

    private void printMeals(String... meals) {
        for (String meal : meals) {
            System.out.println("- " + meal);
        }
    }
}