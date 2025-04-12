import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class WeightGoalEstimator {
    private static final double CALORIES_PER_KG = 7700;

    public void estimateDuration(double tdee, double adjustedCalories, double targetKg, int goal) {
        double dailyDifference = Math.abs(adjustedCalories - tdee);

        if (dailyDifference < 100) {
            System.out.println("⚠️ Calorie difference is too small for significant weight change.");
            return;
        }

        double totalCaloriesNeeded = targetKg * CALORIES_PER_KG;
        int totalDays = (int) Math.round(totalCaloriesNeeded / dailyDifference);
        int months = totalDays / 30;
        int days = totalDays % 30;
        LocalDate targetDate = LocalDate.now().plusDays(totalDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        System.out.printf("Estimated time to %s %.1f kg: %d month(s) and %d day(s)%n",
                (goal == 1 ? "lose" : "gain"), targetKg, months, days);
        System.out.println("Target date: " + targetDate.format(formatter));
    }

}

