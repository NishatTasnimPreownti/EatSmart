public class GoalAdjuster {
    public double adjustCalories(double tdee, int goal) {
        return switch (goal) {
            case 1 -> tdee - 500;
            case 3 -> tdee + 300;
            default -> tdee;
        };
    }
}
