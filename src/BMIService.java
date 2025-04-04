import java.util.Scanner;

public class BMIService {
    public void calculateAndDisplayBMI(Scanner scanner) {
        double weight = getInput(scanner, "Enter weight in kg: ");
        double heightCm = getInput(scanner, "Enter height in cm: ");
        double heightMeters = heightCm / 100.0;

        double bmi = weight / (heightMeters * heightMeters);

        System.out.printf("Your BMI is: %.2f%n", bmi);
        System.out.println(getBMICategory(bmi));
    }

    private double getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    private String getBMICategory(double bmi) {
        if (bmi < 16.0)
            return "Underweight (Severe thinness)";
        else if (bmi < 17.0)
            return "Underweight (Moderate thinness)";
        else if (bmi < 18.5)
            return "Underweight (Mild thinness)";
        else if (bmi < 25.0)
            return "Normal range";
        else if (bmi < 30.0)
            return "Overweight (Pre-obese)";
        else if (bmi < 35.0)
            return "Obese (Class I)";
        else if (bmi < 40.0)
            return "Obese (Class II)";
        else
            return "Obese (Class III)";
    }
}

