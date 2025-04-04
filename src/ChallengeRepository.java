import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChallengeRepository {
    private final String filePath;

    public ChallengeRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getAllChallenges() {
        List<String> challenges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    challenges.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading challenges: " + e.getMessage());
        }
        return challenges;
    }

    public String getRandomChallenge() {
        List<String> challenges = getAllChallenges();
        if (challenges.isEmpty()) {
            return "No challenges available.";
        }
        Random random = new Random();
        return challenges.get(random.nextInt(challenges.size()));
    }
}

