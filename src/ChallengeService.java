import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ChallengeService {
    private static final String CHALLENGE_FILE = "challenge.txt";
    private final Scanner scanner;
    private final Random random;

    public ChallengeService() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void showRandomChallenge() {
        System.out.print("View challenge for:\n1) Today\n2) Whole Week\nChoose [1-2]: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> showTodayChallenge();
            case "2" -> showWeeklyChallenges();
            default -> {
                System.out.println("⚠️ Invalid choice. Showing today's challenge by default.");
                showTodayChallenge();
            }
        }
    }

    private void showTodayChallenge() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        String challenge = getRandomChallenge();
        System.out.println("\nDaily Challenge for " + today + ":");
        System.out.println("-> " + challenge);
    }

    public void showWeeklyChallenges() {
        List<String> allChallenges = getAllChallenges();
        if (allChallenges.isEmpty()) {
            System.out.println("⚠️ No challenges available to schedule.");
            return;
        }

        LocalDate startDate = LocalDate.now();

        System.out.println("\nWeekly Challenge Schedule:");
        System.out.println("+----------------------+----------------------------------------------+");
        System.out.println("|        Date          |                  Challenge                   |");
        System.out.println("+----------------------+----------------------------------------------+");

        for (int i = 0; i < 7; i++) {
            LocalDate day = startDate.plusDays(i);
            String formattedDate = day.format(DateTimeFormatter.ofPattern("EEEE, MMM dd"));
            String challenge = allChallenges.get(random.nextInt(allChallenges.size()));
            System.out.printf("| %-20s | %-44s |%n", formattedDate, challenge);
        }

        System.out.println("+----------------------+----------------------------------------------+");
    }

    private List<String> getAllChallenges() {
        List<String> challenges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CHALLENGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    challenges.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to read challenges: " + e.getMessage());
        }
        return challenges;
    }

    private String getRandomChallenge() {
        List<String> challenges = getAllChallenges();
        if (challenges.isEmpty()) {
            return "No challenges available.";
        }
        return challenges.get(random.nextInt(challenges.size()));
    }
}
