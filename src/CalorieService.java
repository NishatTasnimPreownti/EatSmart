import java.util.InputMismatchException;
import java.util.Scanner;

public class CalorieService {
    private final Scanner scanner;
    private final CalorieCalculator calculator = new CalorieCalculator();
    private final GoalAdjuster adjuster = new GoalAdjuster();
    private final WeightGoalEstimator estimator = new WeightGoalEstimator();

    public CalorieService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void calculateAndDisplayCalorieGoal() {
        int age = getInt("Enter your age: ");
        String sex = getValidSex("Enter your sex (male/female): ");
        double weight = getDouble("Enter your weight in kg: ");
        double height = getDouble("Enter your height in cm: ");

        displayActivityLevels();
        int activity = getIntInRange("Activity Level [1-5]: ", 1, 5);
        int goal = getIntInRange("Goal:\n1) Lose weight\n2) Maintain weight\n3) Gain weight\nEnter your choice: ", 1, 3);

        double bmr = calculator.calculateBMR(sex, weight, height, age);
        double tdee = calculator.calculateTDEE(bmr, activity);
        double adjustedCalories = adjuster.adjustCalories(tdee, goal);

        System.out.printf("\nYour daily calorie goal is: %.0f calories%n", adjustedCalories);

        if (goal == 1 || goal == 3) {
            double targetKg = getDouble("\nHow many kg do you want to " + (goal == 1 ? "lose" : "gain") + "? ");
            estimator.estimateDuration(tdee, adjustedCalories, targetKg, goal);
        }
    }

    private void displayActivityLevels() {
        System.out.println("\nActivity Levels:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise 1–3 days/week)");
        System.out.println("3. Moderately active (moderate exercise 3–5 days/week)");
        System.out.println("4. Very active (hard exercise 6–7 days/week)");
        System.out.println("5. Super active (very intense daily training or physical job)");
    }

    private int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    private int getIntInRange(String prompt, int min, int max) {
        int value;
        do {
            value = getInt(prompt);
            if (value < min || value > max) {
                System.out.printf("⚠️ Please enter a number between %d and %d.%n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    private double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private String getValidSex(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("male") || input.equals("female")) {
                return input;
            } else {
                System.out.println("⚠️ Invalid input for sex. Only 'male' or 'female' are allowed.");
            }
        }
    }
}
