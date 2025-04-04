public class CalorieCalculator {

    public double calculateBMR(String sex, double weight, double height, int age) {
        validateSex(sex);

        if (sex.equalsIgnoreCase("male")) {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }
    }

    public double calculateTDEE(double bmr, int activityLevel) {
        return bmr * getActivityFactor(activityLevel);
    }

    private double getActivityFactor(int level) {
        return switch (level) {
            case 1 -> 1.2;
            case 2 -> 1.375;
            case 3 -> 1.55;
            case 4 -> 1.725;
            case 5 -> 1.9;
            default -> throw new IllegalArgumentException("⚠️ Invalid activity level: " + level);
        };
    }

    private void validateSex(String sex) {
        if (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("⚠️ Invalid input for sex. Only 'male' or 'female' are allowed.");
        }
    }
}
