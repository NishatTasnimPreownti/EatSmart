import java.util.List;
import java.util.Random;

class ChallengeService {
    private final List<String> challenges = List.of(
            "No sugar today!",
            "Drink 8 glasses of water!",
            "Eat 5 different colors of fruits and veggies!",
            "Take a 20-minute walk!",
            "No fried food today!",
            "Skip processed foods today!",
            "Stretch for 10 minutes!",
            "Try a new healthy recipe!",
            "Go to bed 30 minutes earlier!",
            "Limit screen time to 1 hour before bed!",
            "Do 20 squats!",
            "Eat a high-protein breakfast!",
            "No sugary drinks today!",
            "Spend 10 minutes meditating!",
            "Take deep breaths for 5 minutes!",
            "Eat mindfully—no distractions during meals!",
           
    );

    public void showRandomChallenge() {
        Random rand = new Random();
        String challenge = challenges.get(rand.nextInt(challenges.size()));
        System.out.println("Today's Challenge: " + challenge);
    }
}