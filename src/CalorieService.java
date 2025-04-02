import java.util.InputMismatchException;
import java.util.Scanner;

class CalorieService {
    public void calculateAndDisplayCalorieGoal(Scanner scanner) {
        int age = getInt(scanner,          "Enter your age              : ");
        String sex = getString(scanner,    "Enter your sex (male/female): ");
        double weight = getDouble(scanner, "Enter your weight in kg     : ");
        double height = getDouble(scanner, "Enter your height in cm     : ");

        System.out.println("\nActivity Levels:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise 1–3 days/week)");
        System.out.println("3. Moderately active (moderate exercise 3–5 days/week)");
        System.out.println("4. Very active (hard exercise 6–7 days/week)");
        System.out.println("5. Super active (very intense daily training or physical job)");

        int activity = getIntInRange(scanner, "Activity Level [1-5]: ", 1, 5);
        int goal = getIntInRange(scanner, "Goal:\n1) Lose weight\n2) Maintain weight\n3) Gain weight\nEnter your choice: ", 1, 3);

        double bmr = calculateBMR(sex, weight, height, age);
        double tdee = bmr * getActivityFactor(activity);
        double adjustedCalories = adjustForGoal(tdee, goal);

        System.out.printf("\nYour daily calorie goal is: %.0f calories%n", adjustedCalories);
    }

    private double calculateBMR(String sex, double weight, double height, int age) {
        return sex.equalsIgnoreCase("male")
                ? 10 * weight + 6.25 * height - 5 * age + 5
                : 10 * weight + 6.25 * height - 5 * age - 161;
    }

    private double getActivityFactor(int level) {
        return switch (level) {
            case 1 -> 1.2;
            case 2 -> 1.375;
            case 3 -> 1.55;
            case 4 -> 1.725;
            case 5 -> 1.9;
            default -> throw new IllegalArgumentException("Invalid activity level: " + level);
        };
    }

    private double adjustForGoal(double tdee, int goal) {
        return switch (goal) {
            case 1 -> tdee - 500;
            case 3 -> tdee + 300;
            default -> tdee;
        };
    }

    private int getInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    private int getIntInRange(Scanner scanner, String prompt, int min, int max) {
        int value;
        do {
            value = getInt(scanner, prompt);
            if (value < min || value > max) {
                System.out.printf("⚠️ Invalid choice! Please enter a number between %d and %d.%n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    private double getDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next().trim();
    }
}
