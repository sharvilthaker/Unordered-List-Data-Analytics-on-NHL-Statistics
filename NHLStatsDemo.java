import java.io.IOException;
import java.util.Scanner;

public class NHLStatsDemo {
    public static void main(String[] args) {
        NHLStats nhlStats = new NHLStats();
        Scanner scanner = new Scanner(System.in);

        try {
            // Load NHL stats data
            System.out.print("Enter the filename for NHL stats data: ");
            String filename = scanner.nextLine();
            nhlStats.loadFromFile(filename);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
            return;
        }

        // Display all players
        nhlStats.displayAllPlayers();

        // Display top scorer
        nhlStats.displayTopScorer();

        // Search for a specific player
        System.out.print("Enter a player's name to search for: ");
        String playerName = scanner.nextLine();
        nhlStats.displayPlayer(playerName);
    }
}
