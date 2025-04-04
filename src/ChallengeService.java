import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChallengeService {
    private static final String CHALLENGE_FILE = "challenge.txt";
    private final ChallengeRepository challengeRepository;

    public ChallengeService() {
        this.challengeRepository = new ChallengeRepository(CHALLENGE_FILE);
    }

    public void showRandomChallenge() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        String challenge = challengeRepository.getRandomChallenge();

        System.out.println("Daily Challenge for " + today + ":");
        System.out.println("-> " + challenge);
    }
}